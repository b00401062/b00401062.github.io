package rosalind;

import java.io.*;
import java.util.*;

public class IEV {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        double ans = 0;
        ans += 2 * (stdin.nextInt() + stdin.nextInt() + stdin.nextInt());
        ans += 1.5 * stdin.nextInt() + stdin.nextInt();
        System.out.println(ans);
        stdin.close();
    }
}
