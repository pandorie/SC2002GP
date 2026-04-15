public class SmokeBombEffect extends StatusEffect{
    private int OriginalAttack;

    public SmokeBombEffect(){
        super();
    }

    @Override
    public void apply(Combatant c, GameLog log) {
        c.addEffects(this);
        this.OriginalAttack = c.getAtk();
        c.setAtk(0);
        log.showStatusApplied(c, "Smoke Bomb");
    }

    @Override
    public void tick(Combatant c) {
        this.setDuration(getDuration() - 1);
    }

    @Override
    public void removeEffect(Combatant c, GameLog log) {
        c.setAtk(this.OriginalAttack);
        log.showStatusExpired(c, "Smoke Bomb");
    }
}
