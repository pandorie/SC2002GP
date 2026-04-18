import java.util.List;

public interface Action {
    void execute(Combatant source, List<Combatant> targets, GameLog log);
    String getName();

    boolean requiresTarget(Combatant source);
}
