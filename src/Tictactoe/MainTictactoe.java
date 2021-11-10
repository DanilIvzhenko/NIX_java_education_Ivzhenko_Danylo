package Tictactoe;

import java.util.Scanner;

public class MainTictactoe {
    public static void main(String[] args) {
        //System.out.println("X O X");
        //System.out.println("O X O");
        //System.out.println("X X O");
        //XOXXOOXOX
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells:");
        String line = scanner.nextLine();
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.printf("%s ", line.charAt(3 * i + j));
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
