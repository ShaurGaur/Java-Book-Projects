//Flowchart: https://photos.app.goo.gl/RGvnvaoBF8Dilcjs2
package Bowling.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BowlingGame {
    private List<Player> mPlayers;

    public List<Player> getPlayers() {return mPlayers;}
    public void addPlayer(Player player) {mPlayers.add(player);}

    public BowlingGame() {
        mPlayers = new ArrayList<>();
    }

    public void promptForPlayers() throws Exception {
        Scanner input = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int playerCount;
        do {
            try {
                System.out.print("How many people are playing? ");
                playerCount = input.nextInt();
            } catch (Exception e) {
                System.out.println("Is that a positive number? Try again.");
                playerCount = input.nextInt();
            }
        } while (playerCount <= 0);

        int i = 1;
        do {
            //String playerName = input.nextLine();
            System.out.printf("Player %s name: ", i);
            //String playerName = input.nextLine();
            String playerName = reader.readLine();
            mPlayers.add(new Player(i, playerName));
            i++;
        } while (i < playerCount + 1);
    }

    public void runTurn(int turnNum) {
        for (Player player : mPlayers) {
            System.out.printf("\nTURN #%s - %s. Current score: %s.",turnNum, player.getName(), player.getScore());
            Frame frame = player.getFrames().get(turnNum-1);
            frame.play();
            player.addScore(frame.getScore());
            System.out.printf(" Score: %s points\n", player.getScore());
        }
    }

    public void run() throws Exception {
        System.out.println("BOWLING\n");
        promptForPlayers();
        for (int i = 1; i <= 10; i++) {runTurn(i);}
        System.out.print("\nSTANDINGS:");
        for (Player player : mPlayers) {System.out.printf("\n%s: %s points", player.getName(), player.getScore());}
        System.out.println("\n\nGame over!");
    }
}
