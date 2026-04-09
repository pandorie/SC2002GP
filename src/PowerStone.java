import java.util.List;

public class PowerStone extends Item {
    public PowerStone(int quantity) {
        super("PowerStone", quantity);
    };

    public void use(Player target, List<Enemy> enemy) {
        if(getQuantity() <= 0) {
            System.out.println("No power stones available!");
            return;
        }
        // Here we may need to watch out since I'm not sure
        // if you will make executeSpecialSkill() start the cooldown within the Player class.
        // By right, using PowerStone should not cause the cooldown to start.
        // So if you start the cooldown within the executeSpecialSkill() function, we will need to make changes here
        target.executeSpecialSkill(enemy);
        setQuantity(getQuantity() - 1);
    }

}
