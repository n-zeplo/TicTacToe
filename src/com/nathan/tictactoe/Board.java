package com.nathan.tictactoe;

import java.util.Arrays;

import static java.lang.Integer.parseInt;

/**
 * Created by nzeplowi on 4/30/15.
 */
public class Board {
    private final String[] board;

    public Board() {
        this.board = new String[9];
        Arrays.fill(board, " ");
    }

    @Override
    public String toString() {
        return " " + board[0] + " | " + board[1] + " | " + board[2] + " \n" +
                "-----------\n" + " " + board[3] + " | " + board[4] + " | " + board[5] + " \n" +
                "-----------\n" + " " + board[6] + " | " + board[7] + " | " + board[8] + " ";
    }
    public boolean isCellTaken(String input){
        return !board[parseInt(input) - 1].equals(" ");
    }
    public String putPlayerOnTheBoard(String playerPiece, String input) {
            board[parseInt(input) - 1] = playerPiece;
            return toString();
    }
}
