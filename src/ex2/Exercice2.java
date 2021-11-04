package ex2;

import java.util.Collection;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Exercice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(extractCharacters(s));
        }
    }

    public static Collection<Character> extractCharacters(String s) {
        int length = s.length();
        Set<Character> characters = new TreeSet<>(Character::compareTo);
        for (int i = 0; i < length; i++) {
            characters.add(s.charAt(i));
        }
        return characters;
    }
}
