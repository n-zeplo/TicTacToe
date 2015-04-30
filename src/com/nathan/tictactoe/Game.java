package com.nathan.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

/**
 * Created by nzeplowi on 4/30/15.
 */
public class Game {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private String[] board;

    public Game(PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.board = new String[9];
        Arrays.fill(board, " ");
    }

    public void start() {
        drawBoard();
        movePlayer("Player 1: Enter a Number 1 to 9 Where You Want to Move", "X");
        movePlayer("Player 2: Enter a Number 1 to 9 Where You Want to Move", "O");
    }

    private void drawBoard() {
        String formattedBoard = "";
        int counter = 1;
        for (String cell : board) {
            if(counter % 3 == 0){
                formattedBoard += String.format("%-3s", cell);
                formattedBoard += "\n-----------\n";
            } else {
                formattedBoard += String.format("%-3s|", cell);
            }
            counter++;
        }
        printStream.println(formattedBoard);
    }

    private void movePlayer(String prompt, String playerPiece) {
        printStream.println(prompt);
        String input = returnUserInput();
        if(input.matches("^[1-9]")){
            board[parseInt(input) - 1] = playerPiece;
            drawBoard();
        }

    }

    private String returnUserInput() {
        String input = "";
        try {
           input = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}
