package Tictactoe;
public class MainTictactoe {
    public static void main(String[] args) {
        Tictactoe tictactoe = new Tictactoe();
        String[][] fieldOfTicTacToe = new String[3][3];
        tictactoe.finishedField();
        tictactoe.mainSolve(fieldOfTicTacToe);
    }
}

