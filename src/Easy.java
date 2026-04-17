public class Easy extends Level{
    public Easy(){
        super("Easy");

        this.spawnInitialEnemies("goblin", 3);
    }

    @Override
    public Level getCopy() {
        return new Easy();
    }
}
