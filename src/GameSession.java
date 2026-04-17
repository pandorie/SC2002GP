import java.util.ArrayList;
import java.util.List;

public class GameSession {
    private Player Oldplayer;
    private Level Oldlevel;
    private List<Item> OldItems;

    public GameSession(Player player,Level level, List<Item> item){
        this.Oldplayer = player;
        this.Oldlevel = level;
        this.OldItems = item;
    }

    public Player getNewPlayer(){
        return this.Oldplayer.getCopy();
    }

    public Level getNewlevel(){
        return Oldlevel.getCopy();
    }

    public List<Item> getNewItems(){
        List<Item> newItems = new ArrayList<>();

        for(Item items: this.OldItems){
            newItems.add(items.getCopy());
        }
        return newItems;
    }
}
