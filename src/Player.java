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

    public void useItem(Item item, List<Enemy> enemy, GameLog log){
        item.use(this, enemy, log);
    }

    public void executeSpecialSkill(List<Enemy> enemy, GameLog log){

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

    public List<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item){
        this.inventory.add(item);
    }

    public void removeItem(Item item){
        this.inventory.remove(item);
    }

    public Player getCopy(){
        return null;
    }

    public boolean skillsingleTarget(){
        return false;
    };


}
