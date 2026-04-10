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
        System.out.println("Smoke Bomb used: Enemy attacks deal 0 damage this turn + next");

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
