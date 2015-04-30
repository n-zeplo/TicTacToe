package com.nathan.tictactoe;

public class Main {

    public static void main(String[] args) {
        String board = "   |   |   \n-----------\n   |   |   \n-----------\n   |   |   ";

        new Game(System.out, board).start();
    }
}
