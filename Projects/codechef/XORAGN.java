package codechef;

import java.util.Arrays;
import java.util.Scanner;

class XORAGN {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner stdin = new Scanner(System.in);
        int t = Integer.parseInt(stdin.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(stdin.nextLine());
            System.out.println(
                    Arrays.stream(stdin.nextLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .map(x -> x * 2)
                            .reduce((x1, x2) -> x1 ^ x2)
                            .getAsInt()
            );
        }
    }
}
