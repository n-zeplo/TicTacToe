package com.nathan.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by nzeplowi on 4/30/15.
 */
public class Player {
    public String name;
    public String piece;
    private BufferedReader bufferedReader;

    public Player(String name, String piece, BufferedReader bufferedReader) {
        this.name = name;
        this.piece = piece;
        this.bufferedReader = bufferedReader;
    }


    public String returnUserInput() {
        String input = "";
        try {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}
