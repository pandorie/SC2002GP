import java.util.List;

public class Wizard extends Player{
    private static final String name = "Wizard";
    private static final int hp = 200;
    private static final int maxhp = 200;
    private static final int atk = 50;
    private static final int def = 10;
    private static final int spd = 20;
    private static final String skillname = "Arcane Blast";
    private int bonus_atk = 0;

    public Wizard() {
        super(name, hp, maxhp, atk, def, spd, skillname);
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
