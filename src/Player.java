public abstract class Player extends Combatant {
    //private List<Item> inventory add after item is added
    private int skillCooldown;

    public Player(String name, int hp, int maxhp, int atk, int def, int spd) {
        super(name,hp,maxhp,atk,def,spd);
//      this.inventory = new ArrayList; uncomment ater adding inventory
        this.skillCooldown = 0;
    }

//    public void useItem(item item){
//
//    } uncomment after item is added

    public void executeSpecialSkill(){

    }


}
