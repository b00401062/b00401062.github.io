package rosalind;

import java.io.*;
import java.util.*;

public class RNA {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        String seq = stdin.nextLine();
        System.out.print(seq.replaceAll("T", "U"));
        stdin.close();
    }
}
