package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            NumerOnGame org = new NumerOnGame(3);
            org.start();

            System.out.println("\\nもう一度プレイしますか？ (y/n): ");
            String input = scan.next();

            if (input.equals("y")) {
                System.out.println("もう一度");
            } else if (input.equals("n")) {
                System.out.println("またね！");
                break;
            }

        }
    }
}