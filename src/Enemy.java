public abstract class Enemy extends Combatant {
//    private EnemyAction behaviour

    public Enemy(String name, int hp, int maxhp, int atk, int def, int spd){
        super(name,hp,maxhp,atk,def,spd);
    }

    public void takeTurn(){

    }
}
