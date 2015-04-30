package com.nathan.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by nzeplowi on 4/30/15.
 */
public class GameTest {

    private PrintStream printStream;
    private String board;
    private Game game;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() {
        board = "   |   |   \n-----------\n   |   |   \n-----------\n   |   |   ";
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);

        game = new Game(printStream, bufferedReader);
    }


    @Test
    public void shouldStartingGameDrawsTheBoard() throws IOException {
        when(bufferedReader.readLine()).thenReturn("");

        game.start();

        verify(printStream).println(contains(board));
    }

    @Test
    public void shouldDisplayPromptToPlayerOneToMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn("");
        game.start();

        verify(printStream).println(contains("Player 1"));
    }

    @Test
    public void shouldDisplayPromptToPlayerOneWithInstructions() throws IOException {
        when(bufferedReader.readLine()).thenReturn("");
        game.start();

        verify(printStream).println(contains("1 to 9"));
    }

    @Test
    public void shouldAddXToFirstSlotIfPlayerEnters1() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");

        game.start();

        verify(printStream).println(contains("X  |   |   \n-----------\n   |   |   \n-----------\n   |   |   "));

    }

    @Test
    public void shouldAddXToFourthSlotIfPlayerEnters4() throws IOException {
        when(bufferedReader.readLine()).thenReturn("4");

        game.start();

        verify(printStream).println(contains("   |   |   \n-----------\nX  |   |   \n-----------\n   |   |   "));

    }
}