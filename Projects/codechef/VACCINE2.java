package codechef;

import java.util.Arrays;
import java.util.Scanner;

class VACCINE2 {
    private static int solve(int[] ages, int d) {
        final int nRisk = (int) Arrays.stream(ages).filter(age -> age >= 80 || age <= 9).count();
        final int nNonRisk = ages.length - nRisk;
        return (nRisk == 0 ? 0 : (nRisk - 1) / d + 1) + (nNonRisk == 0 ? 0 : (nNonRisk - 1) / d + 1);
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int t = stdin.nextInt();
        while (t-- > 0) {
            int n = stdin.nextInt();
            int d = stdin.nextInt();
            int[] ages = new int[n];
            for (int i = 0; i < n; i++) {
                ages[i] = stdin.nextInt();
            }
            int day = solve(ages, d);
            System.out.println(day);
        }
        stdin.close();
    }
}
