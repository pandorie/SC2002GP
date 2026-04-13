public class Goblin extends Enemy {
    private static final int hp = 55;
    private static final int maxhp = 55;
    private static final int atk = 35;
    private static final int def = 15;
    private static final int spd = 25;


    public Goblin(String letter) {
        super("Goblin " + letter, hp, maxhp, atk, def, spd);
        this.setBehaviour(new BasicAttackBehaviour());
    }

}
