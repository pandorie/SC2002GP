public class DefendEffect extends StatusEffect {
    private final int Bonus_def = 10;

    public DefendEffect(){
        super();
    }

    @Override
    public void apply(Combatant c) {
        c.addEffects(this);
        c.setDef(getDuration() + Bonus_def);
        System.out.println(c.getName() + " Defends. Increasing Defense by " + Bonus_def);
    }

    @Override
    public void tick(Combatant c) {
        this.setDuration(getDuration() - 1);
    }

    @Override
    public void removeEffect(Combatant c) {
        c.setDef(c.getDef() - Bonus_def);
        System.out.println(c.getName() + " Defends wore off. Defend has returned to normal");
    }
}
