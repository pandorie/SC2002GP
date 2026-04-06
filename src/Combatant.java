public abstract class Combatant {
    private String name;
    private int Hp;
    private int maxHp;
    private int atk;
    private int def;
    private int spd;
//    private effects<>  implement when effects is added


    public Combatant(String name, int hp, int maxhp, int atk, int def, int spd){
        this.name = name;
        this.Hp = hp;
        this.maxHp = maxhp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
    }


    public void takeDamage(int damage){

    }

    public void Heal(int amount){

    }

//    public void applyEffect(e statusEffect){
//
//    }

    public void tickEffects(){

    }

    public boolean isAlive(){
        return true;
    }

    public boolean isStunned(){
        return true;
    }


    public String getName(){
        return this.name;
    }

    public int getHp(){
        return this.Hp;
    }

    public int getMaxHp(){
        return this.maxHp;
    }

    public int getAtk(){
        return this.atk;
    }

    public int getDef(){
        return this.def;
    }

    public int getSpd(){
        return this.spd;
    }



    //setters


    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        Hp = hp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }
}
