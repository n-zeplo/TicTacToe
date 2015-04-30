package com.nathan.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Created by nzeplowi on 4/30/15.
 */
public class BoardTest {

    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
    }
    @Test
    public void shouldReturnFormattedBoard() {
        board.toString();

        assertEquals(board.toString(), "   |   |   \n-----------\n   |   |   \n-----------\n   |   |   ");
    }

    @Test
    public void shouldAddXToSlotOneWithInputOne() {
        board.putPlayerOnTheBoard("X", "1");

        assertEquals(board.toString(),  " X |   |   \n-----------\n   |   |   \n-----------\n   |   |   ");
    }

    @Test
    public void shouldAddXToSlotFourWithInputFour() {
        board.putPlayerOnTheBoard("X", "4");

        assertEquals(board.toString(),  "   |   |   \n-----------\n X |   |   \n-----------\n   |   |   ");
    }

    @Test
    public void shouldAddOToSlotOneWithInputOne() {
        board.putPlayerOnTheBoard("O", "1");

        assertEquals(board.toString(),  " O |   |   \n-----------\n   |   |   \n-----------\n   |   |   ");
    }

    @Test
    public void shouldReturnFalseIfSlotIsEmpty() {
        assertEquals(board.isCellTaken("1"), false);
    }

    @Test
    public void shouldReturnTrueIfSlotIsFilled() {
        board.putPlayerOnTheBoard("O", "1");

        assertEquals(board.isCellTaken("1"), true);
    }

    @Test
    public void shouldReturnFalseIfBoardIsFull() {
        assertEquals(board.isFull(), false);
    }

    @Test
    public void shouldReturnTrueIfBoardIsFull() {
        String[] fullBoard = new String[9];
        Arrays.fill(fullBoard, "1");
        board.gameBoard = fullBoard;

        assertEquals(board.isFull(), true);
    }

    @Test
    public void shouldReturnTrueIfWinnerExistsInWinningCombinations() {
        String[] winningBoard = new String[] {"X", "O", "X", "","X","","","","X"};

        board.gameBoard = winningBoard;

        assertEquals(true, board.checkWinningCombinations());
    }

    @Test
    public void shouldReturnFalseIfWinnerDoesNotExistsInWinningCombinations() {
        String[] winningBoard = new String[] {"X", "O", "X", "","O","","","","X"};

        board.gameBoard = winningBoard;

        assertEquals(false, board.checkWinningCombinations());
    }
}
