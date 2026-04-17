import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public Level SelectDifficulty() {
        Level selectedLevel = null;
        boolean isValid = false;

        do {
            System.out.println("Select Difficulty");
            System.out.println("1. Easy (Total Enemies:3, 3 Goblins)");
            System.out.println("2. Medium (Total Enemies:4, 1st Wave: 1 Goblin, 1 Wolf. 2nd Wave: 2 Wolves)");
            System.out.println("3. Hard (Total Enemies:5, 1st Wave: 2 Goblin. 2nd Wave: 1 Goblin, 2 Wolves)");
            System.out.println("Select a difficulty 1-3");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        selectedLevel = new Easy();
                        isValid = true;
                        break;
                    case 2:
                        selectedLevel = new Medium();
                        isValid = true;
                        break;
                    case 3:
                        selectedLevel = new Hard();
                        isValid = true;
                        break;
                    default:
                        System.out.println("Invalid Choice. Please enter 1-3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number");
                scanner.nextLine();
            }

        }
        while (!isValid);

        return selectedLevel;
    }


    public Action SelectAction(Player player) {
        Action selectedAction = null;
        boolean isValid = false;

        do {
            System.out.println("What will " + player.getName() + " do?");
            System.out.println("1. Basic Attack");
            System.out.println("2. Defend");
            System.out.println("3. " + player.getSkillName() + " Cooldown: " + player.getSkillCooldown());
            System.out.println("4. use Item");
            System.out.println("Select an Action: 1-4");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        selectedAction = new BasicAttack();
                        isValid = true;
                        break;
                    case 2:
                        boolean alreadyDefending = false;
                        for(StatusEffect effect: player.getEffects()){
                            if(effect instanceof DefendEffect){
                                alreadyDefending = true;
                                break;
                            }
                    }
                        if(alreadyDefending){
                            System.out.println("You are already defending. Choose a different action");
                        }
                        else {
                            selectedAction = new Defend();
                            isValid = true;
                        }
                            break;
                    case 3:
                        if(player.getSkillCooldown() > 0){
                            System.out.println("Skill is on cooldown. Choose a different action");
                        }
                        else{
                            selectedAction = new SpecialSkill();
                            isValid = true;
                        }
                        break;
                    case 4:
                        Item selectedItem = selectItem(player);
                        if(selectedItem != null){
                            selectedAction = new useItem(selectedItem);
                            isValid = true;
                        }
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number");
                scanner.nextLine();
            }
        }
        while (!isValid);
        return selectedAction;
    }

    public Item selectItem(Player player) {
        List<Item> inventory = player.getInventory();
        Item selectedItem = null;
        boolean isValid = false;

        if(inventory.isEmpty()){
            System.out.println("Inventory is Empty");
            return null;
        }

        do {
            System.out.println("Inventory");
            for (int i=0; i<inventory.size(); i++){
                System.out.println((i+1) +". " + inventory.get(i).getName() + " Quantity:" + inventory.get(i).getQuantity());
            }

            int cancelOption = inventory.size() +1;
            System.out.println(cancelOption + ".Cancel");
            System.out.println("Selection an Option 1-" + cancelOption);

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if(choice>0 && choice <= inventory.size()){
                    selectedItem = inventory.get(choice-1);
                    isValid = true;
                }
                else if(choice == cancelOption){
                    isValid=true;
                }
                else{
                    System.out.println("Invalid Choice");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a number");
                scanner.nextLine();
            }
        }
        while (!isValid);
        return selectedItem;

    }

    public Combatant selectTarget(List<Enemy> enemies) {
        Combatant selectedTarget = null;
        boolean isValid = false;

        do {
            System.out.println("Select Target");
            for(int i = 0; i < enemies.size(); i++){
                Enemy enemy = enemies.get(i);
                System.out.println((i+1) + "." + enemy.getName() + " Hp: " + enemy.getHp() + "/" + enemy.getMaxHp());
            }
            System.out.println("Select Target: (1-" + enemies.size() + ")");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                int index = choice -1;
                if(index >= 0 && index < enemies.size()){
                    selectedTarget = enemies.get(index);
                    isValid = true;
                }
                else{
                    System.out.println("Invalid target");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a number");
                scanner.nextLine();
            }
        }
        while (!isValid);

        return selectedTarget;

    }
}
