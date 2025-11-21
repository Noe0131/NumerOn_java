package org.example;

import java.util.Random;
import java.util.Scanner;

public class NumerOnGame {
    public static final int DIGITS = 3;
    int _maxTry;
    int[] answer = new int[DIGITS];
    Scanner scan = new Scanner(System.in);
    int[] input_user;


    public NumerOnGame(int _maxTry) {
        this._maxTry = _maxTry;
    }

    public void createAnswer() {
        Random random = new Random();

        for (int i = 0; i < DIGITS; i++) {
            int number;

            while (true) {
                number = (i == 0) ? random.nextInt(9) + 1: random.nextInt(10);
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

    public  boolean readUserInput() {
        while (true) {
            System.out.print("3桁の数字を入力（gでギブアップ）: ");

            String s = scan.next();

            if (s.equals("g")) {
                return  false;
            }

            if (s.matches("\\d{3}")) {
                input_user = new int[3];

                input_user[0] = s.charAt(0) - '0';
                input_user[1] = s.charAt(1) - '0';
                input_user[2] = s.charAt(2) - '0';
                return true;
            }
        }

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
            if (!readUserInput()) {
                System.out.println("Give up !!");
                System.out.println("あなたの負けです");
                break;
            }
            checkEatBite(input_user);

            if (input_user[0] == answer[0] && input_user[1] == answer[1] && input_user[2] == answer[2]) {
                System.out.println("あなたの勝ちです");
                break;
            }
        }

        scan.close();
        System.out.print("答え");
        for (int n : answer) {

            System.out.print(n + " ");
        }

    }
}