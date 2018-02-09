import java.util.Random;
import java.util.Scanner;

public class HiLo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final String PLAY_AGAIN = "y";
        String userPlayAgain;
        int score = 1000;

        System.out.println("High Low Numbers Game\n\nRULES\nNumbers 1 thru 6 are low\n" +
                "Numbers 8 thru 13 are high\nNumber 7 is neither high or low");

        do {
            System.out.printf("\nYou have %s points.\n", score);

            int riskPoints = inputNumBetween(1, score, "Enter points to risk: ");
            int userType = inputNumBetween(0, 1, "Predict (1=High, 0=Low): ");

            score = modifyScore(score, riskPoints, checkGuess(userType));

            System.out.printf("Press y to play again: ");
            userPlayAgain = input.next();

        } while(score > 0 && userPlayAgain.equals(PLAY_AGAIN));

        System.out.println("\nGame over. Final score: " + score + " points");
    }

    public static int modifyScore(int currentScore, int riskPoints, boolean correct) {
        if (correct) currentScore += (riskPoints * 2);
        else currentScore -= riskPoints;
        return currentScore;
    }

    public static int inputNumBetween(int min, int max, String promptMsg) {
        Scanner input = new Scanner(System.in);
        int inputNum;
        do {
            System.out.printf(promptMsg);
            inputNum = input.nextInt();
        } while(!isValidNumber(inputNum, min, max));
        return inputNum;
    }

    public static boolean isValidNumber(int user, int min, int max) {return (min <= user && user <= max);}

    public static boolean checkGuess(int userNum) {
        Random rand = new Random();
        int compNum = rand.nextInt(13) + 1;
        int compType;

        if (compNum >= 8 && compNum <= 13) compType = 1;
        else if (compNum >= 1 && compNum <= 6) compType = 0;
        else compType = -1;

        String message =  (userNum == compType) ? "win" : "lose";
        System.out.printf("Number is %s. You %s!\n", compNum, message);
        return (compType == userNum);
    }
}
