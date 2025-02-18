import java.util.Random;
import java.util.Scanner;

public class BlackjackDiceGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int userN = roll(random);

        int machineN = roll(random);


        System.out.println("You start with a: " + userN);

        while (true) {
            if (!userLogicCheck(userN)) {
                return;
            }

            String input = getUserChoice(scanner);
            if (input.equals("y")) {
                int newRoll = roll(random);
                userN += newRoll;

                if (!userLogicCheck(userN)) {
                    return;
                }

                System.out.println("You now have: " + userN);
            } else {
                machineN = machineLogicCheck(machineN, random);
                calculate(machineN, userN);
                return;
            }
        }



    }
    public static void calculate(int machineN, int userInt) {

        if (userInt > machineN) {
            System.out.println("you win");
        } else if (userInt == machineN) {
            System.out.println("It is a draw");
        } else {
            System.out.println("Machine win!"); // machine vinder stadig hvis den exceeder. // evt sæt det op ligesom userlogic
        }
        System.out.println("you got " + userInt);
        System.out.println("Machine got " + machineN);
    }


    public static int machineLogicCheck(int machineN, Random random) { // evt kør boolean ligesom userlogic, og calculate hvis true
        while (true) {
            if (machineN <= 16) {
                machineN += roll(random);

            } else if (machineN > 21) {
                System.out.println("Machine exceeded 21, You win!");
                return machineN;
            } else {
                return machineN;
            }

        }
    }

    public static boolean userLogicCheck(int userN){
        if (userN == 21) {
            System.out.println("blackjack! You win!");
            return false;
        } else if (userN > 21) {
            System.out.println("You exceeded 21, Machine win!");
            return false;
        } else {
            return true;
        }
    }

    public static int roll(Random random){
        return random.nextInt(1, 7) + random.nextInt(1, 7);

    }
    public static String getUserChoice(Scanner scanner) {
        while (true) {
            System.out.println("Do you want to roll again y/n");
            String userInput = scanner.nextLine().trim().toLowerCase();
            if (userInput.equals("y") || userInput.equals("n")) {
                return userInput;
            }
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
        }
    }
}
