package tests;


import Player.Player;
import Poker.Game;
import Webcam.webcamReader;
import org.junit.Test;

import java.util.ArrayList;



public class GameBlindsTest {

    @Test
    public void blindsCorrectAfterSetupWithMoreThanTwo(){
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("Jason",15000));
        players.add(new Player("Seth",15000));
        players.add(new Player("Josh",15000));
        players.add(new Player("Alex",15000));
        players.add(new Player("Justin",15000));

        webcamReader web = new webcamReader(players,0);
        Game game = web.getGame();
        assert(game.getDealer().getName().equals("Jason"));
        assert(game.getSmall().getName().equals("Seth"));
        assert(game.getBig().getName().equals("Josh"));
        assert(game.getTurn().getName().equals("Alex"));
    }

    @Test
    public void blindsCorrectAfterSetupWithJustTwo(){
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("Jason",15000));
        players.add(new Player("Seth",15000));

        webcamReader web = new webcamReader(players,0);
        Game game = web.getGame();
        assert(game.getDealer().getName().equals("Jason"));
        assert(game.getSmall().getName().equals("Seth"));
        assert(game.getBig().getName().equals("Jason"));
        assert(game.getTurn().getName().equals("Seth"));
    }

    @Test
    public void blindsCorrectAfterSetupWithJustThree(){
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("Jason",15000));
        players.add(new Player("Seth",15000));
        players.add(new Player("Josh",15000));
        webcamReader web = new webcamReader(players,0);
        Game game = web.getGame();
        assert(game.getDealer().getName().equals("Jason"));
        assert(game.getSmall().getName().equals("Seth"));
        assert(game.getBig().getName().equals("Josh"));
        assert(game.getTurn().getName().equals("Jason"));
    }

    @Test
    public void turnCorrectAfterTakingTurn(){
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("Jason",15000));
        players.add(new Player("Seth",15000));
        players.add(new Player("Josh",15000));
        players.add(new Player("Alex",15000));
        players.add(new Player("Justin",15000));
        webcamReader web = new webcamReader(players,0);
        Game game = web.getGame();

        assert(game.getTurn().getName().equals("Alex"));
        game.takeTurn();
        assert(game.getTurn().getName().equals("Justin"));
        game.takeTurn();
        assert(game.getTurn().getName().equals("Jason"));
        game.takeTurn();
        assert(game.getTurn().getName().equals("Seth"));
        game.takeTurn();
        assert(game.getTurn().getName().equals("Josh"));
        game.takeTurn();
        assert(game.getTurn().getName().equals("Alex"));
    }
    @Test
    public void turnCorrectAfterTakingTurnWithTwo(){
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("Jason",15000));
        players.add(new Player("Seth",15000));

        webcamReader web = new webcamReader(players,0);
        Game game = web.getGame();

        assert(game.getTurn().getName().equals("Seth"));
        game.takeTurn();
        assert(game.getTurn().getName().equals("Jason"));
        game.takeTurn();
        assert(game.getTurn().getName().equals("Seth"));
        game.takeTurn();
        assert(game.getTurn().getName().equals("Jason"));
        game.takeTurn();
        assert(game.getTurn().getName().equals("Seth"));

    }

}
