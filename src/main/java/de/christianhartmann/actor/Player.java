package de.christianhartmann.actor;

import de.christianhartmann.play.PlayResultType;
import de.christianhartmann.symbol.Symbol;

public class Player {

    private final String playerName;
    private final Symbol symbol;

    public Player(final String playerName, final Symbol symbol) {
        this.playerName = playerName;
        this.symbol = symbol;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayResultType playAgainst(Player opponent) throws IllegalArgumentException {
        if (opponent == null) {
            throw new IllegalArgumentException("Please provide an opponent player.");
        }
        if (symbol.symbolType().equals(opponent.symbol.winsAgainst())) {
            return PlayResultType.WIN;
        } else if (symbol.symbolType().equals(opponent.symbol.loosesAgainst())) {
            return PlayResultType.LOOSE;
        }
        return PlayResultType.DRAW;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (!playerName.equals(player.playerName)) return false;
        return symbol.equals(player.symbol);
    }

    @Override
    public int hashCode() {
        int result = playerName.hashCode();
        result = 31 * result + symbol.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", symbol=" + symbol +
                '}';
    }
}
