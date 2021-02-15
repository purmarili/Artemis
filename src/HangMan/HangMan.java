package HangMan;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangMan {
    private Scanner sc = new Scanner(System.in);
    private Random rand = new Random();
    private File file = new File("C:\\Users\\jemso\\Desktop\\Class\\Artemis\\src\\HangMan\\Words.txt");
    private BufferedReader br;
    private ArrayList<String> words = new ArrayList<>();

    private int lives = 5;

    public HangMan() {

//        String input = sc.nextLine();
//        while (!input.equals("")){
//            words.add(input);
//        }

        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true){
            String word = null;
            try {
                word = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (word == null) break;
            words.add(word.toLowerCase());
        }
    }

    public void startGame(){
        boolean playAgain = true;
        while (playAgain) {
            lives = 5;
            int index = rand.nextInt(words.size());
            String willToPlay = "";
            String guessedLetters = "";
            String wordToGuess = words.get(index);
            String guess = makeBlankWord(wordToGuess.length());
            System.out.println("Tamashi daiwyo, gamoicanit sityva: ");
            boolean winGame = false;
            while (!winGame && lives > 0) {
                System.out.println(guess);
                System.out.println("Shemoiyvanet simbolo: ");
                String input = sc.nextLine().toLowerCase();
                if (input.length() == 1 && input.matches("[a-zA-Z]")) {
                    if (!wordToGuess.contains(input)) {
                        lives--;
                        System.out.println("Simbolo arasworia, Tqven dagrchat: " + lives + " Sicocxle");
                        continue;
                    }
                    if (guessedLetters.contains(input)) {
                        System.out.println("Es simbolo ukve shemoyvanilia");
                        continue;
                    } else {
                        guess = changeOutput(guess, wordToGuess, input.charAt(0));
                        guessedLetters += input;
                    }
                } else {
                    System.out.println("Shemoiyvanet 1 (a - Z) simbolo");
                }
                if (!guess.contains("-")) winGame = true;
            }
            if (winGame) {
                System.out.println("Gilocavt gamarjvebas, gamosacnobi sityva iyo: " + wordToGuess);
            } else {
                System.out.println("Tqven damarcxdit, gamosacnobi sityva iyo: " + wordToGuess);
            }
            System.out.println("Gsurt kidev tamashi?: Y/N");
            willToPlay = sc.nextLine();
            while (!willToPlay.toLowerCase().equals("y") && !willToPlay.toLowerCase().equals("n")) {
                willToPlay = sc.nextLine();
            }
            if (willToPlay.equals("n")){
                playAgain = false;
            }
        }
    }

    private String makeBlankWord(int size){
        String res = "";
        for (int i=0; i<size; i++){
            res += "-";
        }
        return res;
    }

    private String changeOutput(String str, String wordToGuess, char ch){
        for (int i=0; i<str.length(); i++){
            if (wordToGuess.charAt(i) == ch){
                str = str.substring(0, i) + ch + str.substring(i + 1);
            }
        }
        return str;
    }
}
