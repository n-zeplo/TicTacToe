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
    private String[] blankBoard;

    @Before
    public void setUp() throws Exception {
        blankBoard = new String[] {" ", " ", " ", " ", " ", " ", " ", " ", " "};

    }

    @Test
    public void shouldReturnFormattedBoard() {
        board = new Board(blankBoard);

        board.toString();

        assertEquals(board.toString(), "   |   |   \n-----------\n   |   |   \n-----------\n   |   |   ");
    }

    @Test
    public void shouldAddXToSlotOneWithInputOne() {
        board = new Board(blankBoard);

        board.putPlayerInPosition("X", "1");

        assertEquals(board.toString(),  " X |   |   \n-----------\n   |   |   \n-----------\n   |   |   ");
    }

    @Test
    public void shouldAddXToSlotFourWithInputFour() {
        board = new Board(blankBoard);

        board.putPlayerInPosition("X", "4");

        assertEquals(board.toString(),  "   |   |   \n-----------\n X |   |   \n-----------\n   |   |   ");
    }

    @Test
    public void shouldAddOToSlotOneWithInputOne() {
        board = new Board(blankBoard);

        board.putPlayerInPosition("O", "1");

        assertEquals(board.toString(),  " O |   |   \n-----------\n   |   |   \n-----------\n   |   |   ");
    }

    @Test
    public void shouldReturnFalseIfSlotIsEmpty() {
        board = new Board(blankBoard);

        assertEquals(board.isCellTaken("1"), false);
    }

    @Test
    public void shouldReturnTrueIfSlotIsFilled() {
        board = new Board(blankBoard);
        board.putPlayerInPosition("O", "1");

        assertEquals(board.isCellTaken("1"), true);
    }

    @Test
    public void shouldReturnFalseIfBoardIsNotFull() {
        board = new Board(blankBoard);

        assertEquals(false, board.isFull());
    }

    @Test
    public void shouldReturnTrueIfBoardIsFull() {
        String[] fullBoard = new String[] {"X", "X", "X", "X","X","X","X","X","X"};
        Arrays.fill(fullBoard, "1");
        board = new Board(fullBoard);

        assertEquals(true, board.isFull());
    }

    @Test
    public void shouldReturnTrueIfWinnerExistsInWinningCombinations() {
        String[] winningBoard = new String[] {"X", "O", "X", "","X","","","","X"};

        board = new Board(winningBoard);

        assertEquals(true, board.checkWinningCombinations());
    }

    @Test
    public void shouldReturnFalseIfWinnerDoesNotExistsInWinningCombinations() {
        String[] losingBoard = new String[] {"X", "O", "X", "","O","","","","X"};

        board = new Board(losingBoard);

        assertEquals(false, board.checkWinningCombinations());
    }
}
