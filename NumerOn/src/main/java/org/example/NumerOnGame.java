package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class NumerOnGame {
    int _maxTry;
    int[] answer = new int[3];
    Scanner scan = new Scanner(System.in);

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

        int[] input_user;
        input_user = new int[3];

        input_user[0] = Hundreds_place;
        input_user[1] = Tens_place;
        input_user[2] = Ones_place;

        System.out.println(Arrays.toString(input_user));

    }

    void checkEatBite(int[] input_user) {

    }

    void start() {
        createAnswer();
        splitNumber();
        System.out.print("答え: ");
        for (int n : answer) {
            System.out.print(n + "");
        }
        System.out.println();
        scan.close();
    }
}