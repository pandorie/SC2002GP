import java.util.List;

public class Defend implements Action {

    @Override
    public void execute(Combatant source, List<Combatant> targets) {
        DefendEffect defendbuff = new DefendEffect();
        defendbuff.apply(source);
    }

    @Override
    public String getName() {
        return "Defend";
    }
}
