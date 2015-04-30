package com.nathan.tictactoe;

import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by nzeplowi on 4/30/15.
 */
public class GameTest {
    @Test
    public void shouldStartingGameDrawsTheBoard() {
        String board = "   |   |   \n-----------\n   |   |   \n-----------\n   |   |   ";
        PrintStream printStream = mock(PrintStream.class);

        Game game = new Game(printStream, board);

        game.start();

        verify(printStream).println(contains(board));
    }


}