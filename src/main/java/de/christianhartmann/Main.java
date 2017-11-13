package de.christianhartmann;

import de.christianhartmann.play.Game;
import de.christianhartmann.play.GameFactory;
import de.christianhartmann.play.PlayResult;

public class Main {

    public static void main(String [] args) {
        System.out.println("Stone-Scissors-Paper");
        for (int i = 1; i <= 100; i++) {
            Game game = GameFactory.createGame();
            PlayResult playResult = game.play();
            System.out.println("======================");
            System.out.println("Round " + i);
            System.out.println("Result: " + playResult.getMessage().orElse("No result"));
        }
    }
}
