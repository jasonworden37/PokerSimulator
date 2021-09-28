import Player.Player;
import Webcam.webcamReader;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numPlayers = 0;

        Scanner s = new Scanner(System.in);
        System.out.println("How many people are playing?");
        numPlayers = s.nextInt();
        ArrayList<Player> players = new ArrayList<Player>();

        //populate arraylist of players
        for(int i = 0; i < numPlayers; i++){
            System.out.println("Name a player:");
            String name  = s.nextLine();
            players.add(new Player(name,15000));
        }








        webcamReader webcamReader = new webcamReader(players,0);


    }
}
