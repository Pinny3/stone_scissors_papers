package de.christianhartmann.play;

import de.christianhartmann.actor.Player;
import de.christianhartmann.symbol.Symbol;
import de.christianhartmann.symbol.SymbolType;

import java.util.EnumSet;
import java.util.Random;

public class GameFactory {

    public static Game createGame() {
        Player playerA = new Player("A", getRandomizedSymbol());
        Player playerB = new Player("B", createSymbol(SymbolType.PAPER));
        return Game.builder()
                .setPlayerA(playerA)
                .setPlayerB(playerB)
                .build();
    }

    private static Symbol createSymbol(SymbolType symbolType) {
        Symbol.Builder symbolBuilder = Symbol.builder()
                .symbolType(symbolType);
        switch (symbolType) {
            case PAPER:
                symbolBuilder.loosesAgainst(SymbolType.SCISSORS)
                        .winsAgainst(SymbolType.STONE);
                break;
            case SCISSORS:
                symbolBuilder.loosesAgainst(SymbolType.STONE)
                        .winsAgainst(SymbolType.PAPER);
                break;
            case STONE:
                symbolBuilder.loosesAgainst(SymbolType.PAPER)
                        .winsAgainst(SymbolType.SCISSORS);
                break;

        }
        return symbolBuilder.build();
    }

    private static Symbol getRandomizedSymbol() {
        Random random = new Random();
        int randomValue = random.nextInt(EnumSet.allOf(SymbolType.class).size());
        return createSymbol(SymbolType.values()[randomValue]);
    }

}
