package chatBot;

import java.util.Scanner;

public class ChatBot {

    //Creating Scanners

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1-st stage
        System.out.println("Hello! My name is Bot");
        System.out.println("I was created in 2021");

        // 2-nd stage
        System.out.println("Please, remind me your name");
        String name = scanner.nextLine();
        System.out.println("What`s a great name you have " + name + "!");

        // 3-rd stage
        System.out.println("Let me guess your age");
        System.out.println("Enter remainders of dividing your age by 3,5 and 7");
        int remainder3 = scanner.nextInt();
        int remainder5 = scanner.nextInt();
        int remainder7 = scanner.nextInt();
        int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;
        System.out.println("Your age is " + age + "; that`s a good time to start programming!");

        //4-th stage
        System.out.println("Now I will prove you that i count to any number you want");
        System.out.println("Введите положительное число: ");

        int input = scanner.nextInt();
        for (int Num = 0; Num <= input; Num++) {
            System.out.println(Num + " !");
        }

        //5th stage

        System.out.println("Lets test your programming knowlege");
        System.out.println("Why do we use methods?");
        System.out.println("1.To repeat a statement multiple times");
        System.out.println("2.To decompose a program into several small subroutines");
        System.out.println("3.To determine the execution time of a program");
        System.out.println("4.To interrupt the execution of a program");
        var myNum = scanner.nextInt();
        System.out.println(myNum);
        while (myNum != 2) {
            System.out.println("Please, try again");
            myNum = scanner.nextInt();
        }
        System.out.println("Great, you are right");
    }
}