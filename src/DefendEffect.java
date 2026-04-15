public class DefendEffect extends StatusEffect {
    private final int Bonus_def = 10;

    public DefendEffect(){
        super();

    }

    @Override
    public void apply(Combatant c, GameLog log) {
        c.addEffects(this);
        c.setDef(c.getDef() + Bonus_def);
        log.showDefend(c, Bonus_def);
    }

    @Override
    public void tick(Combatant c) {
        this.setDuration(getDuration() - 1);
    }

    @Override
    public void removeEffect(Combatant c, GameLog log) {
        c.setDef(c.getDef() - Bonus_def);
        log.showStatusExpired(c, "Defend");
    }
}
