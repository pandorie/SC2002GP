import java.util.List;

public class Potion extends Item {
    public Potion(int quantity) {
        super("Potion", quantity);
    };

    public void use(Player target, List<Enemy> enemy, GameLog log) {
        if(getQuantity() <= 0) {
            log.showActionResult("No potions available!");
            return;
        }
//        int newHP = Math.min(target.getHp() + 100, target.getMaxHp());
//        target.setHp(newHP);

        log.showActionResult(target.getName() + "->" + "Item" + "->" + this.getName());
        target.Heal(100);
        setQuantity(getQuantity() - 1);

    }

}
