public class Goblin extends Enemy {
    private static final int HP = 55;
    private static final int MAXHP = 55;
    private static final int ATK = 35;
    private static final int DEF = 15;
    private static final int SPD = 25;


    public Goblin(String letter) {
        super("Goblin" + letter, HP, MAXHP, ATK, DEF, SPD);
        this.setBehaviour(new BasicAttackBehaviour());
    }

}
