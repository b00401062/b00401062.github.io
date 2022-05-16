package rosalind;

import java.io.*;
import java.util.*;

public class CAT {
    private static final Map<String, Integer> CACHE = new HashMap<String, Integer>() {{
        put("", 1);
        put("AA", 0); put("AC", 0); put("AG", 0); put("AU", 1);
        put("CA", 0); put("CC", 0); put("CG", 1); put("CU", 0);
        put("GA", 0); put("GC", 1); put("GG", 0); put("GU", 0);
        put("UA", 1); put("UC", 0); put("UG", 0); put("UU", 0);
    }};
    private static int catalan(String read) {
        int catalan = 0;
        if (CACHE.containsKey(read))
            return CACHE.get(read);
        for (int i = 0; i < read.length()/2; i++) {
            if (CACHE.get(String.format("%c%c", read.charAt(0), read.charAt(2*i+1))) == 0)
                continue;
            String head = read.substring(1, 2*i+1), tail = read.substring(2*i+2);
            if (!CACHE.containsKey(head))
                CACHE.put(head, catalan(head));
            if (!CACHE.containsKey(tail))
                CACHE.put(tail, catalan(tail));
            catalan = (int) (((long) CACHE.get(head) * CACHE.get(tail) + catalan) % 1000000);
        }
        return catalan;
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        stdin.next();
        String read = "";
        while (stdin.hasNext())
            read += stdin.next();
        System.out.println(catalan(read));
        stdin.close();
    }
}
