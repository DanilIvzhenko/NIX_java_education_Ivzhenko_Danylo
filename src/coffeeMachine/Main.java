package coffeeMachine;

import java.util.Scanner;
public class Main
{
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        CoffeeMachine.stageFirst();
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        while(coffeeMachine.running){
            coffeeMachine.printingSentences();
            String input = scanner.nextLine();
            coffeeMachine.processInput(input);
        }


    }
}
