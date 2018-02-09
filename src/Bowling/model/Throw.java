package Bowling.model;

import java.util.Random;
import java.util.Scanner;

public class Throw {
    private int mPinsKnocked;
    private int mPinsRemaining;
    private int mPoints;
    private static final int STRIKE_SCORE = 20;

    //Instantiate a new Throw with pinsRemaining pins left in the lane
    public Throw(int pinsRemaining) {
        mPinsRemaining = pinsRemaining;
        mPinsKnocked = 0;
        mPoints = 0;
    }

    public int getPinsRemaining() {return mPinsRemaining;}
    public int getPinsKnocked() {return mPinsKnocked;}
    public int getPoints() {return mPoints;}

    //Throw a ball, random number of pins gets knocked, score gets changed
    public void play() {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.println(" Press ENTER to throw: ");
        input.nextLine();
        mPinsKnocked = rand.nextInt(mPinsRemaining) + 1;
        mPinsRemaining -= mPinsKnocked;

        if (mPinsKnocked == 10) {
            System.out.print("     STRIKE! All pins knocked!");
            mPoints = STRIKE_SCORE;
        }
        else {
            System.out.printf("     %s pin(s) knocked.", mPinsKnocked);
            mPoints = mPinsKnocked;
        }
    }
}
