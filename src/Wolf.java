public class Wolf extends Enemy {
    private static final String NAME = "Wolf";
    private static final int HP = 40;
    private static final int MAXHP = 40;
    private static final int ATK = 45;
    private static final int DEF = 5;
    private static final int SPD = 35;

    public Wolf() {
        super(NAME, HP, MAXHP, ATK, DEF, SPD);
        this.setBehaviour(new BasicAttackBehaviour());
    }
}