package ex4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResultatAnalyse {

    String string;

    public ResultatAnalyse(String string) {
        this.string = string;
    }

    public Character getMostUsedCharacter() {

        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < this.string.length(); i++) {
            char c = this.string.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int max = 0;
        Character c = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                c = entry.getKey();
            }
        }
        return c;
    }

    public Collection<Character> getSortedUsedCharacters() {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < this.string.length(); i++) {
            char c = this.string.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map.keySet();
    }

    public Collection<Character> getMostUsedCharacters() {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < this.string.length(); i++) {
            char c = this.string.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        ArrayList<Character> list = new ArrayList<>();
        int max = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                list.clear();
                list.add(entry.getKey());
            } else if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public Map<Character, Integer> getCharactersAndOccurences() {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < this.string.length(); i++) {
            char c = this.string.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }


}
