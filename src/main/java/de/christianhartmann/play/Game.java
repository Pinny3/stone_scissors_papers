package de.christianhartmann.play;

import de.christianhartmann.actor.Player;

public class Game {

    private static Player playerA;
    private static Player playerB;

    private Game(Builder builder) {
        playerA = builder.playerA;
        playerB = builder.playerB;
    }

    public PlayResult play() {
        PlayResultType playResultType = playerA.playAgainst(playerB);
        StringBuilder stringBuilder = generateResultMessage(playResultType);
        return new PlayResult(playResultType, stringBuilder.toString());
    }

    private StringBuilder generateResultMessage(PlayResultType playResultType) {
        StringBuilder stringBuilder = new StringBuilder("Player ").append(playerA.getPlayerName()).append(" with symbol ").append(playerA.getSymbol().symbolType());
        stringBuilder.append(" vs ");
        stringBuilder.append("Player ").append(playerB.getPlayerName()).append(" with symbol ").append(playerB.getSymbol().symbolType());
        stringBuilder.append(" - Result: ").append(playResultType).append(" for Player ").append(playerA.getPlayerName());
        return stringBuilder;
    }


    static Game.Builder builder() {
        return new Game.Builder();
    }

    static class Builder {
        private Player playerA;
        private Player playerB;

        Builder setPlayerA(Player playerA) {
            this.playerA = playerA;
            return this;
        }

        Builder setPlayerB(Player playerB) {
            this.playerB = playerB;
            return this;
        }

        Game build() {
            if (playerA == null) {
                throw new IllegalArgumentException("Please provide player A");
            }
            if (playerB == null) {
                throw new IllegalArgumentException("Please provide player B");
            }
            return new Game(this);
        }
    }
}
