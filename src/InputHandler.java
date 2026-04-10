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
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
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
            System.out.println("What will " + player.getName() + "do?");
            System.out.println("1. Basic Attack");
            System.out.println("2. Defend");
            System.out.println("3. " + player.getSkillName() + " Cooldown: " + player.getSkillCooldown());
            System.out.println("4. use Item");
            System.out.println("Select a Action: 1-4");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        selectedAction = new BasicAttack();
                        isValid = true;
                        break;
                    case 2:
                        selectedAction = new Defend();
                        isValid = true;
                        break;
                    case 3:
                        if(player.getSkillCooldown() > 0){
                            System.out.println("Skill is on cooldown");
                        }
                        else{
                            selectedAction = new SpecialSkill();
                            isValid = true;
                        }
                        break;
                    case 4:
                        Item selectedItem = selectItem();
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

    public Item selectItem() {
        Item selectedItem = null;
        boolean isValid = false;

        do {
            System.out.println("Select 2 items to use in the level");
            System.out.println("1. Potion");
            System.out.println("2. Smoke Bomb");
            System.out.println("3. Power Stone");
            System.out.println("Select a Item: 1-3");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        selectedItem = new Potion(1);
                        isValid = true;
                        break;
                    case 2:
                        selectedItem = new SmokeBomb(1);
                        isValid = true;
                        break;
                    case 3:
                        selectedItem = new PowerStone(1);
                        isValid = true;
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
