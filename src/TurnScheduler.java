import java.util.List;

public interface TurnScheduler {
    List<Combatant> getOrder(List<Combatant> combatants);
}
