package de.christianhartmann.actor;

import de.christianhartmann.play.PlayResultType;
import de.christianhartmann.symbol.Symbol;
import de.christianhartmann.symbol.SymbolType;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void thatPlayerALoosesAgainstPlayerB() throws Exception {
        Player playerA = new Player("A", Symbol.builder()
                .symbolType(SymbolType.PAPER)
                .winsAgainst(SymbolType.STONE)
                .loosesAgainst(SymbolType.SCISSORS)
                .build());
        Player playerB = new Player("B", Symbol.builder()
                .symbolType(SymbolType.STONE)
                .winsAgainst(SymbolType.SCISSORS)
                .loosesAgainst(SymbolType.PAPER)
                .build());

        //when
        PlayResultType playResultType = playerA.playAgainst(playerB);

        //then
        assertEquals(PlayResultType.LOOSE, playResultType);
    }

    @Test
    public void thatPlayerABeatsPlayerB() throws Exception {
        Player playerA = new Player("A", Symbol.builder()
                .symbolType(SymbolType.PAPER)
                .winsAgainst(SymbolType.STONE)
                .loosesAgainst(SymbolType.SCISSORS)
                .build());
        Player playerB = new Player("B", Symbol.builder()
                .symbolType(SymbolType.SCISSORS)
                .winsAgainst(SymbolType.PAPER)
                .loosesAgainst(SymbolType.SCISSORS)
                .build());

        //when
        PlayResultType playResultType = playerA.playAgainst(playerB);

        //then
        assertEquals(PlayResultType.WIN, playResultType);
    }

    @Test
    public void thatPlayerAGetsADrawAgainstPlayerB() throws Exception {
        Player playerA = new Player("A", Symbol.builder()
                .symbolType(SymbolType.PAPER)
                .winsAgainst(SymbolType.STONE)
                .loosesAgainst(SymbolType.SCISSORS)
                .build());
        Player playerB = new Player("B", Symbol.builder()
                .symbolType(SymbolType.PAPER)
                .winsAgainst(SymbolType.STONE)
                .loosesAgainst(SymbolType.SCISSORS)
                .build());

        //when
        PlayResultType playResultType = playerA.playAgainst(playerB);

        //then
        assertEquals(PlayResultType.DRAW, playResultType);
    }

    @Test(expected = IllegalArgumentException.class)
    public void thatPlayAgainstLeadsToIllegalArgumentExceptionIfNoOpponentIsProvided() throws Exception {
        Player playerA = new Player("A", Symbol.builder()
                .symbolType(SymbolType.PAPER)
                .winsAgainst(SymbolType.STONE)
                .loosesAgainst(SymbolType.SCISSORS)
                .build());

        //when
        PlayResultType playResultType = playerA.playAgainst(null);
    }

    @Test
    public void thatEqualsWorks() throws Exception {

        //given
        Player playerA1 = new Player("A", Symbol.builder()
                .symbolType(SymbolType.PAPER)
                .winsAgainst(SymbolType.SCISSORS)
                .loosesAgainst(SymbolType.STONE)
                .build());
        Player playerA2 = new Player("A", Symbol.builder()
                .symbolType(SymbolType.PAPER)
                .winsAgainst(SymbolType.SCISSORS)
                .loosesAgainst(SymbolType.STONE)
                .build());
        Player playerA3 = new Player("A", Symbol.builder()
                .symbolType(SymbolType.SCISSORS)
                .winsAgainst(SymbolType.PAPER)
                .loosesAgainst(SymbolType.STONE)
                .build());
        Player playerB1 = new Player("B", Symbol.builder()
                .symbolType(SymbolType.PAPER)
                .winsAgainst(SymbolType.SCISSORS)
                .loosesAgainst(SymbolType.STONE)
                .build());


        //when
        boolean equals = playerA1.equals(playerA2);

        //then
        assertTrue(equals);

        //when
        equals = playerA1.equals(playerB1);

        //then
        assertFalse(equals);

        //when
        equals = playerA1.equals(playerA3);

        //then
        assertFalse(equals);

    }

}