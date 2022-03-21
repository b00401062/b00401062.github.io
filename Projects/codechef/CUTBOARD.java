package codechef;

import java.io.*;
import java.util.*;

class CUTBOARD {
    public static void main(String[] args) throws Exception {
        Scanner stdin = new Scanner(System.in);
        for (int i = stdin.nextInt(); i > 0; i--) {
            int rows = stdin.nextInt() - 1;
            int column = stdin.nextInt() - 1;
            System.out.println(rows * column);
        }
    }
}
