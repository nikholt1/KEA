
import java.util.Random;
import java.util.Scanner;

public class BlackJackDiceGame2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int userN = roll(random);

        int machineN = roll(random);


        System.out.println("You start with a: " + userN);

        while (true) {
            if (!userLogicCheck(userN)) {  // Exit if user is over 21 or gets blackjack
                return;
            }

            String input = getUserChoice(scanner);
            if (input.equals("y")) {
                int newRoll = roll(random);
                userN += newRoll;

                if (!userLogicCheck(userN)) {  // Check again before printing
                    return;
                }

                System.out.println("You now have: " + userN);
            } else {
                machineN = machineLogicCheck(machineN, random);
                calculate(machineN, userN);
                return;  // Exit after calculating the winner
            }
        }



    }
    public static void calculate(int machineN, int userInt) {
        System.out.println("Machine got " + machineN + " you got " + userInt);
        if (userInt > machineN) {
            System.out.println("you win");
        } else {
            System.out.println("machine wins");
        }

    }


    public static int machineLogicCheck(int machineN, Random random) {
        while (true) {
            if (machineN <= 16) {
                machineN += roll(random);

            } else if (machineN > 21) {
                System.out.println("machine exceeded 21, you won");
                return machineN;
            } else {
                return machineN;
            }

        }
    }


    public static boolean userLogicCheck(int userN){
        if (userN == 21) {
            System.out.println("blackjack");
            return false;
        } else if (userN > 21) {
            System.out.println("you exceeded 21");
            return false;
        } else {
            return true;
        }
    }


    public static int roll(Random random){
        // 2 dice beregning return
        return random.nextInt(1, 7) + random.nextInt(1, 7);

    }
    public static String getUserChoice(Scanner scanner) {
        while (true) {
            String userInput = scanner.nextLine().trim().toLowerCase();
            if (userInput.equals("y") || userInput.equals("n")) {
                return userInput;
            }
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
        }
    }
}
