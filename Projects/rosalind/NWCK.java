package rosalind;

import java.util.*;

public class NWCK {
    private static int distance(String[] tree, int s, int t) {
        int d = 0;
        Stack<String> stack = new Stack<>() {{ push("$"); }};
        for (int i = s+1; i < t; i++) {
            switch (tree[i]) {
            case "(":
                d += 1;
                stack.push("(");
                break;
            case ")":
                switch (stack.peek()) {
                case "(":
                    d -= 1;
                    stack.pop();
                    break;
                case ",":
                    d -= 1;
                    stack.pop();
                    stack.push(")");
                    break;
                default:
                    d += 1;
                    stack.push(")");
                    break;
                }
                break;
            case ",":
                switch (stack.peek()) {
                case "(":
                case ",":
                    break;
                default:
                    d += 2;
                    stack.push(",");
                    break;
                }
            default:
                break;
            }
        }
        return d;
    }
    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        while (stdin.hasNext()) {
            String line = stdin.next();
            String[] tree = line.split("(?<=[(),;])|(?=[(),;])");
            int s = Arrays.asList(tree).indexOf(stdin.next());
            int t = Arrays.asList(tree).indexOf(stdin.next());
            System.out.println(distance(tree, Math.min(s, t), Math.max(s, t)));
        }
        stdin.close();
    }
}
