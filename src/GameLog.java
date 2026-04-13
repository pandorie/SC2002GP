
import java.util.ArrayList;
import java.util.List;

public  class GameLog {


    public void showRoundStart(int round) {
        System.out.println("Round " + round);
    }

    public void showActionResult(String msg) {
        System.out.println(msg);
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
        System.out.println(String.join(" | ", inventoryInfo) + "\n");

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


    public void checkFinalResult(Player player){
        if(player.isAlive()){
            System.out.println("Congratulations you won");
        }
        else{
            System.out.println("Defeated");
        }
    }







}