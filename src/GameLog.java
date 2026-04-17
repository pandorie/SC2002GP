
import java.util.ArrayList;
import java.util.List;

public  class GameLog {

    public void showRoundStart(int round) {
        System.out.println("Round " + round);
    }

    public void showTurnStart(Combatant c) {
        System.out.println(c.getName() + "'s Turn");
    }

    public void showActionResult(String msg) {
        System.out.println(msg);
    }

    public void showAttack(Combatant attacker, Combatant target, int damage) {
        System.out.println(attacker.getName() + " attacks " + target.getName() + " for " + damage);
    }

    public void showSkillUse(Player p) {
        System.out.println(p.getName() + " uses " + p.getSkillName());
    }

    public void showStatusApplied(Combatant c, String status) {
        System.out.println(c.getName() + " is affected by " + status);
    }

    public void showStatusExpired(Combatant c, String status) {
        System.out.println(status + " on " + c.getName() + " has expired");
    }

    public void showDefend(Combatant c, int bonusDef) {
        System.out.println(c.getName() + " Defends. Increasing Defense by " + bonusDef);
    }

    public void showBackupWave(List<String> spawnNames) {
        System.out.println("All initial enemies eliminated → Backup Spawn triggered! " + spawnNames + " enter simultaneously");
    }

    public void showCombatantStatus(List<Combatant> CombatantList, int round) {
        List<String> combatantInfo = new ArrayList<>();
        List<String> inventoryInfo = new ArrayList<>();
        Player player = null;

        for (Combatant c : CombatantList) {
            if (c instanceof Player) {
                player = (Player) c;
                combatantInfo.add(c.getName() + " Hp: " + c.getHp() + "/" + c.getMaxHp() + " Status:" + getStatus(c));
            } else {
                if (c.isAlive()) {
                    combatantInfo.add(c.getName() + " Hp:" + c.getHp() + " Status:" + getStatus(c));
                }
            }

        }

        if(player !=null){
            for(Item item: player.getInventory()){
                inventoryInfo.add(item.getName() + " :" + item.getQuantity());
            }

            inventoryInfo.add("Special Skill cooldown: " + player.getSkillCooldown());
        }

        System.out.println("End of Round " + round + ":");
        System.out.println(String.join(" | ", combatantInfo));
        System.out.println(String.join(" | ", inventoryInfo));

    }

    public String getStatus(Combatant c){
        List<StatusEffect> effects = c.getEffects();

        if(effects == null || effects.isEmpty()){
            return "None";
        }

        List<String> Statuses = new ArrayList<>();

        for(StatusEffect effect : effects){
            if(effect instanceof StunEffect){
                Statuses.add("Stunned");
            }
            else if(effect instanceof SmokeBombEffect){
                Statuses.add("Smoked Bombed");
            }
            else if (effect instanceof DefendEffect) {
                Statuses.add("Defending");
            }
            else if(effect instanceof ArcaneBlastEffect){
                ArcaneBlastEffect arcaneStack = (ArcaneBlastEffect) effect;
                Statuses.add("Arcane Stack:" +arcaneStack.getStacks());
            }
        }

        return " " + String.join(" ", Statuses);
    }

    public void checkFinalResult(Player player,int totalRounds, int remainingEnemies){
        if(player.isAlive()){
            System.out.println("Congratulations you won");
            System.out.println("Remaining Hp: " + player.getHp());
            System.out.println("Total Rounds: " + totalRounds);
        }
        else{
            System.out.println("Defeated");
            System.out.println("Total Rounds: " + totalRounds);
            System.out.println("Remaining Enemies: " + remainingEnemies);
        }
    }
}