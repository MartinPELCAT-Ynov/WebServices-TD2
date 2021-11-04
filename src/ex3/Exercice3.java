package ex3;

import java.util.*;

public class Exercice3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(extraireCaracteresOccurences(s));
        }
    }

    public static Map<Character, Integer> extraireCaracteresOccurences(String string) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
}
