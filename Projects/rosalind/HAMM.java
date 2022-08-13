package rosalind;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class HAMM {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        String seq = stdin.next(), pat = stdin.next();
        System.out.println(IntStream.range(0, seq.length()).filter(i -> seq.charAt(i) != pat.charAt(i)).count());
        stdin.close();
    }
}
