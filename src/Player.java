import java.util.ArrayList;
import java.util.List;

public abstract class Player extends Combatant {
    private List<Item> inventory;
    private int skillCooldown;
    private String skillName;

    public Player(String name, int hp, int maxhp, int atk, int def, int spd,String skillname) {
        super(name,hp,maxhp,atk,def,spd);
        this.inventory = new ArrayList<>();
        this.skillCooldown = 0;
        this.skillName = skillname;

    }

    public void useItem(Item item, List<Enemy> enemy){
        item.use(this, enemy);
    }

    public void executeSpecialSkill(List<Enemy> enemy){

    }

    public void decrementCoolDown(){
        this.setskillcooldown(getSkillCooldown()-1);
    }

    public int getSkillCooldown() {
        return skillCooldown;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setskillcooldown(int cooldown){
         this.skillCooldown = cooldown;
    }


}
