package com.nathan.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader bufferedReader;
    private static Player[] players;
    private static Board board;

    public static void main(String[] args) {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        initializePlayers();
        board = new Board();
        Game game = new Game(System.out, bufferedReader, players, board);

        game.start();
    }

    private static void initializePlayers() {
        players = new Player[2];
        players[0] = new Player("Player 1", "X");
        players[1] = new Player("Player 2", "O");
    }
}
