public abstract class Enemy extends Combatant {
    private EnemybehaviourStrategy behaviour;

    public Enemy(String name, int hp, int maxhp, int atk, int def, int spd){
        super(name,hp,maxhp,atk,def,spd);
    }

    public void takeTurn(BattleEngine context){
        Action chooseAction = behaviour.decideAction(this, context);
        System.out.println(this.getName() + "uses " + chooseAction.getName());
    }
}
