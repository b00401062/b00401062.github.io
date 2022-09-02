package rosalind;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class CORR {
    private static final Map<Character, Character> COMPLEMENT = new HashMap<Character, Character>() {{
        put('A', 'T'); put('C', 'G'); put('G', 'C'); put('T', 'A');
    }};
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        Set<String> reads = new HashSet<>();
        Map<String, Integer> table = new HashMap<>();
        while (stdin.hasNext()) {
            stdin.next();
            String read = stdin.next();
            String revc = new StringBuilder(read).reverse().chars().mapToObj(x -> (char) x).map(COMPLEMENT::get).map(String::valueOf).collect(Collectors.joining());
            reads.add(read);
            table.put(read, table.containsKey(read) ? table.get(read)+1 : 1);
            table.put(revc, table.containsKey(revc) ? table.get(revc)+1 : 1);
        }
        final int n = reads.stream().toArray(String[]::new)[0].length();
        for (String pat : reads)
            if (table.get(pat) == 1)
                for (String seq : table.keySet())
                    if (table.get(seq) > 1 && IntStream.range(0, n).filter(i -> seq.charAt(i) != pat.charAt(i)).count() == 1) {
                        System.out.println(pat + "->" + seq);
                        break;
                    }
        stdin.close();
    }
}
