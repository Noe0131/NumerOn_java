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
            int number;

            while (true) {

                if (i == 0) {
                    number = num.nextInt(9) + 1;
                } else {
                    number = num.nextInt(10);
                }

                boolean duplicate = false;


                for (int j = 0; j < i; j++) {
                    if (answer[j] == number) {
                        duplicate = true;
                        break;
                    }
                }


                if (!duplicate) {
                    answer[i] = number;
                    break;
                }
            }
        }
    }

    void start() {
        createAnswer();
        System.out.print("答え: ");
        for (int n : answer) {
            System.out.print(n + "");
        }
        System.out.println();
    }
}