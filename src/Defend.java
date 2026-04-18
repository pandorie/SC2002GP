import java.util.List;

public class Defend implements Action {

    @Override
    public void execute(Combatant source, List<Combatant> targets, GameLog log) {
        DefendEffect defendbuff = new DefendEffect();
        defendbuff.apply(source, log);
    }

    @Override
    public String getName() {
        return "Defend";
    }

    @Override
    public boolean requiresTarget(Combatant source) {
        return false;
    }
}
