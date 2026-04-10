import java.util.List;

public class Defend implements Action {

    @Override
    public void execute(Combatant source, List<Combatant> targets) {
        Player player = (Player) source;
        player.addEffects(new DefendEffect());
    }

    @Override
    public String getName() {
        return "Defend";
    }
}
