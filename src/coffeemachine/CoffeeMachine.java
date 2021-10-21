package coffeemachine;

import java.util.Scanner;

import static java.lang.Math.min;

public class CoffeeMachine {


    //Stage 2
    static void countCoffee(int cups) {
        int coffeeBeans = 15;
        int milk = 50;
        int water = 200;

        System.out.println("For " + cups + " of coffee you will need:");
        System.out.println(water * cups + " ml of water");
        System.out.println(milk * cups + " ml of milk");
        System.out.println(coffeeBeans * cups + " g of coffee beans");
    }

    //Stage 3
    static void countCups(int water, int milk, int coffeeBeans, int cups) {
        //200 ml water, 50 ml milk, 15g coffee

        int resCups = Math.min(water / 200, Math.min(milk / 50, coffeeBeans / 15));

        if (cups == resCups) {
            System.out.println("Yes, i can make that amount of coffee");
        } else if (resCups > cups) {
            System.out.println("Yes, I can make that amount of coffee and even " + resCups + " more than that");
        } else {
            System.out.println("No, i can make only " + (resCups) + " cups of coffee");
        }
    }


    static Boolean buy(int coffeeType) {
        boolean canMakeTheCoffee;

        switch (coffeeType) {
            case 1 -> {
                if(Main.water < 250 && Main.coffeeBeans < 16 && Main.cups < 1){
                    canMakeTheCoffee = false;
                }else{
                    Main.water -= 250;
                    Main.coffeeBeans -= 16;
                    Main.cups -= 1;
                    Main.money += 4;
                    canMakeTheCoffee = true;
                }
            }

            case 2 -> {
                if(Main.water < 350 && Main.milk < 75 && Main.coffeeBeans < 20 && Main.cups < 1) {
                    canMakeTheCoffee = false;
                }else{
                Main.water -= 350;
                Main.milk -= 75;
                Main.coffeeBeans -= 20;
                Main.cups -= 1;
                Main.money += 7;
                canMakeTheCoffee = true;
                }
            }
            case 3 -> {
                if(Main.water < 200 && Main.milk < 100 && Main.coffeeBeans < 12 && Main.cups < 1) {
                    canMakeTheCoffee = false;
                }else {
                    Main.water -= 200;
                    Main.milk -= 100;
                    Main.coffeeBeans -= 12;
                    Main.cups -= 1;
                    Main.money += 6;
                    canMakeTheCoffee = true;
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + coffeeType);
        }
        return canMakeTheCoffee;
    }

    static void fill() {
        // will be done in the next stages
    }

    static void take() {
        // will be done in the next stages
    }

    //Stage 4
    /*
    static void limCoffee(int water, int milk, int coffeeBeans, int cups, int money) {
        String s;

        switch (s) {
            case "buy": {
                System.out.println("buy");
            }
            break;
            case "fill": {
                System.out.println("fill");
            }
            break;
            case "take": {
                System.out.println("take");
            }
        }

        String s1;
        s1 = scanner.nextLine();
        switch (s1) {
            case "1": {
                System.out.println("1");
            }
            break;
            case "2": {
                System.out.println("2");
            }
            break;
            case "3": {
                System.out.println("3");
            }
        }

        int buy = scanner.nextInt();
        switch (buy) {
            case 1: // espresso
                water -= 250;
                coffeeBeans -= 16;
                cups -= 1;
                money += 4;
                break;
            case 2: // latte
                water -= 350;
                milk -= 75;
                coffeeBeans -= 20;
                cups -= 1;
                money += 7;
                break;
            case 3: // cappuccino
                water -= 200;
                milk -= 100;
                coffeeBeans -= 12;
                cups -= 1;
                money += 6;
                break;
        }
        int fill = scanner.nextInt();

    } */

}













