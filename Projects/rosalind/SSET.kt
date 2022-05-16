package rosalind;

import java.io.*;
import java.util.*;
import java.math.*;

public class SSET {
    public static void main (String[] args) throws IOException {
        final Scanner stdin = new Scanner(System.in);
        System.out.println(new BigInteger("2").pow(stdin.nextInt()).mod(new BigInteger("1000000")));
        stdin.close();
    }
}
