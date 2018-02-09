import java.util.Random;
import java.util.Scanner;

public class TowerOfBabel {
    static int ringCount = 21;
    public static void main(String[] args) {
        System.out.println("------------- TOWER OF BABEL -------------");
        System.out.println(" - There are 21 rings stacked in a tower.");
        System.out.println(" - You can remove UP TO 3 RINGS.");
        System.out.println(" - Play against the computer.");
        System.out.println(" - Player who has to empty the tower loses.");
        System.out.println("BEGIN!\n");

        while (ringCount > 3) {userPlay(3); compPlay(3);}

        while (ringCount > 0) {
            userPlay(ringCount);
            if (ringCount <= 0) {System.out.println("Game over. Computer wins!");}
            else {
                compPlay(ringCount);
                if (ringCount == 0) {System.out.println("Game over. You win!");}
            }
        }
    }

    public static int inputNumBetween(int min, int max, String promptMsg) {
        Scanner input = new Scanner(System.in);
        int inputNum;
        do {
            System.out.print(promptMsg);
            inputNum = input.nextInt();
        } while(!(min <= inputNum && inputNum <= max));
        return inputNum;
    }

    public static int userPlay(int max) {
        int userVal = inputNumBetween(1, max, ringCount + " ring(s) left. How many will you remove? ");
        ringCount -= userVal;
        System.out.printf("You've removed %s ring(s).\n", userVal);
        return userVal;
    }

    public static int compPlay(int max) {
        Random rand = new Random();
        int compVal = rand.nextInt(max)+1;
        ringCount -= compVal;
        System.out.printf("Computer removes %s ring(s).\n\n", compVal);
        return compVal;
    }
}