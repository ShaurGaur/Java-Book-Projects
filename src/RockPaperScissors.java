/**
 * Created by shauryavratxg19 on 9/21/2017.
 */
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int playerNum = 0;
        int compNum = rand.nextInt(3) + 1;
        //int compNum = 3;

        //Do-while statements are really handy for prompting the right question
        do {
            System.out.print("Enter your throw (1=Rock, 2=Paper, 3=Scissors): ");
            playerNum = input.nextInt();
        } while ((playerNum > 3) || (playerNum < 1));

        System.out.printf("You throw %s.\n", getMessage(playerNum));
        System.out.printf("Computer throws %s.\n", getMessage(compNum));

        if (playerNum == compNum) {System.out.println("It's a draw!");}
        else if (playerNum == 1 && compNum == 3) {System.out.println("You win!");}
        else if (compNum == 1 && playerNum == 3) {System.out.println("Computer wins!");}
        else if (playerNum > compNum) {System.out.println("You win!");}
        else if (compNum > playerNum) {System.out.println("Computer wins!");}
    }

    public static String getMessage(int num) {
        String message = "";
        switch (num) {
            case 1: message = "ROCK"; break;
            case 2: message = "PAPER"; break;
            case 3: message = "SCISSORS"; break;
        }
        return message;
    }
}
