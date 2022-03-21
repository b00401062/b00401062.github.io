package codechef;

import java.util.Scanner;

class BINIM {
    private static final Integer ZERO = (int) '0';
    private static final Integer ONE = (int) '1';
    private static final String[] PLAYERS = new String[]{"Dee", "Dum"};

    public static void main(String[] args) throws java.lang.Exception {
        Scanner stdin = new Scanner(System.in);
        int T = stdin.nextInt();
        while (T-- > 0) {
            int N = stdin.nextInt();
            int turn = stdin.next().equals("Dum") ? 1 : 0;
            int[] counts = new int[2];
            while (N-- > 0) {
                String stack = stdin.next();
                Integer who = stack.charAt(0) == '1' ? ONE : ZERO;
                counts[stack.charAt(0) - '0'] += stack.chars().filter(who::equals).count();
            }
            System.out.println(counts[turn] > counts[1 - turn] ? PLAYERS[turn] : PLAYERS[1 - turn]);
        }
        stdin.close();
    }
}
