package rosalind;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class SETO {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        int n = Integer.parseInt(stdin.nextLine());
        Set<Integer> U = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toSet());
        Set<Integer> A = Arrays.stream(stdin.nextLine().substring(1).split("[^0-9]+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());
        Set<Integer> B = Arrays.stream(stdin.nextLine().substring(1).split("[^0-9]+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());
        Set<Integer> X = null;
        X = new HashSet<Integer>(A);
        X.addAll(B);
        System.out.printf("{%s}\n", X.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        X = new HashSet<Integer>(A);
        X.retainAll(B);
        System.out.printf("{%s}\n", X.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        X = new HashSet<Integer>(A);
        X.removeAll(B);
        System.out.printf("{%s}\n", X.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        X = new HashSet<Integer>(B);
        X.removeAll(A);
        System.out.printf("{%s}\n", X.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        X = new HashSet<Integer>(U);
        X.removeAll(A);
        System.out.printf("{%s}\n", X.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        X = new HashSet<Integer>(U);
        X.removeAll(B);
        System.out.printf("{%s}\n", X.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        stdin.close();
    }
}
