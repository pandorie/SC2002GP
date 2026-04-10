import java.util.ArrayList;
import java.util.List;

public class SpecialSkill implements Action {
//    private String Name = "SpecialSkill";
    @Override
    public void execute(Combatant source, List<Combatant> targets) {
        if(source instanceof Player){
            Player player = (Player) source;
            if(player.getSkillCooldown() >0){
                System.out.println(player.getName() + " tried to use " + player.getSkillName() +
                        ", but it is on cooldown for " + player.getSkillCooldown() + " turn");
                return;
            }
            else{
                List<Enemy> enemyTargets = new ArrayList<>();
                for(Combatant c: targets){
                    if(c instanceof Enemy) {
                        enemyTargets.add((Enemy) c);
                    }
                }
                System.out.println(player.getName() + " uses " + player.getSkillName());
                player.executeSpecialSkill(enemyTargets);
                // if I put cd here then powerstone will be able to just call skill
                player.setskillcooldown(3);
            }
        }

    }

    @Override
    public String getName() {
        return "Special Skill";
    }
}
