package arena.UI;

import arena.Engine.BattleEngine;
import arena.Engine.Level;
import arena.Model.Combatant;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private BattleEngine engine;
    private GameLog log;
    private InputHandler input;

    public GameManager() {
        this.log = new GameLog();
        this.input = new InputHandler();
    }

    public void startGame() {
        int difficultyIndex = input.selectDifficulty(new String[]{"Easy", "Medium", "Hard"});
        Level level = loadGame(difficultyIndex);
        loadNextLevel(level);
    }

    public void loadNextLevel(Level level) {
        List<Combatant> combatants = new ArrayList<>();
        // Player selection would go here; for now add a default
        combatants.add(new arena.Model.Warrior());
        engine = new BattleEngine(combatants, new arena.Engine.SpeedOrder(), level, log, input);
        engine.run();
    }

    public Level loadGame(int difficultyIndex) {
        List<Level> levels = Level.getAllLevels();
        return levels.get(difficultyIndex);
    }
}