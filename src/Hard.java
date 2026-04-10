public class Hard extends Level{
    public Hard(){
        super("Hard");
        this.addInitialEnemies(new Goblin());
        this.addInitialEnemies(new Goblin());
        this.addBackUpEnemy(new Goblin());
        this.addBackUpEnemy(new Wolf());
        this.addBackUpEnemy(new Wolf());
    }
}
