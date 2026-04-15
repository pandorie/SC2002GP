public class StunEffect extends StatusEffect {
//    private String name = "name";

    public StunEffect() {
        super();
    }

    public void apply(Combatant c, GameLog log) {
        c.addEffects(this);
        log.showStatusApplied(c, "Stun Effect. Turn Skipped.");
    }

    public void tick(Combatant c) {
        this.setDuration(getDuration() - 1);
    }

    @Override
    public void removeEffect(Combatant c, GameLog log) {
        log.showStatusExpired(c, "Stun Effect");
    }


}
