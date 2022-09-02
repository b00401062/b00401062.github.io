package usaco;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class fracdec {
    private static class Tuple {
        int order;
        int quotient;
        Tuple(int order, int quotient) {
            this.order = order;
            this.quotient = quotient;
        }
        int getOrder() { return order; }
        int getQuotient() { return quotient; }
    }
    public static void main(String[] args) throws IOException {
        final Scanner stdin = new Scanner(new File("fracdec.in"));
        final PrintWriter stdout = new PrintWriter(new File("fracdec.out"));
        final StringBuffer quotient = new StringBuffer();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            for (int i = 0; i < quotient.length() - 76; i += 76)
                stdout.println(quotient.substring(i, i + 76));
            stdout.println(quotient.substring(quotient.length() / 76 * 76));
            stdout.flush();
        }));
        final int numerator = stdin.nextInt();
        final int denominator = stdin.nextInt();
        quotient.append(numerator / denominator);
        quotient.append('.');
        int order = 0;
        int remainder = numerator % denominator;
        if (remainder == 0) {
            quotient.append(0);
            stdin.close();
            return;
        }
        Tuple[] records = new Tuple[denominator];
        while (remainder != 0 && records[remainder] == null) {
            records[remainder] = new Tuple(order++, remainder * 10 / denominator);
            remainder = (remainder * 10) % denominator;
        }
        Tuple[] digits = Arrays.stream(records).filter(Objects::nonNull).sorted(Comparator.comparing(Tuple::getOrder)).toArray(Tuple[]::new);
        if (remainder == 0) {
            quotient.append(Arrays.stream(digits).mapToInt(Tuple::getQuotient).mapToObj(Integer::toString).collect(Collectors.joining("")));
            stdin.close();
            return;
        }
        int start = records[remainder].order;
        Arrays.stream(digits).limit(start).forEach((digit) -> quotient.append(digit.getQuotient()));
        quotient.append('(');
        Arrays.stream(digits).skip(start).forEach((digit) -> quotient.append(digit.getQuotient()));
        quotient.append(')');
        stdin.close();
    }
}
