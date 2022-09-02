package rosalind;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class PROT {
    private static final Map<String, Character> CODON = new HashMap<String, Character>() {{
        put("UUU", 'F'); put("CUU", 'L'); put("AUU", 'I'); put("GUU", 'V');
        put("UUC", 'F'); put("CUC", 'L'); put("AUC", 'I'); put("GUC", 'V');
        put("UUA", 'L'); put("CUA", 'L'); put("AUA", 'I'); put("GUA", 'V');
        put("UUG", 'L'); put("CUG", 'L'); put("AUG", 'M'); put("GUG", 'V');
        put("UCU", 'S'); put("CCU", 'P'); put("ACU", 'T'); put("GCU", 'A');
        put("UCC", 'S'); put("CCC", 'P'); put("ACC", 'T'); put("GCC", 'A');
        put("UCA", 'S'); put("CCA", 'P'); put("ACA", 'T'); put("GCA", 'A');
        put("UCG", 'S'); put("CCG", 'P'); put("ACG", 'T'); put("GCG", 'A');
        put("UAU", 'Y'); put("CAU", 'H'); put("AAU", 'N'); put("GAU", 'D');
        put("UAC", 'Y'); put("CAC", 'H'); put("AAC", 'N'); put("GAC", 'D');
        put("UAA", null); put("CAA", 'Q'); put("AAA", 'K'); put("GAA", 'E');
        put("UAG", null); put("CAG", 'Q'); put("AAG", 'K'); put("GAG", 'E');
        put("UGU", 'C'); put("CGU", 'R'); put("AGU", 'S'); put("GGU", 'G');
        put("UGC", 'C'); put("CGC", 'R'); put("AGC", 'S'); put("GGC", 'G');
        put("UGA", null); put("CGA", 'R'); put("AGA", 'R'); put("GGA", 'G');
        put("UGG", 'W'); put("CGG", 'R'); put("AGG", 'R'); put("GGG", 'G');
    }};
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        String seq = stdin.next();
        System.out.println(Arrays.stream(seq.substring(0, seq.length()-3).split("(?<=\\G...)")).map(CODON::get).map(String::valueOf).collect(Collectors.joining()));
        stdin.close();
    }
}
