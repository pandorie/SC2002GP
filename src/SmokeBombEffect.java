public class SmokeBombEffect extends StatusEffect{
    private int OriginalAttack;

    public SmokeBombEffect(){
        super();
    }

    @Override
    public void apply(Combatant c) {
        c.addEffects(this);
        this.OriginalAttack = c.getAtk();
        c.setAtk(0);

    }

    @Override
    public void tick(Combatant c) {
        this.setDuration(getDuration() - 1);
    }

    @Override
    public void removeEffect(Combatant c) {
        c.setAtk(this.OriginalAttack);
        System.out.println("Smoke Bomb effect expires");
    }
}
