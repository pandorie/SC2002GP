import java.util.List;

public abstract class Warrior extends Player {
    private static final String name = "Warrior";
    private static final int hp = 260;
    private static final int maxhp = 260;
    private static final int atk = 40;
    private static final int def = 20;
    private static final int spd = 30;
    private static final String skillname = "Shield Bash";
    public  Warrior(){
        super(name, hp, maxhp,atk,def,spd,skillname);
    }


    public void SpecialSkill(List<Enemy> targets){

    }
}
