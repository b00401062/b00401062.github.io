package rosalind;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class DBRU {
    private static final Map<Character, Character> COMPLEMENT = new HashMap<>() {{
        put('A', 'T'); put('C', 'G'); put('G', 'C'); put('T', 'A');
    }};
    private static String rc(String seq) {
        return new StringBuilder(seq)
        .reverse()
        .chars()
        .mapToObj(x -> (char) x)
        .map(COMPLEMENT::get)
        .map(String::valueOf)
        .collect(Collectors.joining());
    }
    private static void add(Map<String, Set<String>> map, String seq) {
        String k = seq.substring(0, seq.length() - 1);
        String v = seq.substring(1);
        if (map.containsKey(k))
            map.get(k).add(v);
        else
            map.put(k, new HashSet<String>() {{ add(v); }});
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        Map<String, Set<String>> map = new HashMap<>();
        while (stdin.hasNextLine()) {
            String seq = stdin.nextLine();
            add(map, seq);
            add(map, rc(seq));
        }
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            String k = entry.getKey();
            for (String v : entry.getValue())
                System.out.printf("(%s, %s)\n", k, v);
        }
        stdin.close();
    }
}
