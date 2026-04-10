
import java.util.List;

public class GameLog {
    public void showRoundState(int round) {
        System.out.println("=== Round " + round + " ===");
    }

    public void showActionResult(String result) {
        System.out.println(result);
    }

    public void showCombatantStatus(List<Combatant> combatants) {
        for (Combatant c : combatants) {
            if (c.isDefeated()) {
                System.out.println(c.getName() + " | ELIMINATED");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(c.getName())
                .append(" | HP: ").append(c.getHp()).append("/").append(c.getMaxHp());
                if (c.isStunned()) sb.append(" [STUNNED]");
                if (c.isShielded()) sb.append(" [DEFENDING]");
                System.out.println(sb.toString());
            }
        }
    }

    public void showRoundSummary(int round, List<Combatant> allCombatants, arena.Model.Player player) {
        System.out.println();
        System.out.println("--- End of Round " + round + " ---");
        for (Combatant c : allCombatants) {
            if (c.isDefeated()) {
                System.out.println(c.getName() + " | ELIMINATED");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(c.getName())
                .append(" | HP: ").append(c.getHp()).append("/").append(c.getMaxHp());
                if (c.isStunned()) sb.append(" [STUNNED]");
                if (c.isShielded()) sb.append(" [DEFENDING]");
                System.out.println(sb.toString());
            }
        }
        if (player != null) {
            System.out.println("Special Skill Cooldown: " + player.getSkillCooldown() + " round(s)");
            for (arena.Items.Item item : player.getItems()) {
                System.out.println(item.getName() + ": " + (item.isUsed() ? "0 (used)" : "1"));
            }
            if (player instanceof arena.Model.Wizard) {
                int bonus = ((arena.Model.Wizard) player).getArcaneBonus();
                if (bonus > 0) {
                    System.out.println("Arcane Blast ATK Bonus: +" + bonus);
                }
            }
        }
    }

    public void showVictory(int maxHp, int currentHp, int round, java.util.List<arena.Items.Item> items) {
        System.out.println("========================================");
        System.out.println("          CONGRATULATIONS!");
        System.out.println("  You have defeated all your enemies.");
        System.out.println("========================================");
        System.out.println("Remaining HP  : " + currentHp + " / " + maxHp);
        System.out.println("Total Rounds  : " + round);
        if (items != null) {
            for (arena.Items.Item item : items) {
                System.out.println(item.getName() + " remaining: " + (item.isUsed() ? 0 : 1));
            }
        }
        System.out.println("========================================");
        System.out.println();
    }

    public void showDefeat(int enemiesRemaining, int round) {
        System.out.println("========================================");
        System.out.println("             DEFEATED.");
        System.out.println("       Don't give up, try again!");
        System.out.println("========================================");
        System.out.println("Enemies Remaining : " + enemiesRemaining);
        System.out.println("Total Rounds Survived: " + round);
        System.out.println("========================================");
        System.out.println();
    }
}