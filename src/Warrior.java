import java.util.List;

public class Warrior extends Player {
    private static final String NAME = "Warrior";
    private static final int HP = 260;
    private static final int MAXHP = 260;
    private static final int ATK = 40;
    private static final int DEF = 20;
    private static final int SPD = 30;
    private static final String SKILLNAME = "Shield Bash";

    public  Warrior(){
        super(NAME, HP, MAXHP, ATK, DEF, SPD, SKILLNAME);
    }


    public void executeSpecialSkill(List<Enemy> targets, GameLog log){
        Enemy target = targets.get(0);
        int damage = this.getAtk() - target.getDef();
        target.takeDamage(damage);
        log.showActionResult(this.getName() + " uses " + this.getSkillName() + " " + target.getName() +
                " for " + damage);
        StunEffect stun = new StunEffect();
        stun.apply(target, log);
    }

    @Override
    public Player getCopy() {
        return new Warrior();
    }

    @Override
    public boolean skillsingleTarget() {
        return true;
    }
}
