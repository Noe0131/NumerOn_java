package org.example;

import  java.util.Scanner;
import java.util.Random;

public class NumerOnGame {
    int _maxTry;
    int[] answer = new int[3];
    Scanner scan = new Scanner(System.in);
    //全部比べてる一つずつ比べるのが正解
    int[] index = new int[]{scan.nextInt()};

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

                boolean flag = false;
                for (int j = 0; j < i; j++) {
                    if (answer[j] == number) {
                        flag = true;
                    }
                }

                if (!flag) {
                    answer[i] = number;
                    break;
                }
            }
        }

        if (answer.length == index.length) {
            System.out.println("合っている");
        } else  {
            System.out.println("間違っている");
        }
    }

    void start() {
        System.out.println("■■■NumerOn■■■");
        createAnswer();
        System.out.print("答え: ");
        for (int n : answer) {
            System.out.print(n + "");
        }
        System.out.println();
    }

}