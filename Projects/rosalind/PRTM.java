package rosalind;

import java.util.*;

public class PRTM {
    private static final Map<Character, Double> AAWT = new HashMap<Character, Double>() {{
        put('A',  71.037110); put('C', 103.009190); put('D', 115.026940); put('E', 129.042590);
        put('F', 147.068410); put('G',  57.021460); put('H', 137.058910); put('I', 113.084060);
        put('K', 128.094960); put('L', 113.084060); put('M', 131.040490); put('N', 114.042930);
        put('P',  97.052760); put('Q', 128.058580); put('R', 156.101110); put('S',  87.032030);
        put('T', 101.047680); put('V',  99.068410); put('W', 186.079310); put('Y', 163.063330);
    }};
    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        System.out.println(stdin.next().chars().mapToObj(x -> (char) x).mapToDouble(AAWT::get).sum());
        stdin.close();
    }
}
