public class Goblin extends Enemy {
    private int hp;
    private int atk;
    private int def;
    private int spd;


    public Goblin(String name, int hp, int maxhp, int atk, int def, int spd) {
        super(name, hp, maxhp, atk, def, spd);
    }
}
