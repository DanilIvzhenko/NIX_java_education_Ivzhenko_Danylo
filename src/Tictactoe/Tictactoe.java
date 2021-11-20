package Tictactoe;
import java.util.*;
//row - r, column - c
class UsedCoordsExc extends Exception {}
class OutOfBoundsExc extends Exception {}
public class Tictactoe {
    static List<List<Integer>> winningTheConditions;
    Scanner scanner = new Scanner(System.in);
    private final ArrayList<Integer> xPositions = new ArrayList<>();
    private final ArrayList<Integer> oPositions = new ArrayList<>();
    private boolean xWinner = false;
    private boolean oWinner = false;
    private String currentPlayer = "X";
    static {
        List<Integer> topR = Arrays.asList(0, 1, 2);
        List<Integer> middleR = Arrays.asList(3, 4, 5);
        List<Integer> bottomR = Arrays.asList(6, 7, 8);
        List<Integer> leftC = Arrays.asList(0, 3, 6);
        List<Integer> middleC = Arrays.asList(1, 4, 7);
        List<Integer> rightC = Arrays.asList(2, 5, 8);
        List<Integer> cross1 = Arrays.asList(0, 4, 8);
        List<Integer> cross2 = Arrays.asList(6, 4, 2);
        winningTheConditions = new ArrayList<>();
        winningTheConditions.add(topR);
        winningTheConditions.add(middleR);
        winningTheConditions.add(bottomR);
        winningTheConditions.add(leftC);
        winningTheConditions.add(rightC);
        winningTheConditions.add(middleC);
        winningTheConditions.add(cross1);
        winningTheConditions.add(cross2);
    }
    private boolean isOWinner() {
        return oWinner && !xWinner;
    }
    private boolean isxWinner() {
        return xWinner && !oWinner;
    }
    private boolean isDraw() {
        return !xWinner && !oWinner;
    }
    private boolean isImpossible() {
        return (oWinner && xWinner || xPositions.size() - oPositions.size() > 1 || oPositions.size() - xPositions.size()
                > 1);
    }
    private boolean isGameNotFinished() {
        return (!oWinner && !xWinner && xPositions.size() + oPositions.size() < 9);
    }
    void finishedField(){
        System.out.println("---------");
        System.out.println("| X O X |");
        System.out.println("| O X X |");
        System.out.println("| O O X |");
        System.out.println("---------");
        System.out.println("X - wins");
    }
    void mainSolve(String[][] fieldOfTicTacToe){
        readCells(fieldOfTicTacToe);
        showGameStatusField(fieldOfTicTacToe);
        while (checkTheWinnerInTheGame().equals("Game not finished")) {
            makeUserMoveTo(fieldOfTicTacToe);
            showGameStatusField(fieldOfTicTacToe);
            checkTheWinnerInTheGame();
            switchThePlayer();
        }
        System.out.println(checkTheWinnerInTheGame());
    }
    public void switchThePlayer() {
        if (currentPlayer.equals("X")) {
            currentPlayer = "O";
        } else if (currentPlayer.equals("O")) {
            currentPlayer = ("X");
        }
    }
    private void getTheConditionOfTheWinner() {
        for (List<Integer> list : winningTheConditions) {
            if (xPositions.containsAll(list)) {
                xWinner = true;
            } if (oPositions.containsAll(list)) {
                oWinner = true;
            }
        }
    }
    public void readCells(String[][] fieldOfTicTacToe) {
        for (int c = 0; c < 3; c++) {
            for (int r = 0; r < 3; r++) {
                fieldOfTicTacToe[c][r] = " ";
            }
        }
    }
    private void doUserMoveTo(String[][] fieldOfTicTacToe, String moveXorO) throws UsedCoordsExc, OutOfBoundsExc {
        System.out.print("Enter the coordinates: ");
        int c = scanner.nextInt() - 1;
        int r = scanner.nextInt() - 1;
        if (c > 2 || c < 0 || r > 2 || r < 0) {
            throw new OutOfBoundsExc();
        }
        if (fieldOfTicTacToe[c][r].equals("X") || fieldOfTicTacToe[c][r].equals("O")) {
            throw new UsedCoordsExc();
        }
        fieldOfTicTacToe[c][r] = moveXorO;
        if (moveXorO.equals("X")) {
            xPositions.add(3 * c + r);
        } else if (moveXorO.equals("O")) {
            oPositions.add(3 * c + r);
        }
    }
    public void makeUserMoveTo(String[][] fieldOfTicTacToe) {
        try {
            doUserMoveTo(fieldOfTicTacToe, currentPlayer);
        } catch (OutOfBoundsExc exc) {
            System.out.println("Coordinates should be from 1 to 3!");
            makeUserMoveTo(fieldOfTicTacToe);
        } catch (UsedCoordsExc exc) {
            System.out.println("This cell is occupied! Choose another one");
            makeUserMoveTo(fieldOfTicTacToe);
        } catch (InputMismatchException exc) {
            System.out.println("You should enter numbers!");
            scanner.reset();
            scanner.next();
            makeUserMoveTo(fieldOfTicTacToe);
        }
    }
    public void showGameStatusField(String[][] fieldOfTicTacToe) {
        System.out.println("---------");
        for (int c = 0; c < 3; c++) {
            System.out.print("| ");
            for (int r = 0; r < 3; r++) {
                System.out.printf("%s ", fieldOfTicTacToe[c][r]);
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    public String checkTheWinnerInTheGame() {
        getTheConditionOfTheWinner();
        String winnerStatusIs = "NULL";
        if (isImpossible()) {
            winnerStatusIs = "Impossible";
        } else if (isGameNotFinished()) {
            winnerStatusIs = "Game not finished";
        } else if (isOWinner()) {
            winnerStatusIs = "O wins";
        } else if (isxWinner()) {
            winnerStatusIs = "X wins";
        } else if (isDraw()) {
            winnerStatusIs = "Draw";
        }
        return winnerStatusIs;
    }
}



