package dinner.party;
public class DinnerParty {
    public static void main(String[] args) {
        PartyController partyController = new PartyController();
        while (partyController.running){
        partyController.friendsNames();
        }
    }
}
