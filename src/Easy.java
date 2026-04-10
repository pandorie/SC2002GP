public class Easy extends Level{
    public Easy(){
        super("Easy");
        this.addInitialEnemies(new Goblin());
        this.addInitialEnemies(new Goblin());
        this.addInitialEnemies(new Goblin());
    }
}
