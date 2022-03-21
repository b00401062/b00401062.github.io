package codechef;

import java.util.Scanner;

class SMRSTR {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner stdin = new Scanner(System.in);
        int t = stdin.nextInt();
        while (t-- > 0) {
            int n = stdin.nextInt();
            int q = stdin.nextInt();
            long p = 1;
            while (n-- > 0 && p <= (int) 1e9)
                p *= stdin.nextInt();
            stdin.nextLine();
            while (q-- > 0)
                System.out.printf("%d ", stdin.nextInt() / p);
            System.out.println();
        }
    }
}

