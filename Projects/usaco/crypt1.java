package usaco;

import java.io.*;
import java.util.*;

public class crypt1 {
    private static List<Integer> digits;
    private static boolean isCrypt(int num) {
        for (; num > 0; num /= 10)
            if (!digits.contains(num % 10))
                return false;
        return true;
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("crypt1.in"));
        PrintWriter stdout = new PrintWriter(new File("crypt1.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        final int N = stdin.nextInt();
        digits = new ArrayList<Integer>(N);
        for (int i = 0; i < N; i++)
            digits.add(stdin.nextInt());
        int count = 0, elem = 0;
        List<Integer> stack = new ArrayList<Integer>(N);
        do {
            stack.add(digits.get(digits.indexOf(elem) + 1));
            for (int i = stack.size(); i < 5; i++)
                stack.add(digits.get(0));
            int n1 = 100 * stack.get(0) + 10 * stack.get(1) + stack.get(2);
            int n2 = 10 * stack.get(3) + stack.get(4);
            int p1 = n1 * stack.get(4);
            int p2 = n1 * stack.get(3);
            int sum = n1 * n2;
            if (p1 < 1000 && p2 < 1000 && isCrypt(p1) && isCrypt(p2) && isCrypt(sum))
                    count++;
            while(stack.size() > 0 && (elem = stack.remove(stack.size()-1)) == digits.get(N-1));
        } while (elem != digits.get(N-1));
        stdout.println(count);
        stdin.close();
    }
}
