import java.util.List;

public class SmokeBomb extends Item {
    public SmokeBomb(int quantity) {
        super("SmokeBomb", quantity);
    };

    public void use(Player target, List<Enemy> enemies) {
        if(getQuantity() <= 0) {
            System.out.println("No smoke bombs available!");
            return;
        }
        //Insert method to activate smokebomb effect when we finish implementing it
        System.out.println("Smoke Bomb used: Enemy attacks deal 0 damage this turn + next");
        for(Enemy enemy: enemies){
            if(enemy.isAlive()){
                SmokeBombEffect smokebomb = new SmokeBombEffect();
                smokebomb.apply(enemy);
            }
        }
        setQuantity(getQuantity() - 1);
    }

}
