import java.util.List;

public class Defend implements Action {

    @Override
    public void execute(Combatant source, List<Combatant> targets) {
        Player player = (Player) source;
        DefendEffect defendbuff = new DefendEffect();
        defendbuff.apply(player);
    }

    @Override
    public String getName() {
        return "Defend";
    }
}
