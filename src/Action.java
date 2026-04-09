import java.util.List;

public interface Action {
    void execute(Combatant source, List<Combatant> targets);
    String getName(String name);
}
