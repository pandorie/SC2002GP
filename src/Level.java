import java.util.ArrayList;
import java.util.List;

public abstract class Level {
    private String LevelName;
    private List<Enemy> initialWave;
    private List<Enemy> backupWave;

    public Level(String levelName){
        this.LevelName = levelName;
        this.initialWave = new ArrayList<>();
        this.backupWave = new ArrayList<>();
    }


    public void addInitialEnemies(Enemy e){
        this.initialWave.add(e);
    }

    public void addBackUpEnemy(Enemy e){
        this.backupWave.add(e);
    }

    public boolean hasBackupWave(){
        return !(this.backupWave.isEmpty());
    }

    public Enemy triggerBackupSpawn(){
        if(!(this.hasBackupWave())){
            return null;
        }
        return this.backupWave.remove(0);
    }

    public void spawnInitialEnemies(String enemyType, int enemy_count){
        for(int i = 0; i<enemy_count; i++){
            String letter = String.valueOf((char) ('A' + i));
            switch(enemyType.toLowerCase()){
                case "goblin" -> this.addInitialEnemies(new Goblin(letter));
                case "wolf" -> this.addInitialEnemies(new Wolf(letter));
                default -> System.out.println("invalid enemy type: " + enemyType);
            }

        }
    }

    public void spawnBackupEnemies(String enemyType, int enemy_count){
        for(int i = 0; i<enemy_count; i++){
            String letter = String.valueOf((char) ('A' + i));
            switch(enemyType.toLowerCase()){
                case "goblin" -> this.addBackUpEnemy(new Goblin(letter));
                case "wolf" -> this.addBackUpEnemy(new Wolf(letter));
                default -> System.out.println("invalid enemy type: " + enemyType);
            }

        }
    }

    public Level getCopy(){
        return null;
    }




    //getters

    public String getLevelName() {
        return LevelName;
    }

    public List<Enemy> getBackupEnemies() {
        return backupWave;
    }

    public List<Enemy> getInitialEnemies() {
        return initialWave;
    }

    //setters


    public void setLevelName(String levelName) {
        LevelName = levelName;
    }

    public void setBackupWave(List<Enemy> backupWave) {
        this.backupWave = backupWave;
    }

    public void setInitialWave(List<Enemy> initialWave) {
        this.initialWave = initialWave;
    }
}
