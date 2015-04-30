package com.nathan.tictactoe;

import java.io.PrintStream;

/**
 * Created by nzeplowi on 4/30/15.
 */
public class Game {
    private PrintStream printStream;
    private String board;

    public Game(PrintStream printStream, String board) {
        this.printStream = printStream;
        this.board = board;
    }

    public void start() {
        printStream.println(board);
        printStream.println("Player 1: Enter a Number 1 to 9 Where You Want to Move");
    }
}
