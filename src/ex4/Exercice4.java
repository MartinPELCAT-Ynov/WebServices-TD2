package ex4;

import java.util.Scanner;

public class Exercice4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            ResultatAnalyse resultatAnalyse = new ResultatAnalyse(s);
            System.out.println("Sorted char : " + resultatAnalyse.getSortedUsedCharacters());
            System.out.println("Most used char: " + resultatAnalyse.getMostUsedCharacter());
            System.out.println("Chars and occurrences : " + resultatAnalyse.getCharactersAndOccurences());
            System.out.println("Most used characters : " + resultatAnalyse.getMostUsedCharacters());
        }
    }
}
