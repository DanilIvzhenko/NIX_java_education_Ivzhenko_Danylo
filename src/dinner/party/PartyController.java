package dinner.party;
import java.text.NumberFormat;
import java.util.*;
public class PartyController {
    boolean running = true;
    Scanner scanner = new Scanner(System.in);
    Map<String, Double> people = new HashMap<>();
    Random random = new Random();

    void friendsNames() {
        System.out.print("Enter the number of friends joining (including you): ");
        whoWasOnParty();
    }
    void whoWasOnParty() {
        int friendsCount = scanner.nextInt();
        if (friendsCount == 0) {
            System.out.println("No one is joining for the party");
            running = false;
        } else {
            System.out.println("Enter the name of every friend (including you), each on a new line: ");
            while (friendsCount-- > 0)
                people.put(scanner.next(), 0.0);
            amountOfPeople();
        }
    }
    void amountOfPeople() {
        System.out.println("Enter the total amount: ");
        double check = scanner.nextInt();
        String luckyBoy = chooseLuckyFriend();

        for (String friend: people.keySet())
            if (luckyBoy == null)
                people.put(friend, Math.round(check/people.size()*100)/100.0);
            else if(friend != luckyBoy)
                people.put(friend, Math.round(check/(people.size()-1)*100)/100.0);
        System.out.println(people);
        people.clear();
    }
    String chooseLuckyFriend() {
        String luckyBoy = null;
        System.out.print("Do you want to use the \"Who is lucky?\" feature? Write Yes/No: ");
        switch (scanner.next()) {
            case "Yes" -> {
                luckyBoy = (String) people.keySet().toArray()[random.nextInt(people.size())];
                System.out.println(luckyBoy + " is the lucky one!");
            }
            case "No" -> System.out.println("No one is going to be lucky");
        }
        return luckyBoy;
    }
}


