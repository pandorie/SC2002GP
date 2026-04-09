public class StunEffect extends StatusEffect {
    private String name = "name";

    public StunEffect() {
        super();
    }

    public void apply(Combatant c) {
        c.addEffects(this);
    }

    public void tick(Combatant c) {
        this.setDuration(getDuration() - 1);
    }

    public boolean isExpired() {
        if (getDuration() < 1) {
            return true;
        } else {
            return false;
        }
    }


}
