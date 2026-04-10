public class Medium extends Level{
    public Medium(){
        super("Medium");
        this.addInitialEnemies(new Goblin());
        this.addInitialEnemies(new Wolf());
        this.addBackUpEnemy(new Wolf());
        this.addBackUpEnemy(new Wolf());
    }
}
