package Tictactoe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Tictactoe {
    Scanner scanner = new Scanner(System.in);
    static ArrayList<Integer> xPositions = new ArrayList<Integer>();
    static ArrayList<Integer> oPositions = new ArrayList<Integer>();
    static boolean isXWinner = false;
    static boolean isOWinner = false;

    public void getWinnerConditions() {
        List topRow = Arrays.asList(0, 1, 2);
        List middleRow = Arrays.asList(3, 4, 5);
        List bottomRow = Arrays.asList(6, 7, 8);
        List leftCol = Arrays.asList(0, 3, 6);
        List middleCol = Arrays.asList(1, 4, 7);
        List rightCol = Arrays.asList(2, 5, 8);
        List cross1 = Arrays.asList(0, 4, 8);
        List cross2 = Arrays.asList(6, 4, 2);
        List<List> winningConditions = new ArrayList<>();
        winningConditions.add(topRow);
        winningConditions.add(middleRow);
        winningConditions.add(bottomRow);
        winningConditions.add(leftCol);
        winningConditions.add(rightCol);
        winningConditions.add(middleCol);
        winningConditions.add(cross1);
        winningConditions.add(cross2);
        for (List l : winningConditions) {
            if (xPositions.containsAll(l)) {
                isXWinner = true;
            }
            if (oPositions.containsAll(l)) {
                isOWinner = true;
            }
        }
    }

    public void printingFinishedField() {
        System.out.println("""
                X O X
                O X O
                O O X""");
    }

    public String[][] readCells(String[][] ticTacToeField) {
        System.out.print("Enter Cells: ");
        String cells = scanner.next();
        String[] cell = cells.split("");
        for (int c = 0; c < 3; c++) {
            for (int r = 0; r < 3; r++) {
                ticTacToeField[c][r] = cell[3 * c + r];
                if (cell[3 * c + r].equals("X")) {
                    xPositions.add(3 * c + r);
                } else if (cell[3 * c + r].equals("O")) {
                    oPositions.add(3 * c + r);
                }
            }
        }
        return ticTacToeField;
    }
    //column - c , row - r
    public void showGameStatus(String[][] tictactoeField) {
        readCells(tictactoeField);
        System.out.println("---------");
        for (int c = 0; c < 3; c++) {
            System.out.print("| ");
            for (int r = 0; r < 3; r++) {
                System.out.printf("%s ", tictactoeField[c][r]);
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public String checkWinner() {
        getWinnerConditions();
        if (isOWinner && isXWinner || xPositions.size() - oPositions.size() > 1 || oPositions.size() - xPositions.size()
                > 1) {
            return "Impossible";
        } else if (!isOWinner && !isXWinner && xPositions.size() + oPositions.size() < 9) {
            return "Game not finished";
        } else if (isOWinner && !isXWinner) {
            return "O won";
        } else if (isXWinner && !isOWinner) {
            return "X won";
        } else if (!isXWinner && !isOWinner) {
            return "Draw";
        }
        return "";
    }
}


