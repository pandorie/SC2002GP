public abstract class Combatant {
    private String Name;
    private int Hp;
    private int maxHp;
    private int atk;
    private int def;
    private int spd;
//    private effects<>  implement when effects is added


    public Combatant(String name, int hp, int maxhp, int atk, int def, int spd){
        this.Name = name;
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

    public void applyEffect(e statusEffect){

    }

}
