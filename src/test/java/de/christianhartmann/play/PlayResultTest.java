package de.christianhartmann.play;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PlayResultTest {

    @Test
    public void thatPlayResultReturnsMessage() throws Exception {

        //given
        String message = "Hallo";

        //when
        PlayResult playResult = new PlayResult(PlayResultType.DRAW, message);

        //then
        assertEquals(message, playResult.getMessage().get());
    }

    @Test
    public void thatPlayResultReturnsEmptyOptionalIfMessageIsNull() throws Exception {

        //given
        String message = null;

        //when
        PlayResult playResult = new PlayResult(PlayResultType.WIN, message);

        //then
        assertFalse(playResult.getMessage().isPresent());
    }

}