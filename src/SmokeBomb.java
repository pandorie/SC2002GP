import java.util.List;

public class SmokeBomb extends Item {
    public SmokeBomb(int quantity) {
        super("SmokeBomb", quantity);
    };

    public void use(Player target, List<Enemy> enemy) {
        if(getQuantity() <= 0) {
            System.out.println("No smoke bombs available!");
            return;
        }
        //Insert method to activate smokebomb effect when we finish implementing it
        setQuantity(getQuantity() - 1);
    }

}
