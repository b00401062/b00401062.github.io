package rosalind;

import java.util.*;
import java.util.stream.*;

public class SPLC {
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
    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        String seq = "", intron = null;
        while (true) {
            if (!stdin.hasNext()) {
                seq = seq.replaceAll(intron, "");
                break;
            }
            String line = stdin.next();
            if (line.charAt(0) == '>') {
                if (intron != null)
                    seq = seq.replaceAll(intron, "");
                if (seq != "")
                    intron = "";
            } else if (intron == null)
                seq += line;
            else
                intron += line;
        }
        System.out.println(Arrays.stream(seq.substring(0, seq.length()-3).split("(?<=\\G...)")).map(CODON::get).map(String::valueOf).collect(Collectors.joining()));
        stdin.close();
    }
}
