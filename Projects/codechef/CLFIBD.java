package codechef;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class CLFIBD {
    private static boolean check(int[] c) {
        c = Arrays.stream(c).filter(i -> i != 0).toArray();
        Arrays.sort(c);
        boolean flag = true;
        for (int i = 0; i < c.length - 2; i++)
            if (c[i] + c[i + 1] != c[i + 2])
                flag = false;
        if (flag) return true;
        c[0] ^= c[1] ^ (c[1] = c[0]);
        for (int i = 0; i < c.length - 2; i++)
            if (c[i] + c[i + 1] != c[i + 2])
                return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        int t = stdin.nextInt();
        while (t-- > 0) {
            int[] c = new int[26];
            stdin.next().chars().forEach(i -> c[i - 'a']++);
            System.out.println(check(c) ? "Dynamic" : "Not");
        }
    }
}
