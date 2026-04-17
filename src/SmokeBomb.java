import java.util.List;

public class SmokeBomb extends Item {
    public SmokeBomb(int quantity) {
        super("SmokeBomb", quantity);
    };

    public void use(Player target, List<Enemy> enemies, GameLog log) {
        if(getQuantity() <= 0) {
            log.showActionResult("No smoke bombs available!");
            return;
        }
        //Insert method to activate smokebomb effect when we finish implementing it
        log.showActionResult("Smoke Bomb used: Enemy attacks deal 0 damage this turn + next");
        for(Enemy enemy: enemies){
            if(enemy.isAlive()){
                SmokeBombEffect smokebomb = new SmokeBombEffect();
                smokebomb.apply(enemy, log);
            }
        }
        setQuantity(getQuantity() - 1);
    }

    @Override
    public Item getCopy() {
        return new SmokeBomb(1);
    }
}
