package de.christianhartmann.symbol;

import org.junit.Test;

import static org.junit.Assert.*;

public class SymbolTest {

    private final Symbol.Builder symbolBuilder = Symbol.builder();

    @Test
    public void thatCreatesASymbolWorks() throws Exception {

        //given
        symbolBuilder
                .symbolType(SymbolType.SCISSORS)
                .loosesAgainst(SymbolType.STONE)
                .winsAgainst(SymbolType.PAPER);

        //when
        Symbol symbol = symbolBuilder.build();

        //then
        assertEquals(SymbolType.SCISSORS, symbol.symbolType());
        assertEquals(SymbolType.STONE, symbol.loosesAgainst());
        assertEquals(SymbolType.PAPER, symbol.winsAgainst());
    }

    @Test
    public void thatToStringWorks() {
        //given
        symbolBuilder
                .symbolType(SymbolType.SCISSORS)
                .loosesAgainst(SymbolType.STONE)
                .winsAgainst(SymbolType.PAPER);

        //when
        Symbol symbol = symbolBuilder.build();

        //then
        assertNotNull(symbol.toString());
    }


    @Test(expected = IllegalArgumentException.class)
    public void thatBuilderThrowsIllegalArgumentExceptionIfSymbolTypeIsNotSet() throws Exception {

        //given
        symbolBuilder
                .loosesAgainst(SymbolType.PAPER)
                .winsAgainst(SymbolType.STONE);

        //when
        symbolBuilder.build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void thatBuilderThrowsIllegalArgumentExceptionIfLoosesAgainstIsNotSet() throws Exception {

        //given
        symbolBuilder
                .symbolType(SymbolType.PAPER)
                .winsAgainst(SymbolType.STONE);

        //when
        symbolBuilder.build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void thatBuilderThrowsIllegalArgumentExceptionIfWinsAgainstIsNotSet() throws Exception {

        //given
        symbolBuilder
                .symbolType(SymbolType.PAPER)
                .loosesAgainst(SymbolType.STONE);

        //when
        symbolBuilder.build();
    }

    @Test
    public void thatEqualsWorks() throws Exception {

        //given
        Symbol symbolScisscors1 = symbolBuilder
                .symbolType(SymbolType.SCISSORS)
                .loosesAgainst(SymbolType.STONE)
                .winsAgainst(SymbolType.PAPER)
                .build();
        Symbol symbolScisscors2 = symbolBuilder
                .symbolType(SymbolType.SCISSORS)
                .loosesAgainst(SymbolType.STONE)
                .winsAgainst(SymbolType.PAPER)
                .build();
        Symbol symbolPaper = symbolBuilder
                .symbolType(SymbolType.PAPER)
                .loosesAgainst(SymbolType.SCISSORS)
                .winsAgainst(SymbolType.STONE)
                .build();

        //when
        boolean equals = symbolScisscors1.equals(symbolScisscors2);

        //then
        assertTrue(equals);

        //when
        equals = symbolScisscors1.equals(symbolPaper);

        //then
        assertFalse(equals);
    }
}