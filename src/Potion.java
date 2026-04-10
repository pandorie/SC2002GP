import java.util.List;

public class Potion extends Item {
    public Potion(int quantity) {
        super("Potion", quantity);
    };

    public void use(Player target, List<Enemy> enemy) {
        if(getQuantity() <= 0) {
            System.out.println("No potions available!");
            return;
        }
//        int newHP = Math.min(target.getHp() + 100, target.getMaxHp());
//        target.setHp(newHP);

        System.out.println(target.getName() + "->" + "Item" + "->" + this.getName());
        target.Heal(100);

        setQuantity(getQuantity() - 1);

    }

}
