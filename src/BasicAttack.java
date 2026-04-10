import java.util.List;

public class BasicAttack implements Action{

    @Override
    public void execute(Combatant source, List<Combatant> targets) {
        if(targets.isEmpty()){
            System.out.println("There is no target for basic attack");
            return;
        }
        Combatant target = targets.get(0);
        int damage = source.getAtk() - target.getDef();
        target.takeDamage(damage);
        System.out.println(source.getName() + "attacks" + target.getName() + " for " + damage );
    }

    @Override
    public String getName() {
        return "BasicAttack";
    }
}
