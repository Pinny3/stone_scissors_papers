package de.christianhartmann.play;

import de.christianhartmann.actor.Player;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GameFactoryTest {

    @Test
    public void thatCreateGameWorks() throws Exception {

        //when
        Game game = GameFactory.createGame();

        //then
        assertNotNull(game);
        Player playerA = (Player) Whitebox.getInternalState(game, "playerA");
        Player playerB = (Player) Whitebox.getInternalState(game, "playerB");
        assertNotNull(playerA);
        assertNotNull(playerB);
        assertEquals("A", playerA.getPlayerName());
        assertEquals("B", playerB.getPlayerName());
        assertNotNull(playerA.getSymbol());
        assertNotNull(playerB.getSymbol());
    }



}