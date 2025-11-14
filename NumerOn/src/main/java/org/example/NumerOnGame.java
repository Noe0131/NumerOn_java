package org.example;

import java.util.Random;

public class NumerOnGame {
    int _maxTry;

    public NumerOnGame(int _maxTry) {
        this._maxTry = _maxTry;
    }

    void createAnswer() {
        int numbers = 100;
        for (int i = 0; i < numbers; i++) {
            int hundred = i / 100;
            int ten = (i / 10) % 10;
            int one = i % 10;

            System.out.println("１００の位" + hundred);
            System.out.println("１０の位" + ten);
            System.out.println("１の位" + one);
        }
    }

    void start() {

        createAnswer();

    }



}
