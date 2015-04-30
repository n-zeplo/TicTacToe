package com.nathan.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;


/**
 * Created by nzeplowi on 4/30/15.
 */
public class GameTest {

    private PrintStream printStream;
    private Board board;
    private Game game;
    private BufferedReader bufferedReader;
    private Player[] players;

    @Before
    public void setUp() {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        players = new Player[2];
        players[0] = new Player("Player 1", "X");
        players[1] = new Player("Player 2", "O");


        game = new Game(printStream, bufferedReader, players, board);
    }


    @Test
    public void shouldStartingGameDrawsTheBoard() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "2");

        game.start();

        verify(board).toString();
    }

    @Test
    public void shouldDisplayPromptToPlayerOneToMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "2");
        game.start();

        verify(printStream).println(contains("Player 1"));
    }

    @Test
    public void shouldDisplayPromptToPlayerOneWithInstructions() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "2");
        game.start();

        verify(printStream, atLeast(1)).println(contains("1 to 9"));
    }

    @Test
    public void shouldAddXToFirstSlotIfFirstPlayerEnters1() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "2");

        game.start();

        verify(printStream).println(contains("X  |   |   \n-----------\n   |   |   \n-----------\n   |   |   "));

    }
//
//    @Test
//    public void shouldAddXToFourthSlotIfFirstPlayerEnters4() throws IOException {
//        when(bufferedReader.readLine()).thenReturn("4", "1");
//
//        game.start();
//
//        verify(printStream).println(contains("   |   |   \n-----------\nX  |   |   \n-----------\n   |   |   "));
//
//    }
//
//    @Test
//     public void shouldDisplayPromptToPlayerTwo() throws IOException {
//        when(bufferedReader.readLine()).thenReturn("1", "2");
//        game.start();
//
//        verify(printStream).println(contains("Player 2"));
//    }
//
//    @Test
//    public void shouldDisplayPromptToPlayerTwoWithSameInstructionsAsPlayerOneOnMove() throws IOException {
//        when(bufferedReader.readLine()).thenReturn("1", "2");
//
//        game.start();
//
//        verify(printStream, atLeast(2)).println(contains("1 to 9"));
//    }
//
//    @Test
//    public void shouldAddOToFirstSlotIfSecondPlayerEnters1() throws IOException {
//        when(bufferedReader.readLine()).thenReturn("2", "1");
//
//        game.start();
//
//        verify(printStream).println(contains("O  |X   |   \n-----------\n   |   |   \n-----------\n   |   |   "));
//
//    }
//
//    @Test
//    public void shouldAddOToFourthSlotIfSecondPlayerEnters4() throws IOException {
//        when(bufferedReader.readLine()).thenReturn("1", "4");
//
//        game.start();
//
//        verify(printStream).println(contains("X   |   |   \n-----------\nO  |   |   \n-----------\n   |   |   "));
//
//    }
//
//    @Test
//    public void shouldInformUserIfCellIsAlreadyTaken() throws IOException {
//        when(bufferedReader.readLine()).thenReturn("1", "1", "2");
//
//        game.start();
//
//        verify(printStream).println(contains("Location already taken"));
//    }
}