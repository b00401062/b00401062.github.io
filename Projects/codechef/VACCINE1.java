package codechef;

import java.util.*;
import java.lang.*;
import java.io.*;

class VACCINE1 {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int D1 = sc.nextInt();
        int v1 = sc.nextInt();
        int D2 = sc.nextInt();
        int v2 = sc.nextInt();
        int p = sc.nextInt();
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
