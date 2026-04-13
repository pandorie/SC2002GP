public class Medium extends Level{
    public Medium(){
        super("Medium");
        this.spawnInitialEnemies("goblin", 1);
        this.spawnInitialEnemies("wolf", 1);
        this.spawnBackupEnemies("wolf", 2);
    }
}
