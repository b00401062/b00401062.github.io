package rosalind;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class LEXF {
    public static void main(String args[]) throws IOException {
        Scanner stdin = new Scanner(System.in);
        List<String> symbols = Arrays.asList(stdin.nextLine().split(" "));
        final int n = stdin.nextInt(), N = symbols.size();
        Stack<Integer> stack = new Stack<>();
        while (true) {
            if (stack.size() < n)
                stack.push(0);
            else {
                System.out.println(stack.stream().map(symbols::get).collect(Collectors.joining()));
                try {
                    int last;
                    while ((last = stack.pop()) == N-1);
                    stack.push(last+1);
                } catch (EmptyStackException e) {
                    stdin.close();
                    return;
                }
            }
        }
    }
}
