package coffeemachine;

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
}
