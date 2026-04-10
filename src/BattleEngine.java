import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BattleEngine {
    private Player player;
    private Level level;
    private List<Enemy> enemies;
    private TurnScheduler turnScheduler;
    private InputHandler input;

    public BattleEngine(Player player, Level level, TurnScheduler turnScheduler, InputHandler input) {
        this.player = player;
        this.level = level;
        this.turnScheduler = turnScheduler;
        this.enemies = new ArrayList<>(level.getInitialEnemies());
        this.input = input;
    }

    public void StartBattle() {
        boolean BattleOver = false;

        while (!BattleOver) {
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

                UpdateGameState();

                BattleOver = CheckWinCondition();

                if (BattleOver) {
                    break;
                }

            }
        }
    }

    //New Method
    public void playerTurn() {
        Action playerChoice = input.SelectAction(player);

        List<Combatant> EnemyList = new ArrayList<>();

        if (playerChoice instanceof BasicAttack || playerChoice instanceof SpecialSkill) {
            Combatant target = input.selectTarget(enemies);
            EnemyList.add(target);
        } else {
            EnemyList.addAll(enemies);
        }

        playerChoice.execute(player, EnemyList);

        if (player.getSkillCooldown() > 0) {
            player.decrementCoolDown();
        }

    }


    public void UpdateGameState() {

        Iterator<Enemy> iterator = enemies.iterator();
        while(iterator.hasNext()) {
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

    public boolean CheckWinCondition() {
        if (!player.isAlive()) {
            System.out.println(player.getName() + " has been defeated");
            return true;
        } else if (enemies.isEmpty() && !level.hasBackupWave()) {
            System.out.println("Victory");
            return true;
        }
        return false;
    }

}
