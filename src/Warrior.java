import java.util.List;

public class Warrior extends Player {
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


    public void executeSpecialSkill(List<Enemy> targets){
        Enemy target = targets.get(0);
        int damage = this.getAtk() - target.getDef();
        target.takeDamage(damage);
        System.out.println(this.getName() + " uses " + this.getSkillName() + " " + target.getName() +
                " for " + damage);
        StunEffect stun = new StunEffect();
        stun.apply(target);

    }
}
