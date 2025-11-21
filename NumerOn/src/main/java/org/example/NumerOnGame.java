package org.example;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class NumerOnGame {
    int _maxTry;
    int[] answer = new int[3];
    Scanner scan = new Scanner(System.in);
    int[] input_user;


    public NumerOnGame(int _maxTry) {
        this._maxTry = _maxTry;
    }

    public void createAnswer() {
        Random random = new Random();

        for (int i = 0; i < answer.length; i++) {
            int number;

            while (true) {

                if (i == 0) {
                    number = random.nextInt(9) + 1;
                } else {
                    number = random.nextInt(10);
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

    public void splitNumber() {

        int input = scan.nextInt();

        int Hundreds_place = input / 100;
        int Tens_place = (input / 10) % 10;
        int Ones_place = input % 10;

        input_user = new int[3];

        input_user[0] = Hundreds_place;
        input_user[1] = Tens_place;
        input_user[2] = Ones_place;
    }

    void checkEatBite(int[] input_user) {
        int eat = 0;
        int blte = 0;

        //eat
        for (int i = 0; i < 3; i++) {
            if (input_user[i] == answer[i]) {
                eat++;
            }
        }

        //blte
        for (int i = 0; i < 3; i++) {
            if (input_user[i] != answer[i]) {

                for (int j = 0; j < 3; j++) {
                    if ((input_user[i] == answer[j]) && (i != j)) {
                        blte++;
                    }
                }
            }
        }
        System.out.println(eat + "EAT-" + blte + "BITE");
    }

    void start() {
        createAnswer();
        _maxTry = 10;
        for (int i = _maxTry; i > 0; i--) {
            System.out.println("あと" + i + "です。");
            splitNumber();
            checkEatBite(input_user);
        }
        for (int n : answer) {
            System.out.print("答え" + Arrays.toString(answer));
        }


//        String str = scan.next();
//
//        if (str == "g") {
//            System.out.println("Give up !!");
//            System.out.println("あなたの負けです");
//            System.exit(0);
//        }


        scan.close();

    }
}