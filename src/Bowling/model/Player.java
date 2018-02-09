package Bowling.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int mPlayerNum;
    private String mName;
    private int mScore;
    private List<Frame> mFrames;

    public Player(int playerNum, String name) {
        setName(name);
        setPlayerNum(playerNum);
        setScore(0);
        mFrames = new ArrayList<>();
        addFrames(10);
    }

    public int getPlayerNum() {return mPlayerNum;}
    public String getName() {return mName;}
    public int getScore() {return mScore;}
    public List<Frame> getFrames() {return mFrames;}

    public void setName(String name) {mName = name;}
    public void setScore(int score) {mScore = score;}
    public void addScore(int points) {mScore += points;}
    public void setPlayerNum(int playerNum) {mPlayerNum = playerNum;}
    public void addFrame(Frame frame) {mFrames.add(frame);}
    public void addFrames(int frameCount) {
        for (int i = 0; i < frameCount-1; i++) {addFrame(new Frame());}
        addFrame(new FinalFrame());
    }

}
