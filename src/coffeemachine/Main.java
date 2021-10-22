package coffeemachine;

import java.util.Scanner;

public class Main
{
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int cups = 9;
    static int money = 550;
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

        printResources();
        while (true) {
            System.out.println("\nWrite action: (buy, fill, take, remaining, exit)");
            String input = scanner.nextLine();
            switch (input) {
                case ("buy") -> buy();
                case ("fill") -> fill();
                case ("take") -> take();
                case ("remaining") -> remaining();
                case ("exit") -> exit();
            }
        }
    }

    static void printResources() {
        System.out.println(" ");
        System.out.println("The coffee machine has: ");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    static void buy () {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        if(CoffeeMachine.buy(Integer.parseInt(scanner.nextLine()))){
            System.out.println("Making you a coffee");
        }else{
            System.out.println("I don`t have enough resources");
        }
        printResources();
    }

    static void fill () {
        System.out.print("Write how many ml of water do you want to add: ");
        water += Integer.parseInt(scanner.nextLine());
        System.out.print("Write how many ml of milk do you want to add: ");
        milk += Integer.parseInt(scanner.nextLine());
        System.out.print("Write how many grams of coffee beans do you want to add: ");
        coffeeBeans += Integer.parseInt(scanner.nextLine());
        System.out.print("Write how many disposable cups of coffee do you want to add: ");
        cups += Integer.parseInt(scanner.nextLine());
        printResources();
    }

    static void take() {
        System.out.println("I gave you " + money);
        money = 0;
        printResources();
    }

    static void remaining() {
        printResources();
    }

    static void exit() {
        System.exit(0);
    }
}
