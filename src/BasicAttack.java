import java.util.List;

public class BasicAttack implements Action{

    @Override
    public void execute(Combatant source, List<Combatant> targets, GameLog log) {
        if(targets.isEmpty()){
            log.showActionResult("There is no target for basic attack");
            return;
        }
        Combatant target = targets.get(0);
        int damage = Math.max(0,source.getAtk() - target.getDef());
        target.takeDamage(damage);
        log.showAttack(source, target, damage);

        if(target.isDefeated()){
            log.showActionResult(target.getName() + " has been defeated");
        }
    }

    @Override
    public String getName() {
        return "Basic Attack";
    }

    @Override
    public boolean requiresTarget(Combatant source) {
        return true;
    }
}
