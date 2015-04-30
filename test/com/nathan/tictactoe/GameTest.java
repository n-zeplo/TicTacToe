package com.nathan.tictactoe;

import org.junit.Before;
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

    private PrintStream printStream;
    private String board;
    private Game game;

    @Before
    public void setUp() {
        board = "   |   |   \n-----------\n   |   |   \n-----------\n   |   |   ";
        printStream = mock(PrintStream.class);

        game = new Game(printStream, board);
    }


    @Test
    public void shouldStartingGameDrawsTheBoard() {
        game.start();

        verify(printStream).println(contains(board));
    }

    @Test
    public void shouldDisplayPromptToPlayerOneToMove() {
        game.start();

        verify(printStream).println(contains("Player 1"));
    }
}