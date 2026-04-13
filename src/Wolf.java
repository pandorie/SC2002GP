public class Wolf extends Enemy {
    private static final int hp = 40;
    private static final int maxHp = 40;
    private static final int atk = 45;
    private static final int def = 5;
    private static final int spd = 35;

    public Wolf(String letter) {
        super("Wolf " + letter, hp, maxHp, atk, def, spd);
        this.setBehaviour(new BasicAttackBehaviour());
    }
}