package Bowling.model;

public class FinalFrame extends Frame {
    private Throw mThird;
    private Throw mFourth;
    private int mScore;

    public int getScore() {return mScore;}
    public FinalFrame() {super();}

    public void play() {
        super.play();
        mScore += super.getScore();

        if (super.getScore() == 20 || super.getScore() == 15) {
            mThird = new Throw(10);
            mThird.play();
            mScore += mThird.getPoints();

            if (mThird.getPoints() == 20) {
                mFourth = new Throw(10);
                mFourth.play();
                mScore += mFourth.getPoints();
            }
        }
    }
}
