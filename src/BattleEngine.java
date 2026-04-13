import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BattleEngine {
    private Player player;
    private Level level;
    private List<Enemy> enemies;
    private TurnScheduler turnScheduler;
    private InputHandler input;
    private int round;
    private GameLog gameLog;

    public BattleEngine(Player player, Level level, TurnScheduler turnScheduler, InputHandler input) {
        this.player = player;
        this.level = level;
        this.turnScheduler = turnScheduler;
        this.enemies = new ArrayList<>(level.getInitialEnemies());
        this.input = input;
        this.round = 1;
        this.gameLog = new GameLog();
    }

    public BattleEngine(Player player, Level level, List<Enemy> enemies, TurnScheduler turnScheduler, InputHandler input) {
        this.player = player;
        this.level = level;
        this.enemies = enemies;
        this.turnScheduler = turnScheduler;
        this.input = input;
    }

    public void StartBattle() {
        boolean BattleOver = false;

        while (!BattleOver) {

            gameLog.showRoundStart(round);

            List<Combatant> CombatantList = new ArrayList<>();
            CombatantList.add(player);
            CombatantList.addAll(enemies);

            List<Combatant> turnOrder = turnScheduler.getOrder(CombatantList);

            for (Combatant currentCombatant : turnOrder) {
                if (!currentCombatant.isAlive()) {
                    continue;
                }
                System.out.println(currentCombatant.getName() + "'s Turn");

                currentCombatant.tickEffects();
                if (currentCombatant.isStunned()) {
                    System.out.println(currentCombatant.getName() + " is Stunned for the turn");
                    continue;
                }

                if (currentCombatant instanceof Player) {
                    playerTurn();
                } else if (currentCombatant instanceof Enemy) {
                    ((Enemy) currentCombatant).takeTurn(this);
                }
            }
            gameLog.showCombatantStatus(CombatantList, getRound());

            UpdateGameState();

            round++;

            BattleOver = CheckWinCondition();

            if (BattleOver) {
                break;
            }
        }
        gameLog.checkFinalResult(player);
    }

    //New Method
    public void playerTurn() {
        Action playerChoice = input.SelectAction(player);
        List<Combatant> EnemyList = new ArrayList<>();
        boolean needTarget = singleTarget(player, playerChoice);



        if(needTarget){
            Combatant target = input.selectTarget(enemies);
            EnemyList.add(target);
        }
        else{
            EnemyList.addAll(enemies);
            if(player instanceof Wizard && playerChoice instanceof SpecialSkill ||
                    player instanceof Wizard && playerChoice instanceof useItem &&
                            ((useItem)playerChoice).getSelectedItem() instanceof PowerStone){
                System.out.println("Arcane Blast hits all enemies");
            }
        }

        playerChoice.execute(player, EnemyList);

        if (player.getSkillCooldown() > 0) {
            player.decrementCoolDown();
        }

    }


    public void UpdateGameState() {

        Iterator<Enemy> iterator = enemies.iterator();
        while (iterator.hasNext()) {
            Enemy enemy = iterator.next();
            if (!enemy.isAlive()) {
                iterator.remove();
            }
        }

        if (enemies.isEmpty()) {
            if (level.hasBackupWave()) {

                List<String> SpawnNames = new ArrayList<>();

                while (level.hasBackupWave()) {
                    Enemy backup = level.triggerBackupSpawn();

                    SpawnNames.add(backup.getName() + " (Hp:" + backup.getHp() + ")");
                    enemies.add(backup);
                }
                System.out.println("All initial enemies eliminated → Backup Spawn triggered! " + SpawnNames + " enter simultaneously");

            }
        }


    }


    public boolean singleTarget(Player player, Action choice){
        if(choice instanceof BasicAttack){
            return true;
        }
        if(choice instanceof SpecialSkill){
            return player instanceof Warrior;
        }

        if(choice instanceof useItem){
            Item selectedItem = ((useItem) choice).getSelectedItem();
            if(selectedItem instanceof PowerStone){
                return player instanceof Warrior;
            }
        }
        return false;
    }


    public boolean CheckWinCondition() {
        if (!player.isAlive()) {
            System.out.println(player.getName() + " has been defeated");
            return true;
        } else if (enemies.isEmpty() && !level.hasBackupWave()) {
            return true;
        }
        return false;
    }

    public Player getPlayer() {
        return this.player;
    }

    public int getRound() {
        return round;
    }
}
