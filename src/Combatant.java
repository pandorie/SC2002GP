import java.util.Iterator;
import java.util.List;

public abstract class Combatant {
    private String name;
    private int Hp;
    private int maxHp;
    private int atk;
    private int def;
    private int spd;
    private List<StatusEffect> effects;


    public Combatant(String name, int hp, int maxhp, int atk, int def, int spd){
        this.name = name;
        this.Hp = hp;
        this.maxHp = maxhp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
    }


    public void takeDamage(int damage){
        if(damage == 0){
            return;
        }
        else if(damage > getDef()){

            setHp(getHp()-(damage - getDef()));
        }
        else{
            // dmg lower than def so nothing happens
        }
    }

    public void Heal(int amount){
        if(getHp() == getMaxHp()){
            System.out.println("already maxed hp");
        }
        else if(getHp() < getMaxHp()){
            if(getHp() + amount >= getMaxHp()){
                setHp(getMaxHp());
            }
            else{
                setHp(getHp() + amount);
            }
        }
    }

//    public void applyEffect(e statusEffect){
//
//    }

    public void tickEffects(){
        // effects duration - 1 in here
        Iterator<StatusEffect> iterator = this.effects.iterator();

        while(iterator.hasNext()){
            StatusEffect effect = iterator.next();
            effect.tick(this);

            if(effect.isExpired()){
                effect.removeEffect(this);
                iterator.remove();
            }
        }
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

    public List<StatusEffect> getEffects(){
        return this.effects;
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

    public void addEffects(StatusEffect effect){
        this.effects.add(effect);
    }
}
