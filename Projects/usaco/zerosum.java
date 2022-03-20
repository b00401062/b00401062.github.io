package usaco;

import java.io.*;
import java.util.*;

public class zerosum {
    private static int N;
    private static List<String> exprs = new ArrayList<>();
    private static int evaluate(String expr) {
        String[] tokens = expr.replaceAll(" ", "").replaceAll("([+|-])", " $1 ").split(" ");
        int sum = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            if (tokens[i].equals("+"))
                sum += Integer.parseInt(tokens[i + 1]);
            else
                sum -= Integer.parseInt(tokens[i + 1]);
        }
        return sum;
    }
    private static void recur(int n, String expr) {
        if (n > N) {
            if (evaluate(expr) == 0)
                exprs.add(expr);
            return;
        }
        for (char opr : new char[] { '+', '-', ' ' })
            recur(n + 1, expr + opr + n);
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("zerosum.in"));
        PrintWriter stdout = new PrintWriter(new File("zerosum.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        N = stdin.nextInt();
        stdin.close();
        recur(2, "1");
        Collections.sort(exprs);
        for (String expr : exprs)
            stdout.println(expr);
    }
}
