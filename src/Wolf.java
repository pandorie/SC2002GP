public class Wolf extends Enemy {
    private static final String name = "Wolf";
    private static final int hp = 40;
    private static final int maxHp = 40;
    private static final int atk = 45;
    private static final int def = 5;
    private static final int spd = 35;

    public Wolf() {
        super(name, hp, maxHp, atk, def, spd);
    }
}