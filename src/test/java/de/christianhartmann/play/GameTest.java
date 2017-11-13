package de.christianhartmann.play;

import de.christianhartmann.actor.Player;
import de.christianhartmann.symbol.Symbol;
import de.christianhartmann.symbol.SymbolType;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void thatGameReturnsPlayResult() {

        //given
        Game game = GameFactory.createGame();

        //when
        PlayResult playResult = game.play();

        //then
        assertTrue(playResult.getMessage().isPresent());
        assertNotNull(playResult.getPlayResultType());
        Player playerA = (Player) Whitebox.getInternalState(game, "playerA");
        Player playerB = (Player) Whitebox.getInternalState(game, "playerB");
        String expectedString = "Player " + playerA.getPlayerName() + " with symbol " + playerA.getSymbol().symbolType() + " vs Player " + playerB.getPlayerName() + " with symbol " + playerB.getSymbol().symbolType() + " - Result: " + playResult.getPlayResultType() + " for Player " + playerA.getPlayerName();
        assertEquals(expectedString, playResult.getMessage().get());

    }

    @Test(expected = IllegalArgumentException.class)
    public void thatBuilderThrowsIllegalArgumentExceptionIfPlayerAIsNotSet() throws Exception {

        //given
        Player playerB = new Player("B", Symbol.builder().symbolType(SymbolType.PAPER)
                .loosesAgainst(SymbolType.PAPER)
                .winsAgainst(SymbolType.STONE).build());

        //when
        Game.builder().setPlayerB(playerB).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void thatBuilderThrowsIllegalArgumentExceptionIfPlayerBIsNotSet() throws Exception {

        //given
        Player playerA = new Player("A", Symbol.builder().symbolType(SymbolType.PAPER)
                .loosesAgainst(SymbolType.PAPER)
                .winsAgainst(SymbolType.STONE).build());

        //when
        Game.builder().setPlayerA(playerA).build();
    }

    @Test
    public void thatBuilderWorks() throws Exception {

        //given
        Player playerA = new Player("A", Symbol.builder().symbolType(SymbolType.PAPER)
                .loosesAgainst(SymbolType.PAPER)
                .winsAgainst(SymbolType.STONE).build());
        Player playerB = new Player("B", Symbol.builder().symbolType(SymbolType.PAPER)
                .loosesAgainst(SymbolType.PAPER)
                .winsAgainst(SymbolType.STONE).build());

        //when
        Game game = Game.builder().setPlayerA(playerA).setPlayerB(playerB).build();

        //then
        assertNotNull(game);
        Player retrievedPlayerA = (Player) Whitebox.getInternalState(game, "playerA");
        Player retrievedPlayerB = (Player) Whitebox.getInternalState(game, "playerB");
        assertEquals(playerA, retrievedPlayerA);
        assertEquals(playerB, retrievedPlayerB);
    }

}
