package Bowling.model;

public class Frame {
    private int mScore;
    private Throw mFirst;
    private Throw mSecond;

    public int getScore() {return mScore;}

    public Frame() {
        mScore = 0;
        mFirst = new Throw(10);
    }

    public void play() {
        mFirst.play();
        mScore += mFirst.getPoints();

        if (mFirst.getPinsRemaining() > 0) {
            mSecond = new Throw(mFirst.getPinsRemaining());
            mSecond.play();

            if (mSecond.getPinsRemaining() == 0) {
                System.out.print(" SPARE!");
                mScore = 15;
            } else {mScore += mSecond.getPoints();}
        }
    }
}
