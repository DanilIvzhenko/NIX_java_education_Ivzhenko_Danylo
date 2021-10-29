package Hangman;
import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Hangman hangman = new Hangman();
        while (hangman.running /*true*/) {
            hangman.printTheGuess();
            String inputLetter = scanner.next();
            hangman.processOfInputLetters(inputLetter);
        }
    }
}