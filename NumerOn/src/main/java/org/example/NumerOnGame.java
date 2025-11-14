package org.example;

import java.util.Random;

public class NumerOnGame {
    int _maxTry;
    int[] answer = new int[3];

    public NumerOnGame(int _maxTry) {
        this._maxTry = _maxTry;
    }

    public void createAnswer() {
        Random num = new Random();
        for (int i = 0; i < answer.length; i++) {
            answer[i] = num.nextInt(10);
        }
    }

    //        int numbers = 100;
//        for (int i = 0; i < numbers; i++) {
//            int hundred = i / 100;
//            int ten = (i / 10) % 10;
//            int one = i % 10;
//
//            System.out.println("１００の位" + hundred);
//            System.out.println("１０の位" + ten);
//            System.out.println("１の位" + one);
//        }
//    }
    void start() {
        createAnswer();
        System.out.print("答え: ");
        for (int n : answer) {
            System.out.print(n + "");
        }
        System.out.println();
    }
}
