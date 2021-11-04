package ex1;

import java.util.*;

public class Exercice1 {
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
        Set<Character> characters = new LinkedHashSet<>();
        for (int i = 0; i < length; i++) {
            characters.add(s.charAt(i));
        }
        return characters;
    }
}
