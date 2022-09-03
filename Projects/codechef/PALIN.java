package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class PALIN {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String number = br.readLine();
            System.out.println(getNextPalindrome(number));
        }
    }

    private static boolean areAll9s(char[] a) {
        for (char c : a) {
            if (c != '9') return false;
        }
        return true;
    }

    private static String getNextPalindrome(String s) {
        char[] a = s.toCharArray();
        int length = a.length;
        if (areAll9s(a)) {
            String result = "1";
            for (int i = 1; i < length; i++) {
                result += "0";
            }
            result += "1";
            return result;
        }
        int mid = length / 2;
        int i = mid - 1;
        int j = (length % 2 == 0) ? mid : mid + 1;
        boolean leftSmall = false;
        while (i >= 0 && a[i] == a[j]) {
            i--;
            j++;
        }
        if (i < 0 || a[i] < a[j]) {
            leftSmall = true;
        }
        while (i >= 0) {
            a[j++] = a[i--];
        }
        if (leftSmall) {
            boolean carryForward = true;
            if (length % 2 == 1) {
                if (a[mid] == '9') {
                    carryForward = true;
                    a[mid] = '0';
                } else {
                    carryForward = false;
                    a[mid] = (char) (a[mid] + 1);
                }
            }
            i = mid - 1;
            j = (length % 2 == 0) ? mid : mid + 1;
            while (i >= 0) {
                if (carryForward) {
                    if (a[i] == '9') {
                        carryForward = true;
                        a[i] = '0';
                    } else {
                        carryForward = false;
                        a[i] = (char) (a[i] + 1);
                    }
                }
                a[j] = a[i];
                j++;
                i--;
            }
        }
        return new String(a);
    }
}
