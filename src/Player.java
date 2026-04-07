public abstract class Player extends Combatant {
    //private List<Item> inventory add after item is added
    private int skillCooldown;
    private String skillName;

    public Player(String name, int hp, int maxhp, int atk, int def, int spd,String skillname) {
        super(name,hp,maxhp,atk,def,spd);
//      this.inventory = new ArrayList; uncomment ater adding inventory
        this.skillCooldown = 0;
        this.skillName = skillname;

    }

//    public void useItem(item item){
//
//    } uncomment after item is added

    public void executeSpecialSkill(){

    }

    public void decrementCoolDown(){

    }

    public void getItem(){

    }

    public int getSkillCooldown() {
        return skillCooldown;
    }

    public String getSkillName() {
        return skillName;
    }
}
