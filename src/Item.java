import java.util.List;

public abstract class Item {
    private int quantity;
    private String itemName;

    public Item(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getCopy(){
        return null;
    }

    public void use(Player target, List<Enemy> enemy, GameLog log) {

    }
}

