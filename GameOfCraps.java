package gameofcraps;

import static java.lang.Boolean.TRUE;
import java.util.*;

/**
 *
 * @author dasare
 */
public class GameOfCraps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double wager = 0.0;
        double human_winnings = 0.0;
        double computer_winnings = 0.0;
        int numRoundsToPlay;
        int roundCounter = 0;

        final double MAX_WAGER = 100.00;
        Dice dice;
        //Dice dice1;
        System.out.println("State of game.......");
        numRoundsToPlay = (int) numGamesCount();
        for (double i = 1.0; i <= numRoundsToPlay; i++) {
            roundCounter++;

            System.out.println("Round #" + roundCounter);
            System.out.println("");

            // HUMAN'S ROUND
            System.out.println("Your Round(Human)");
            wager = getHumansWager(MAX_WAGER);
            dice = new Dice();
            playRound(dice);

            if (dice.getState() instanceof Win) {
                human_winnings = human_winnings + wager;
            } else {
                human_winnings = human_winnings - wager;
            }
            System.out.println("");
            System.out.println("");

            // COMPUTER'S ROUND
            System.out.println("Computer's Round");
            wager = randNumGeneration((int) MAX_WAGER);
            System.out.println("Computer bets " + "$" + wager);
            dice = new Dice();
            playRound(dice);

            System.out.println("");

            if (dice.getState() instanceof Win) {
                computer_winnings = computer_winnings + wager;
            } else {
                computer_winnings = computer_winnings - wager;
            }
        }

        if (computer_winnings > human_winnings) {
            System.out.println(" Game Over! Computers Rule");
        } else {
            System.out.println("Game Over! Humans Rule!!");
        }
        

        System.out.println("");
        System.out.println("");

        System.out.println("Computer Winnings: " + computer_winnings);
        System.out.println("User Winnings" + human_winnings);
    }

    public static double numGamesCount() {
        Scanner in = new Scanner(System.in);
        System.out.println("How many rounds do you want to play?");
        return in.nextDouble();
    }

    public static double getHumansWager(double max_wager) {
        Scanner in = new Scanner(System.in);
        System.out.println("Here we go, you are shooting ...");
        System.out.println("How much would you like to wager this round? (1 - " + max_wager + ")");
        double wager = in.nextDouble();
        System.out.println("I bet " + "$" + wager);
        while (TRUE) {
            if (wager >= 1.0 && wager <= max_wager) {
                return wager;
            } else {
                System.out.println("Please enter a valid wager (1 - " + max_wager + ")");
                wager = in.nextDouble();
            }
        }
        return max_wager;
    }
    // prompts for and returns wager between 1 and max_wager dollars

    public static int randNumGeneration(int max) {
        Random rand = new Random();
        return rand.nextInt((max - 1) + 1) + 1;
    }

    public static void playRound(Dice dice) {
        // play until win or loss occurs
        while (!(dice.getState() instanceof Win)
                && !(dice.getState() instanceof Loss)) {
            dice.rollDice();
            System.out.println("current roll is " + dice.getCurrentRoll());
            //dice.rollDice();
            break;
        }
    }

}
