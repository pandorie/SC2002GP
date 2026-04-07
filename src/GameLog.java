package arena.UI;

import arena.Model.Combatant;
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
            System.out.println(c.getName() + " | HP: " + c.getHp() + "/" + c.getMaxHp());
        }
    }

    public void showVictory(int maxHp, int currentHp, int round) {
        System.out.println("=== VICTORY ===");
        System.out.println("Rounds taken: " + round);
        System.out.println("HP remaining: " + currentHp + "/" + maxHp);
    }

    public void showDefeat(int remaining, int killed, int round) {
        System.out.println("=== DEFEAT ===");
        System.out.println("Rounds survived: " + round);
        System.out.println("Enemies remaining: " + remaining);
    }
}