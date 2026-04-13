import java.util.List;

public class Wizard extends Player{
    private static final String NAME = "Wizard";
    private static final int HP = 200;
    private static final int MAXHP = 200;
    private static final int ATK = 50;
    private static final int DEF = 10;
    private static final int SPD = 20;
    private static final String SKILLNAME = "Arcane Blast";
    private int bonus_atk = 0;

    public Wizard() {
        super(NAME, HP, MAXHP, ATK, DEF, SPD, SKILLNAME);
    }

    public void executeSpecialSkill(List<Enemy> targets){
        for(Enemy target: targets){
            int damage = this.getAtk() - target.getDef();
            target.takeDamage(damage);
            System.out.println(this.getName() + " use Arcane Blast on " + target.getName() + " for " + damage);
            if(!target.isAlive()){
                ArcaneBlastEffect existingbuff = null;
                for(StatusEffect effect: this.getEffects()){
                    if(effect instanceof ArcaneBlastEffect){
                        existingbuff = (ArcaneBlastEffect) effect;
                        break;
                    }
                }

                if(existingbuff != null){
                    existingbuff.addStack(this);
                }
                else{
                    ArcaneBlastEffect firstStack = new ArcaneBlastEffect();
                    firstStack.apply(this);
                }
            }
        }
    }

    public int getBonus_atk() {
        return bonus_atk;
    }

    public void setBonus_atk(int bonus_atk) {
        this.bonus_atk = bonus_atk;
    }
}
