import java.util.ArrayList;
import java.util.List;

public class useItem implements Action {
    private Item SelectedItem;

    public useItem(Item SelectedItem) {
        this.SelectedItem = SelectedItem;
    }

    @Override
    public void execute(Combatant source, List<Combatant> targets) {
        if (source instanceof Player) {
            Player player = (Player) source;
            List<Enemy> enemy = new ArrayList<>();
            for (Combatant c : targets) {
                if (c instanceof Enemy) {
                    enemy.add((Enemy) c);
                }
            }
            SelectedItem.use(player, enemy);
            if(SelectedItem.getQuantity() <= 0){
                player.removeItem(SelectedItem);
            }

        } else {
            return;
        }
    }

    @Override
    public String getName() {
        return "useItem";
    }

    public Item getSelectedItem() {
        return SelectedItem;
    }
}
