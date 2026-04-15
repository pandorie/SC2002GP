public class ArcaneBlastEffect extends StatusEffect{
    //New attributes
    private int stacks;
    private int bonusAtk;
    public ArcaneBlastEffect(){
        super();
        this.stacks = 1;
        this.bonusAtk = 10;
    }

    @Override
    public void apply(Combatant c, GameLog log) {
        c.addEffects(this);
        this.addBonusAttack(c);
    }

    //New Method to add bonus atk by calling this
    public void addBonusAttack(Combatant c){
        c.setAtk(c.getAtk() + bonusAtk);
    }

    //New Methods to add stack to arcane for bonus atk
    public void addStack(Combatant c){
        setStacks(getStacks() + 1);
        addBonusAttack(c);

    }

    @Override
    public void tick(Combatant c) {
        //doesnt decrease so this method is not needed
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public void removeEffect(Combatant c, GameLog log) {
        c.setAtk(c.getAtk() - (stacks * bonusAtk));
    }
    //Added get and set for stacks
    public int getStacks() {
        return stacks;
    }

    public void setStacks(int stacks) {
        this.stacks = stacks;
    }
}
