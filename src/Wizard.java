import java.util.List;

public class Wizard extends Player{
    private static final String name = "Wizard";
    private static final int hp = 200;
    private static final int maxhp = 200;
    private static final int atk = 50;
    private static final int def = 10;
    private static final int spd = 20;
    private static final String skillname = "Arcane Blast";

    public Wizard() {
        super(name, hp, maxhp, atk, def, spd, skillname);
    }

    public void specialSkill(List<Enemy> targets){

    }

}
