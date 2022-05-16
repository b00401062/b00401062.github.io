package rosalind;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class ORF {
    private static final Map<String, Character> CODON = new HashMap<String, Character>() {{
        put("TTT", 'F'); put("CTT", 'L'); put("ATT", 'I'); put("GTT", 'V');
        put("TTC", 'F'); put("CTC", 'L'); put("ATC", 'I'); put("GTC", 'V');
        put("TTA", 'L'); put("CTA", 'L'); put("ATA", 'I'); put("GTA", 'V');
        put("TTG", 'L'); put("CTG", 'L'); put("ATG", 'M'); put("GTG", 'V');
        put("TCT", 'S'); put("CCT", 'P'); put("ACT", 'T'); put("GCT", 'A');
        put("TCC", 'S'); put("CCC", 'P'); put("ACC", 'T'); put("GCC", 'A');
        put("TCA", 'S'); put("CCA", 'P'); put("ACA", 'T'); put("GCA", 'A');
        put("TCG", 'S'); put("CCG", 'P'); put("ACG", 'T'); put("GCG", 'A');
        put("TAT", 'Y'); put("CAT", 'H'); put("AAT", 'N'); put("GAT", 'D');
        put("TAC", 'Y'); put("CAC", 'H'); put("AAC", 'N'); put("GAC", 'D');
        put("TAA", null); put("CAA", 'Q'); put("AAA", 'K'); put("GAA", 'E');
        put("TAG", null); put("CAG", 'Q'); put("AAG", 'K'); put("GAG", 'E');
        put("TGT", 'C'); put("CGT", 'R'); put("AGT", 'S'); put("GGT", 'G');
        put("TGC", 'C'); put("CGC", 'R'); put("AGC", 'S'); put("GGC", 'G');
        put("TGA", null); put("CGA", 'R'); put("AGA", 'R'); put("GGA", 'G');
        put("TGG", 'W'); put("CGG", 'R'); put("AGG", 'R'); put("GGG", 'G');
    }};
    private static final Map<Character, Character> COMPLEMENT = new HashMap<Character, Character>() {{
        put('A', 'T'); put('C', 'G'); put('G', 'C'); put('T', 'A');
    }};
    private static Set<String> translate(String dna) {
        Set<String> orfs = new HashSet<>();
        StringBuilder orf = null;
        for (int i = 0; i < dna.length()/3; i++)
            if (dna.substring(i*3, i*3+3).equals("ATG")) {
                orf = new StringBuilder();
                Character aa = null;
                for (; i < dna.length()/3 && (aa = CODON.get(dna.substring(i*3, i*3+3))) != null; i++)
                    orf.append(aa);
                if (aa == null)
                    for (int j = 0; j < orf.length(); j++)
                        if (orf.charAt(j) == 'M')
                            orfs.add(orf.substring(j));
            }
        return orfs;
    }
    public static void main(String args[]) throws IOException {
        Scanner stdin = new Scanner(System.in);
        PrintStream stdout = System.out;
        stdin.next();
        String seq = "";
        while (stdin.hasNext())
            seq += stdin.next();
        String rev = new StringBuilder(seq).reverse().chars().mapToObj(x -> (char) x).map(COMPLEMENT::get).map(String::valueOf).collect(Collectors.joining());
        Set<String> orfs = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            orfs.addAll(translate(seq.substring(i)));
            orfs.addAll(translate(rev.substring(i)));
        }
        orfs.forEach(stdout::println);
        stdin.close();
    }
}
