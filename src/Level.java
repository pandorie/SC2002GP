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
