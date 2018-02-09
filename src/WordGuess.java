/**
 * Created by shauryavratxg19 on 9/27/2017.
 */
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class WordGuess {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final String SECRET_WORD = "TREEHOUSE";
        final List<Character> SECRET_ARRAY = getLetters(SECRET_WORD);
        final Character FLAG = new Character('!');
        String wordGuess = "", wordSoFar = "";
        Character letterGuess;
        List<Character> wordSoFarArray;
        int guessCount = 0;

        System.out.println("Guess the Word game!");

        for (int i = 0; i < SECRET_WORD.length(); i++) {wordSoFar += "-";}
        wordSoFarArray = getLetters(wordSoFar);

        System.out.println(wordSoFar + "\n");

        do {
            System.out.printf("Enter a letter (%s to guess entire word): ", FLAG);
            List<Integer> indexList = new ArrayList<>();
            letterGuess = new Character(input.nextLine().toUpperCase().toCharArray()[0]);
            guessCount++;

            //get a list of indexes where the letter is, if it's correct
            for (int i = 0; i < SECRET_ARRAY.size(); i++) {
                if (SECRET_ARRAY.get(i).equals(letterGuess)) {indexList.add(i);}
            }

            //update the word so far at the specified indexes
            for (int index : indexList) {wordSoFarArray.set(index, letterGuess);}
            wordSoFar = charListToString(wordSoFarArray);

            System.out.println(wordSoFar);
        } while (!letterGuess.equals(FLAG) && !wordSoFar.equals(SECRET_WORD));

        if (letterGuess.equals(FLAG)) {
            System.out.println("What is your guess? ");
            wordGuess = input.nextLine().toUpperCase();
        }

        if (wordGuess.equals(SECRET_WORD) || wordSoFar.equals(SECRET_WORD)) {System.out.println("You win!");}
        else {System.out.println("You lose.");}

        System.out.printf("\nThe secret word is %s.", SECRET_WORD);
        System.out.printf("\nYou made %s guesses.", guessCount);
    }

    public static List<Character> getLetters(String input) {
        List<Character> output = new ArrayList<>();
        for (char letter : input.toCharArray()) {output.add(new Character(letter));}
        return output;
    }

    public static String charListToString(List<Character> list) {
        StringBuilder builder = new StringBuilder();
        for (Character letter : list) {builder.append(letter.charValue());}
        return builder.toString();
    }
}
