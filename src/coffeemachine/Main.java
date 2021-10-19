package coffeemachine;

import java.util.Scanner;

import static coffeemachine.CoffeeMachine.countCoffee;

public class Main
{
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        //Stage 1
        /*
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!"); */

        System.out.println("Write how many cups of coffee you will need:");
        countCoffee(scanner.nextInt());
    }
}
