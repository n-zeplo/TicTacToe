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
        //This Feels Bad
        players[0] = new Player("Player 1", "X", bufferedReader);
        players[1] = new Player("Player 2", "O", bufferedReader);


        game = new Game(printStream, players, board);
    }


    @Test
    public void shouldDrawTheBoardOnStart() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.isFull()).thenReturn(true);

        game.start();

        verify(printStream).println(contains(board.toString()));
    }

    @Test
    public void shouldDisplayPromptToPlayerOneToMoveOnStart() throws IOException {
        when(bufferedReader.readLine()).thenReturn("");
        when(board.isFull()).thenReturn(true);
        game.start();

        verify(printStream, atLeastOnce()).println(contains("Player 1"));
    }

    @Test
    public void shouldDisplayPromptToPlayerOneWithInstructions() throws IOException {
        when(bufferedReader.readLine()).thenReturn("");
        when(board.isFull()).thenReturn(true);

        game.start();

        verify(printStream, atLeast(1)).println(contains("1 to 9"));
    }

    @Test
    public void shouldMovePlayerOneToBoardPositionWithValidInput() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.isFull()).thenReturn(true);

        game.start();

        verify(board).putPlayerInPosition("X", "1");
    }

    @Test
     public void shouldDisplayPromptToPlayerTwo() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "2");
        when(board.isFull()).thenReturn(false, true);

        game.start();

        verify(printStream, atLeastOnce()).println(contains("Player 2"));
    }

    @Test
    public void shouldDisplayPromptToPlayerTwoWithSameInstructionsAsPlayerOneOnMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn("");
        when(board.isFull()).thenReturn(false, true);

        game.start();

        verify(printStream, atLeast(2)).println(contains("1 to 9"));
    }

    @Test
    public void shouldCheckBoardIfInputIsTakenCell() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.isFull()).thenReturn(false, true);

        game.start();

        verify(board, atLeast(1)).isCellTaken("1");
    }

    @Test
    public void shouldInformUserIfCellIsAlreadyTaken() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "2");
        when(board.isFull()).thenReturn(false, true);
        when(board.isCellTaken(anyString())).thenReturn(true, false);

        game.start();

        verify(printStream, atLeastOnce()).println(contains("Location already taken"));
    }

    @Test
    public void shouldAllowUserToReChooseIfSelectionIsTaken() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.isFull()).thenReturn(false, true);
        when(board.isCellTaken(anyString())).thenReturn(true, true, false);

        game.start();

        verify(printStream, atLeast(2)).println(contains("Player 1"));
    }

    @Test
    public void shouldReturnDrawMessageIfBoardIsFull() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.isFull()).thenReturn(true);

        game.start();

        verify(printStream, atLeastOnce()).println(contains("Game is a draw"));
    }

    @Test
    public void shouldReturnWinningMessageWhenPlayerWins() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.checkWinningCombinations()).thenReturn(true);

        game.start();

        verify(printStream, atLeastOnce()).println(contains("Wins"));

    }
}