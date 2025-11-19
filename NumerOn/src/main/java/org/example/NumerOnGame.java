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
                // 最初の桁だけ 1〜9、残りは 0〜9
                if (i == 0) {
                    number = num.nextInt(9) + 1;
                } else {
                    number = num.nextInt(10);
                }

                boolean duplicate = false;

                // 重複チェック（今 i より前に同じ数字があるか）
                for (int j = 0; j < i; j++) {
                    if (answer[j] == number) {
                        duplicate = true;
                        break;
                    }
                }

                // 重複していなければ採用する
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