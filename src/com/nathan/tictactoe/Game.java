package com.nathan.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static java.lang.Integer.parseInt;

/**
 * Created by nzeplowi on 4/30/15.
 */
public class Game {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Player[] players;
    private Board board;

    public Game(PrintStream printStream, BufferedReader bufferedReader, Player[] players, Board board) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.players = players;
        this.board = board;
    }

    public void start() {
        printStream.println(board.toString());
        gameLoop();
    }

    private void gameLoop() {
        //NEEDS MAJOR REFACTORING
        boolean done = false;
        while (!done) {
            for (Player player : players) {
                if(board.isFull()) {
                    printStream.println("Game is a draw");
                    done = true;
                }else {
                    movePlayer(player);

                    if(board.checkWinningCombinations()){
                        done = true;
                        printStream.println(player.name + " Wins!");
                    }
                }
            }
        }
    }

    private void movePlayer(Player player) {
        printStream.println(player.name + ": Please Enter A Number From 1 to 9 Where You Want to Move");
        String input = returnUserInput();
        if(checkIfUserInputIsValid(input)){
            sendMoveToBoard(player, input);
        };
    }

    private boolean checkIfUserInputIsValid(String input) {
        return input.matches("^[1-9]");
    }

    private void sendMoveToBoard(Player player, String input) {
        if(!board.isCellTaken(input)) {
            printStream.println(board.putPlayerOnTheBoard(player.piece, input));
        } else {
            printStream.println("Location already taken");
            movePlayer(player);
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
