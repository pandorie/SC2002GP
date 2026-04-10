import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler(){
        this.scanner = new Scanner(System.in);
    }

    public Level SelectDifficulty(){
        Level selectedLevel = null;
        boolean isValid = false;

        do{
            System.out.println("Select Difficulty");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
            System.out.println("Select a difficulty 1-3");

            try{
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice){
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
            }
            catch(InputMismatchException e){
                System.out.println("Please enter a number");
                scanner.nextLine();
            }

        }
        while (!isValid);

        return selectedLevel;
    }


//    public Action SelectAction(Player player){
//
//    }
//
//    public Item selectItem(){
//
//    }
//
//    public Combatant selectTarget(List<Enemy> enemies){
//
//    }
}
