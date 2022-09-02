package codechef;

import java.util.Scanner;

class SC31 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner stdin = new Scanner(System.in);
        int T = stdin.nextInt();
        while (T-- > 0) {
            int N = stdin.nextInt();
            int res = 0;
            while (N-- > 0) {
                res = res ^ stdin.nextInt(2);
            }
            String str = Integer.toString(res, 2);
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') count++;
            }
            System.out.println(count);
        }
    }
}
