public class Hard extends Level{
    public Hard(){
        super("Hard");
        this.spawnInitialEnemies("goblin", 2);
        this.spawnBackupEnemies("goblin", 1);
        this.spawnBackupEnemies("wolf", 2);
    }
}
