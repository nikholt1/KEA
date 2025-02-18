import java.util.Random;
import java.util.Scanner;

public class BlackjackDiceGame {
    public static void main(String[] args) {
        // sætter final int BLACKJACK, da 21 altid er blackjack
        final int BLACKJACK = 21;
        // sætter final int roll start range for bedre debug og code control
        final int ROLL_START_RANGE = 1;
        // sætter final int roll end range for bedre debug og code control
        final int ROLL_END_RANGE = 7;
        // sætter final int machine hit threshold for bedre debug og code control
        final int MACHINE_HIT_THRESHOLD = 16;

        // Laver class scanner i main for ikke at åbne den flere steder
        Scanner scanner = new Scanner(System.in);
        // Laver class random i main for ikke at åbne den flere steder
        Random random = new Random();

        // caller gamelogic method og starter spillet
        while (true) {
            if (getUserChoice(scanner).equals("y")) {
                gameLogic(random, scanner, BLACKJACK, ROLL_START_RANGE, ROLL_END_RANGE, MACHINE_HIT_THRESHOLD);
            } else {
                System.out.println("-----Exiting game-----");
                break;
            }

        }


        // når spillet har nået slutning, lukker scanner
        scanner.close();
    }


    // Method: game logic: indeholder spil logikken og caller de nødvendige methods derfra.
    public static void gameLogic(Random random, Scanner scanner, int BLACKJACK, int ROLL_START_RANGE,
                                 int ROLL_END_RANGE, int MACHINE_HIT_THRESHOLD) {


        // definerer userN og starter med 1 roll
        int userN = roll(random, ROLL_START_RANGE, ROLL_END_RANGE);

        // definerer machineN og starter med 1 roll
        int machineN = roll(random, ROLL_START_RANGE, ROLL_END_RANGE);

        // sætter start outputtet
        System.out.println("You start with a: " + userN);

        // While loop: for game logic
        while (true) {
            // hvis user method returner false skal vi break, da den kun returner false, hvis vi enten rammer
            // blackjack eller exceeder blackjack
            if (!userLogicCheck(userN, BLACKJACK)) {
                return;
            }

            // definerer input som holder return value af getUserChoise method
            String input = getUserChoice(scanner);

            // hvis input er "y" fortætter vi spillet og tilføjer return value af roll til vores userN
            if (input.equals("y")) {
                userN += roll(random, ROLL_START_RANGE, ROLL_END_RANGE);

                // tjek om vi er exceeded eller rammer blackjack
                if (!userLogicCheck(userN, BLACKJACK)) {
                    return;
                }
                // hvis ikke er på eller over blackjack, printer status
                System.out.println("You now have: " + userN);
            // hvis input er alt andet en "y" initializer vi machine roll inde i machine logiccheck
            } else {
                machineN = machineLogicCheck(machineN, random, BLACKJACK, ROLL_START_RANGE,
                        ROLL_END_RANGE, MACHINE_HIT_THRESHOLD);

                // Hvis machine nummer er over blackjack returner vi for ikke at printe result
                if (machineN > BLACKJACK) {
                    return;

                // Hvis machine nummer ikke er over blackjack kan vi calculate.
                } else {
                    // caller calculate method og returner for clean exit.
                    calculate(machineN, userN);
                    return;
                }
            }
        }
    }


    // Method: calculate, sammenlign machine nummer og user nummer.
    public static void calculate(int machineN, int userInt) {
        // hvis user nummer er over machine nummer: vi vinder
        if (userInt > machineN) {
            System.out.println("You win!");
        // hvis user nummer er lig med machine nummer: er vi i draw
        } else if (userInt == machineN) {
            System.out.println("It is a draw.");
        // alle andre omstændigheder vinder machine
        } else {
            System.out.println("Machine wins!");
        }
        // print scores
        System.out.println("You got " + userInt);
        System.out.println("Machine got " + machineN);
    }

    // Method: machine logic check, check machine nummer i forhol til threshold
    // og blackjack exceed + roller machineN i condition
    public static int machineLogicCheck(int machineN, Random random, int BLACKJACK, int ROLL_START_RANGE,
                                        int ROLL_END_RANGE, int MACHINE_HIT_THRESHOLD) {
        // loop for roll hvis machineN er under threshold
        while (true) {
            //hvis machineN er under threshold: add return value af roll til machineN
            if (machineN <= MACHINE_HIT_THRESHOLD) {
                machineN += roll(random, ROLL_START_RANGE, ROLL_END_RANGE);
            // hvis machineN er over blackjack print "exceeded" og return nummer til gameLogic
            } else if (machineN > BLACKJACK) {
                System.out.println("Machine exceeded " + BLACKJACK + ", You win!");
                return machineN;
            // alle andre tilfælde return machineN
            } else {
                return machineN;
            }
        }
    }

    // Method: userLogicCheck, tjek userN for conditions
    public static boolean userLogicCheck(int userN, int BLACKJACK) {
        // hvis userN er blackjack, return false for at return i game logic for at undgå machineLogicCheck method call
        if (userN == BLACKJACK) {
            System.out.println("Blackjack! You win!");
            return false;
        // hvis userN er over blackjack, return false for at return i game logic for at undgå machinelogicCheck method call
        } else if (userN > BLACKJACK) {
            System.out.println("You exceeded " + BLACKJACK + ", Machine wins!");
            return false;
        // ellers return true for at gennemføre machineLogicCheck method call.
        } else {
            return true;
        }
    }

    // Method: roll, return nummer med datatype integer
    public static int roll(Random random, int ROLL_START_RANGE, int ROLL_END_RANGE) {
        // generær to dice rolls inden for range start range og end range, for at simulere 2 dice rolls
        return random.nextInt(ROLL_START_RANGE, ROLL_END_RANGE) + random.nextInt(ROLL_START_RANGE, ROLL_END_RANGE);
    }

    // Method: getuserChoice, luk for alle andre muligheder end y og n.
    public static String getUserChoice(Scanner scanner) {
        // Loop for reprompt
        while (true) {
            // print choice
            System.out.println("Do you want to roll again? (y/n)");
            // Definer user input med scanner + fjern spaces og lav lovercase
            String userInput = scanner.nextLine().trim().toLowerCase();
            // Hvis user input stemmer overens med parametre returner vi user input til gameLogic
            if (userInput.equals("y") || userInput.equals("n")) {
                return userInput;
            }
            // alle andre tilfælde reprompt user.
            System.out.println("Invalid input. Please enter y/n");
        }
    }
}

