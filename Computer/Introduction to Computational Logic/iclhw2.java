import java.io.*;
import java.util.*;
import java.util.stream.*;

public class iclhw2 {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: java iclhw2 [-n] [-m]");
            return;
        }
        final int n = Integer.parseInt(args[0]);
        final int m = Integer.parseInt(args[1]);
        System.out.format("p cnf %d %d\n", n * m, n + m * n * (n-1) / 2);
        for (int i = 1; i <= n; i++) {
            final int I = i;
            IntStream constraint = IntStream.range(0, m).map(x -> x * n + I);
            System.out.format("%s 0\n", constraint.mapToObj(Integer::toString).collect(Collectors.joining(" ")));
        }
        for (int k = 1; k <= m; k++)
            for (int i = 1; i <= n; i++)
                for (int j = i+1; j <= n; j++)
                    System.out.format("-%d -%d 0\n", (k-1) * n + i, (k-1) * n + j);
    }
}
