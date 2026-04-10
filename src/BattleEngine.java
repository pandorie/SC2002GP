import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BattleEngine {
    private Player player;
    private Level level;
    private List<Enemy> enemies;
    private TurnScheduler turnScheduler;
//    private InputHandler input;

    public BattleEngine(Player player, Level level, TurnScheduler turnScheduler){
        this.player = player;
        this.level = level;
        this.turnScheduler = turnScheduler;
        this.enemies = new ArrayList<>(level.getInitialEnemies());
//        this.input = input;
    }

    public void StartBattle(){
        boolean BattleOver = false;

        while(!BattleOver){
            List<Combatant> CombatantList = new ArrayList<>();
            CombatantList.add(player);
            CombatantList.addAll(enemies);

            List<Combatant> turnOrder = turnScheduler.getOrder(CombatantList);

            for(Combatant currentCombatant: turnOrder){
                if(!currentCombatant.isAlive()){
                    continue;
                }
                System.out.println(currentCombatant.getName() + "'s Turn");

                currentCombatant.tickEffects();
                if(currentCombatant.isStunned()){
                    System.out.println(currentCombatant.getName() + " is Stunned for the turn");
                    continue;
                }

                if(currentCombatant instanceof Player){
//                    handlePlayerTurn();
                }
                else if (currentCombatant instanceof Enemy) {
                    ((Enemy) currentCombatant).takeTurn(this);
                }

//                UpdateGameState();

                BattleOver = CheckWinCondition();

                if(BattleOver){
                    break;
                }

            }
        }
    }

    public void playerTurn(){

    }

    public void UpdateGameState(){
        List<Enemy> SpawnEnemy = new ArrayList<>();

        Iterator<Enemy> iterator = enemies.iterator();
        while (iterator.hasNext()){
            Enemy enemy = iterator.next();
            if(!enemy.isAlive()){

            }
        }

    }

    public boolean CheckWinCondition(){
        if(!player.isAlive()){
            System.out.println(player.getName() + " has been defeated");
            return true;
        }
        else if(enemies.isEmpty() && !level.hasBackupWave()){
            System.out.println("Victory");
            return true;
        }
        return false;
    }

}
