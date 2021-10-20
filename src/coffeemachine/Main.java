package coffeemachine;

import java.util.Scanner;

import static coffeemachine.CoffeeMachine.countCoffee;
import static coffeemachine.CoffeeMachine.countCups;

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
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();
        countCups(water, milk, coffeeBeans, cups);

    }
}
