package coffeemachine;

import static java.lang.Math.min;

public class CoffeeMachine
{
    static void countCoffee(int cups)
    {
        int coffeeBeans = 15;
        int milk = 50;
        int water = 200;

        System.out.println("For " + cups + " of coffee you will need:" );
        System.out.println(water * cups + " ml of water");
        System.out.println(milk * cups + " ml of milk");
        System.out.println(coffeeBeans * cups + " g of coffee beans");
    }

    static void countCups(int water, int milk, int coffeeBeans, int cups)
    {
        //200 ml water, 50 ml milk, 15g coffee

        int resCups = Math.min(water / 200, Math.min(milk / 50, coffeeBeans / 15));

        if (cups == resCups)
        {
            System.out.println("Yes, i can make that amount of coffee");
        }
        else if (resCups > cups)
        {
            System.out.println("Yes, I can make that amount of coffee and even " + resCups + " more than that");
        }
        else
        {
            System.out.println("No, i can make only " + (resCups) + " cups of coffee");
        }
    }
}
