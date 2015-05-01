package com.nathan.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static java.lang.Integer.parseInt;

/**
 * Created by nzeplowi on 4/30/15.
 */
public class Game {
    private boolean running;
    private PrintStream printStream;
    private Player[] players;
    private Board board;

    public Game(PrintStream printStream, Player[] players, Board board) {
        this.printStream = printStream;
        this.players = players;
        this.board = board;
        this.running = true;
    }

    public void start() {
        printStream.println(board.toString());
        gameLoop();
    }

    private void gameLoop() {
        int whichPlayersTurn = 0;
        while (running) {
            playersMove(players[whichPlayersTurn]);
            checkIfGameHasEnded(players[whichPlayersTurn]);

            whichPlayersTurn++;
            if (whichPlayersTurn == players.length){
                whichPlayersTurn = 0;
            }
        }
    }

    private void checkIfGameHasEnded(Player player) {
        //Want to Extract into board.hasReachedEndState()
        if(board.isFull()) {
            printStream.println("Game is a draw");
            stopGame();
        }else if(board.checkWinningCombinations()){
            printStream.println(player.name + " Wins!");
            stopGame();
        }
    }

    private void stopGame() {
        running = false;
    }

    private void playersMove(Player player) {
        printStream.println(player.name + ": Please Enter A Number From 1 to 9 Where You Want to Move");
        String input = player.returnUserInput();
        if(checkIfUserInputIsValid(input)){
            sendMoveToBoard(player, input);
        };
    }

    private boolean checkIfUserInputIsValid(String input) {
        return input.matches("^[1-9]");
    }

    private void sendMoveToBoard(Player player, String input) {
        if(!board.isCellTaken(input)) {
            printStream.println(board.putPlayerInPosition(player.piece, input));
        } else {
            printStream.println("Location already taken");
            playersMove(player);
        }
    }

}
