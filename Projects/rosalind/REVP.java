package rosalind;

import java.util.*;

public class REVP {
    private static final Map<Character, Character> COMPLEMENT = new HashMap<Character, Character>() {{
        put('A', 'T'); put('C', 'G'); put('G', 'C'); put('T', 'A');
    }};
    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        String seq = "";
        stdin.next();
        while (stdin.hasNext())
            seq += stdin.next();
        for (int s = 0; s < seq.length()-1; s++)
            if (COMPLEMENT.get(seq.charAt(s)) == seq.charAt(s+1))
                for (int i = 1; s >= i && s+i+1 < seq.length() && COMPLEMENT.get(seq.charAt(s-i)) == seq.charAt(s+i+1); i++)
                    if (4 <= 2*i+2 && 2*i+2 <= 12)
                        System.out.println(String.format("%d %d", s-i+1, 2*i+2));
        stdin.close();
    }
}
