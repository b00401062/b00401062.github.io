package rosalind;

import java.io.*;
import java.util.*;

public class TREE {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        int n = Integer.parseInt(stdin.nextLine());
        while (stdin.hasNextLine()) {
            stdin.nextLine();
            n--;
        }
        System.out.println(n);
        stdin.close();
    }
}
