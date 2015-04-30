package com.nathan.tictactoe;

import java.util.Arrays;

import static java.lang.Integer.parseInt;

/**
 * Created by nzeplowi on 4/30/15.
 */
public class Board {
    public String[] gameBoard;

    public Board() {
        this.gameBoard = new String[9];
        Arrays.fill(gameBoard, " ");
    }

    @Override
    public String toString() {
        return " " + gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2] + " \n" +
                "-----------\n" + " " + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5] + " \n" +
                "-----------\n" + " " + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8] + " ";
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
}
