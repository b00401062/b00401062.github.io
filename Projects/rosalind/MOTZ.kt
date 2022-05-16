package rosalind;

import java.io.*;
import java.util.*;

public class MOTZ {
    private static final Map<String, Integer> CACHE = new HashMap<String, Integer>() {{
        put("", 1);
        put("A", 1); put("C", 1); put("G", 1); put("U", 1);
        put("AA", 1); put("AC", 1); put("AG", 1); put("AU", 2);
        put("CA", 1); put("CC", 1); put("CG", 2); put("CU", 1);
        put("GA", 1); put("GC", 2); put("GG", 1); put("GU", 1);
        put("UA", 2); put("UC", 1); put("UG", 1); put("UU", 1);
    }};
    private static int motzkin(String read) {
        if (CACHE.containsKey(read))
            return CACHE.get(read);
        int motzkin = motzkin(read.substring(1));
        for (int i = 1; i < read.length(); i++) {
            if (CACHE.get(String.format("%c%c", read.charAt(0), read.charAt(i))) == 1)
                continue;
            String head = read.substring(1, i), tail = read.substring(i+1);
            if (!CACHE.containsKey(head))
                CACHE.put(head, motzkin(head));
            if (!CACHE.containsKey(tail))
                CACHE.put(tail, motzkin(tail));
            motzkin = (int) (((long) CACHE.get(head) * CACHE.get(tail) + motzkin) % 1000000);
        }
        return motzkin;
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        stdin.next();
        String read = "";
        while (stdin.hasNext())
            read += stdin.next();
        System.out.println(motzkin(read));
        stdin.close();
    }
}
