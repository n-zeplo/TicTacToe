package com.nathan.tictactoe;

import java.util.Arrays;

import static java.lang.Integer.parseInt;

/**
 * Created by nzeplowi on 4/30/15.
 */
public class Board {
    private String[] gameBoard;
    private final int[][] WINNING_COMBINATIONS= {{0,1,2},{3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8},{0,4,8},{2,4,6}};
    
    public Board(String[] board) {
        this.gameBoard = board;
    }

    public boolean isCellTaken(String input){
        return !gameBoard[parseInt(input) - 1].equals(" ");
    }
    public String putPlayerOnTheBoard(String playerPiece, String input) {
            gameBoard[parseInt(input) - 1] = playerPiece;
            return toString();
    }

    public boolean isFull() {
        return !Arrays.asList(gameBoard).contains(" ");
    }

    public boolean checkWinningCombinations(){
        boolean isWinner = false;

        for (int[] ints : WINNING_COMBINATIONS) {
            if(winnerExistsInCombination(ints)){
                isWinner = true;
            }
        }

        return isWinner;
    }

    private boolean winnerExistsInCombination(int[] positions) {
        return !gameBoard[positions[0]].equals(" ") && gameBoard[positions[0]].equals(gameBoard[positions[1]]) && gameBoard[positions[1]].equals(gameBoard[positions[2]]);
    }

    @Override
    public String toString() {
        return " " + gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2] + " \n" +
                "-----------\n" + " " + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5] + " \n" +
                "-----------\n" + " " + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8] + " ";
    }
}
