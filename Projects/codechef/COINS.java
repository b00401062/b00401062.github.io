package codechef;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class COINS {
    private static final Map<Integer, Long> dp = new HashMap<>();

    public static long exchange(int n) {
        if (n < 12) {
            return n;
        } else if (n == 12) {
            return 13;
        } else if (dp.containsKey(n)) {
            return dp.get(n);
        }
        dp.put(n, Math.max(n, exchange(n / 2) + exchange(n / 3) + exchange(n / 4)));
        return dp.get(n);
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner stdin = new Scanner(System.in);
        while (stdin.hasNextLine()) {
            int n = Integer.parseInt(stdin.nextLine());
            System.out.println(exchange(n));
        }
    }
}
