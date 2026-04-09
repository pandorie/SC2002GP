import java.util.List;

public interface Action {
    void execute(Combatant source, List<Combatant> targets);
    void getName(String name);
}
