import java.util.Random;
import java.util.Scanner;

public class BlackjackDiceGame {
    public static void main(String[] args) {
        // sæt final int BLACKJACK, 21 er altid blackjack
        final int BLACKJACK = 21;
        // sæt final int roll start range for bedre debug og code control
        final int ROLL_START_RANGE = 1;
        // sæt final int roll end range for bedre debug og code control
        final int ROLL_END_RANGE = 7;
        // sæt final int machine hit threshold for bedre debug og code control
        final int MACHINE_HIT_THRESHOLD = 16;

        // Lav class scanner i main for ikke at åbne den flere steder
        Scanner scanner = new Scanner(System.in);
        // Lav class random i main for ikke at åbne den flere steder
        Random random = new Random();

        // start game loop
        gameLoop(random, scanner, BLACKJACK, ROLL_START_RANGE, ROLL_END_RANGE, MACHINE_HIT_THRESHOLD);

        // når spil har nået slutning, luk scanner
        scanner.close();
    }

    public static void gameLoop(Random random, Scanner scanner, int BLACKJACK, int ROLL_START_RANGE, int ROLL_END_RANGE, int  MACHINE_HIT_THRESHOLD) {

        // prompt for start game menu
        System.out.println("Start game y/n");
        // Loop for genstart hvis getUserChoice = y
        while(true) {
            // Hvis user choice == y fire gameLogic
            if (getUserChoice(scanner).equals("y")) {
                gameLogic(random, scanner, BLACKJACK, ROLL_START_RANGE, ROLL_END_RANGE, MACHINE_HIT_THRESHOLD);
                // Efter gameLogic prompt for reroll
                System.out.println("play again y/n");
            } else {
                // Alle andre tilfælde = exit
                System.out.println("exit");
                // return til scanner close i main
                return;
            }
        }
    }


    // Method: game logic: logik og caller de nødvendige methods
    public static void gameLogic(Random random, Scanner scanner, int BLACKJACK, int ROLL_START_RANGE,
                                 int ROLL_END_RANGE, int MACHINE_HIT_THRESHOLD) {


        // definer userN og starter med 1 roll
        int userN = roll(random, ROLL_START_RANGE, ROLL_END_RANGE);

        // definer machineN og starter med 1 roll
        int machineN = roll(random, ROLL_START_RANGE, ROLL_END_RANGE);

        // sæt start output
        System.out.println("You start with a: " + userN);

        // While loop: for game logic
        while (true) {
            // hvis user method returner false break, returner kun false, hvis blackjack / exceed
            if (!userLogicCheck(userN, BLACKJACK)) {
                return;
            }

            // prompt for roll
            System.out.println("Do you want to roll again? (y/n)");

            // definer input holder return value af getUserChoise method
            String input = getUserChoice(scanner);

            // hvis input er "y" fortæt vi spil og tilføj return value af roll til userN
            if (input.equals("y")) {
                userN += roll(random, ROLL_START_RANGE, ROLL_END_RANGE);

                // tjek om exceeded eller blackjack efter roll
                if (!userLogicCheck(userN, BLACKJACK)) {
                    return;
                }
                // print status hvis userN != blackjack eller exceed
                System.out.println("You now have: " + userN);
                // hvis input er alt andet en "y" initialize machine roll ved machineLogiCheck call
            } else {
                machineN = machineLogicCheck(machineN, random, BLACKJACK, ROLL_START_RANGE,
                        ROLL_END_RANGE, MACHINE_HIT_THRESHOLD);

                // Hvis machine nummer er over blackjack returner vi for ikke at printe result
                if (machineN > BLACKJACK) {
                    return;

                    // Hvis machine nummer ikke er over blackjack, call calculate method.
                } else {
                    // call calculate method og return for clean exit.
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
            // Definer user input med scanner + fjern spaces og lav lovercase
            String userInput = scanner.nextLine().trim().toLowerCase();
            // Hvis user input stemmer overens med conditions return user input til gameLogic
            if (userInput.equals("y") || userInput.equals("n")) {
                return userInput;
            }
            // ellers reprompt user.
            System.out.println("Invalid input. Please enter y/n");
        }
    }
}
