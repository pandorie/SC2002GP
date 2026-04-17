import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    private InputHandler input;
    private Scanner scanner;
    private boolean isPlaying;
    private GameSession gameSession;

    public GameManager() {
        this.input = new InputHandler();
        this.scanner = new Scanner(System.in);
        this.isPlaying = true;
    }

    public void start() {
        System.out.println("Game started");
        handleMainMenu();

        scanner.close();
    }

    public void handleMainMenu() {
        System.out.println("1. Start Game");
        System.out.println("2. Exit");
        System.out.println("Select option 1-2");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            // Replaced with Enhanced switch statement
            switch (choice) {
                case 1 -> BattleSetUp();
                case 2 -> {
                    System.out.println("quitting the game");
                    isPlaying = false;
                }
                default -> System.out.println("Invalid choice");
            }

        } catch (InputMismatchException e) {
            System.out.println("Please type a Number");
            scanner.nextLine();
        }

    }

    public void BattleSetUp() {
        displayEnemyInfo();

        Level selectLevel = input.SelectDifficulty();

        Player player = selectCharacter();

        SelectStartingItem(player);
        List<Item>  startingItems = new ArrayList<>(player.getInventory());
        this.gameSession = new GameSession(player,selectLevel,startingItems);

        TurnScheduler turnScheduler = new SpeedOrder();

        BattleEngine game = new BattleEngine(player, selectLevel, turnScheduler, input);

        game.StartBattle();
        retry();

    }

    public Player selectCharacter() {
        Player player = null;
        boolean isValid = false;

        do {
            System.out.println("Select Class");
            System.out.println("1. Class: Warrior, Stats: HP: 260, ATK: 40, DEF: 20, SPD: 30 " +
                    "Special Skill: Shield Bash Effect: Deal BasicAttack damage to selected enemy. " +
                    "Selected enemy is unable to take actions for the current turn and the next turn.");
            System.out.println("2. Class: Wizard  Stats: HP: 200, ATK: 50, DEF: 10, SPD: 20 " +
                    "Special Skill: Arcane Blast Effect: Deal BasicAttack damage to all enemies " +
                    "currently in combat. Each enemy defeated by Arcane Blast adds 10 to the " +
                    "Wizard’s Attack, lasting until end of the level.");
            System.out.println("choose Class 1-2");

            try {
                int classChoice = scanner.nextInt();
                scanner.nextLine();

                // Replaced with Enhanced switch statement
                switch (classChoice) {
                    case 1 -> {
                        player = new Warrior();
                        isValid = true;
                    }
                    case 2 -> {
                        player = new Wizard();
                        isValid = true;
                    }
                    default -> System.out.println("Invalid Class");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a number");
            }
        }
        while (!isValid);

        return player;
    }

    public void SelectStartingItem(Player player) {
        System.out.println("Select 2 Starting Item");
        int count = 0;
        do {
            System.out.println("Select Item " + (count + 1) + " of 2:");
            System.out.println("1. Potion (Heals for 100Hp)");
            System.out.println("2. Smoke Bomb (When used, Enemy attacks do 0 damage in the current turn and the next turn)");
            System.out.println("3. Power Stone (Trigger the special skill effect once, but it does not start or change the cooldown timer)");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                // Replaced with Enhanced switch statement
                switch (choice) {
                    case 1 -> {
                        checkItemexist(player,new Potion(1));
                        count++;
                    }
                    case 2 -> {
                        checkItemexist(player,new SmokeBomb(1));
                        count++;
                    }
                    case 3 -> {
                        checkItemexist(player,new PowerStone(1));
                        count++;
                    }
                    default -> System.out.println("Invalid choice");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a number");
                scanner.nextLine();
            }

        } while (count < 2);

    }

    public void displayEnemyInfo(){
        System.out.println("Goblin:");
        System.out.println("Attributes: Hp:55 | Atk: 35 | Def: 15 | Spd: 25");
        System.out.println("Wolf:");
        System.out.println("Attributes: Hp:40 | Atk: 45 | Def: 5| Spd 35");
    }

    public void retry(){
        System.out.println("1.Retry?");
        System.out.println("2.New game");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    Player player = gameSession.getNewPlayer();
                    Level level = gameSession.getNewlevel();
                    List<Item> items = gameSession.getNewItems();
                    for(Item item: items){
                        checkItemexist(player, item);
                    }

                    TurnScheduler turnScheduler = new SpeedOrder();
                    BattleEngine retry  = new BattleEngine(player,level,turnScheduler,input);
                    retry.StartBattle();
                    retry();
                    break;
                case 2:
                    handleMainMenu();
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number");
            scanner.nextLine();
            retry();
        }


    }

    //Added check for quantity
    public void checkItemexist(Player player, Item selectedItem){
        for(Item exisitItem: player.getInventory()){
            if(exisitItem.getName().equals(selectedItem.getName())){
                exisitItem.setQuantity(exisitItem.getQuantity() + selectedItem.getQuantity());
                return;
            }

        }
        player.addItem(selectedItem);
    }


}