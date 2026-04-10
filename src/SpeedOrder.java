import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SpeedOrder implements TurnScheduler {

    @Override
    public List<Combatant> getOrder(List<Combatant> combatants) {
        List<Combatant> CombatantList = new ArrayList<>(combatants);

        CombatantList.sort(new Comparator<Combatant>() {
            @Override
            public int compare(Combatant c1, Combatant c2) {
                return Integer.compare(c2.getSpd(), c1.getSpd());
            }
        });
        return CombatantList;
    }
}
