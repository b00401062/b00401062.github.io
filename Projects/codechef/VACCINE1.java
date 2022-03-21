package codechef;

import java.util.Scanner;

class VACCINE1 {
    public static void main(String[] args) throws Exception {
        Scanner stdin = new Scanner(System.in);
        int D1 = stdin.nextInt();
        int v1 = stdin.nextInt();
        int D2 = stdin.nextInt();
        int v2 = stdin.nextInt();
        int p = stdin.nextInt();
        int countVaccine = 0;
        int count = 0;
        while (countVaccine < p) {
            if (count >= D1) {
                countVaccine += v1;
            }
            if (count >= D2) {
                countVaccine += v2;
            }
            count++;
        }
        System.out.println(count - 1);
    }
}
