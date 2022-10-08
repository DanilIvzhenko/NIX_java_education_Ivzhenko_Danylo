package coffeeMachine;
enum Status { CHOOSING_ACTION, CHOOSING_COFFEE_TYPE, SUPPLEMENT }
enum Supplement { WATER, MILK, COFFEEBEANS, CUPS, NOTHING }
record Coffee(int water, int milk, int coffee, int money){}
public class CoffeeMachine {
    boolean running = true;
    int water = 400;
    int milk = 540;
    int coffeeBeans = 120;
    int cups = 9;
    int money = 550;
    Status machineStatus = Status.CHOOSING_ACTION;
    Supplement supplement = Supplement.NOTHING;
    public static final int ESPRESSO = 1;
    public static final int LATTE = 2;
    public static final int CAPPUCCINO = 3;
    public static final int BACK = 4;
    Coffee espresso = new Coffee(250, 0, 16, 4);
    Coffee latte = new Coffee(350, 75, 20, 7);
    Coffee cappuccino = new Coffee(200, 100, 12, 6);

    static void stageFirst(){
        System.out.println("\nStarting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }


    void makingCoffee(Coffee drinking){
        if(cups < 1){
            System.out.println("Sorry, i don`t have enough cups to make you a coffee!");
        } else if(!(water >= drinking.water())){
            System.out.println("Sorry, i don`t have enough water to make you a coffee!");
        } else if(!(milk >= drinking.milk())){
            System.out.println("Sorry, i don`t have enough milk to make you a coffee!");
        } else if(!(coffeeBeans >= drinking.coffee())){
            System.out.println("Sorry, i don`t have enough coffee beans to make you a coffee!");
        } else{
            System.out.println("I have enough resources, making you a coffee!");
            money += drinking.money();
            water -= drinking.water();
            milk -= drinking.milk();
            coffeeBeans -= drinking.coffee();
            cups--;
        }
        machineStatus = Status.CHOOSING_ACTION;
    }

    void availableResourcess() { //printing all resources your coffee machine has
        System.out.println("\nThe coffee machine has: ");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    //Stage 4-6
    public Boolean chooseBeverage(int coffeeType) {
        boolean canMakeTheCoffee = false;
        switch (coffeeType) {
            case BACK -> {
                printingSentences();
            }
            case ESPRESSO -> { //making espresso
                makingCoffee(espresso);
            }
            case LATTE -> { //making latte
                makingCoffee(latte);
            }
            case CAPPUCCINO -> { //making cappuccino
                makingCoffee(cappuccino);
            }
            default -> throw new IllegalStateException("Unexpected value: " + coffeeType);
        }
        return canMakeTheCoffee;
    }

    void supplement(int amount) {
        switch (supplement) {
            case WATER -> {
                water += amount;
                supplement = Supplement.MILK;
            }
            case MILK -> {
                milk += amount;
                supplement = Supplement.COFFEEBEANS;
            }
            case COFFEEBEANS -> {
                coffeeBeans += amount;
                supplement = Supplement.CUPS;
            }
            case CUPS -> {
                cups += amount;
                supplement = Supplement.NOTHING;
                machineStatus = Status.CHOOSING_ACTION;
            }
        }
    }

    void printingSentences(){
        switch (machineStatus){
            case CHOOSING_ACTION -> System.out.print("\nWrite action: (buy, fill, take, remaining, exit) -> ");
            case CHOOSING_COFFEE_TYPE -> System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, 4 - back - to main menu: ");
            case SUPPLEMENT -> {
                switch (supplement){
                    case WATER -> System.out.print("Write how many ml of water do you want to add: ");
                    case MILK -> System.out.print("Write how many ml of milk do you want to add: ");
                    case COFFEEBEANS -> System.out.print("Write how many grams of coffee beans do you want to add: ");
                    case CUPS -> System.out.print("Write how many disposable cups of coffee do you want to add: ");
                }
            }

        }
    }

    void printingAction(String inputAction) {
        switch (inputAction) {
            case ("buy"):
                machineStatus = Status.CHOOSING_COFFEE_TYPE;
                break;
            case ("fill"):
                machineStatus = Status.SUPPLEMENT;
                supplement = Supplement.WATER;
                break;
            case ("take"):
                take();
                machineStatus = Status.CHOOSING_ACTION;
                break;
            case ("remaining"):
                availableResourcess();
                machineStatus = Status.CHOOSING_ACTION;
                break;
            case ("exit"):
                running = false;
                return;
            default:
                System.out.println("Rewrite the action please!");
        }
    }
    void processInput(String input) {
        switch (machineStatus) {
            case CHOOSING_ACTION -> printingAction(input);
            case CHOOSING_COFFEE_TYPE -> chooseBeverage(Integer.parseInt(input));
            case SUPPLEMENT -> supplement(Integer.parseInt(input));
        }
    }
    void take() {
        System.out.println("I gave you " + money);
        money = 0;
    }
}