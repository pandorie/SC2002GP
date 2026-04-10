public class StunEffect extends StatusEffect {
//    private String name = "name";

    public StunEffect() {
        super();
    }

    public void apply(Combatant c) {
        c.addEffects(this);
        System.out.println(c.getName() + " is Stunned. Turn skipped");
    }

    public void tick(Combatant c) {
        this.setDuration(getDuration() - 1);
    }

    @Override
    public void removeEffect(Combatant c) {
        System.out.println(c.getName() + "is no longer stunned");
    }


}
