package Tictactoe;

public class MainTictactoe {
    public static void main(String[] args) {
        Tictactoe tictactoe = new Tictactoe();
        String[][] tictactoeField = new String[3][3];
        tictactoe.printingFinishedField();
        tictactoe.showGameStatus(tictactoeField);
        System.out.println(tictactoe.checkWinner());
    }
}
