package Hangman;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hangman {
    boolean running = true;
    enum State {PROMPT, STARTING, PLAYTHEGAME}

    String word = getRandomWord();
    String hiddenWord;
    int lives = 8;
    State status = State.PROMPT;
    void printTheGuess() {
        switch (status) {
            case PROMPT -> {
                System.out.println("           H A N G M A N");
                System.out.print("Choose  play  if you want play the game, or choose  exit  to quit the game: ");
            }
            case STARTING -> {
                System.out.println(hideTheWord());
                System.out.print("Input a letter:> ");
                status = State.PLAYTHEGAME;
            }
            case PLAYTHEGAME -> {
                playingTheGame();
            }

        }
    }

    void playingTheGame(){
        if (word.equals(hiddenWord)) {
            System.out.println("Thanks for playing!");
            System.out.println("We'll see how well you did in the next stage");
            running = false;
            
        }
        if (lives > 0) {
            System.out.println(hiddenWord);
            System.out.print("Input a letter:> ");
        } else {
            System.out.println("You lost!");
            running = false;
        }
    }


    void processOfInputLetters(String inputLetter) {
        switch (status) {
            case PROMPT -> {
                switch (inputLetter) {
                    case "play" -> {
                        status = State.STARTING;
                    }
                    case "exit" -> {
                        running = false;
                    }
                    default -> {
                        System.out.println("UNKNOWN COMMAND! ERROR!");
                    }
                }
            }
            case STARTING, PLAYTHEGAME -> {
                guessTheWord(inputLetter);
            }
        }
    }// hiding the world
    String hideTheWord() {
        hiddenWord = word.replaceAll(".", "-");
        return hiddenWord;
    }// getting of random world
    String getRandomWord() {
        String[] strArray = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        return strArray[random.nextInt(strArray.length)];
    }// unlocking the letter in the world
    void unblockTheLetter(char letter) {
        for (int l = 0; l < word.length(); l++) {
            if (word.charAt(l) == letter) {
                StringBuilder unblockedWord = new StringBuilder(hiddenWord);
                unblockedWord.setCharAt(l, letter);
                hiddenWord = unblockedWord.toString();
            }
        }
    }// guessing the word by regex, pattern, matcher, lives
    void guessTheWord(String letter) {
        String regex = "[a-z]";
        boolean res;
        Pattern patternNew = Pattern.compile(regex);
        Matcher matcher = patternNew.matcher(letter);
        res = matcher.matches();
        if (letter.length() > 1) {
            System.out.println("You should input a single letter");
        } else if (!res) {
            System.out.println("Please enter an lowercase English letter");
        } else if (hiddenWord.contains(letter)) {
            System.out.println("You've already guessed this letter");
        } else if (word.contains(letter)) {
            unblockTheLetter(letter.charAt(0));
        } else {
            System.out.println("That letter doesn't appear in the word");
            lives--;
        }
    }
}