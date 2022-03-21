package codechef;

import java.io.IOException;
import java.util.*;

class H1 {
    private static final List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17);
    private static final int[][] pairs = new int[][]{
            {0, 1}, {1, 2}, {3, 4}, {4, 5}, {6, 7}, {7, 8},
            {0, 3}, {1, 4}, {2, 5}, {3, 6}, {4, 7}, {5, 8}
    };
    private static final Map<String, Integer> steps = new HashMap<>();

    private static void bfs(String s) {
        steps.put(s, 0);
        Queue<String> queue = new LinkedList<String>() {{
            add(s);
        }};
        while (queue.size() > 0) {
            String u = queue.remove();
            int d = steps.get(u);
            for (int[] pair : pairs) {
                char a = u.charAt(pair[0]), b = u.charAt(pair[1]);
                if (!primes.contains(a - '0' + b - '0')) continue;
                String v = u.replace(a, '@').replace(b, a).replace('@', b);
                if (steps.containsKey(v)) continue;
                steps.put(v, d + 1);
                queue.add(v);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        final Scanner stdin = new Scanner(System.in);
        bfs("123456789");
        int t = Integer.parseInt(stdin.nextLine());
        while (t-- > 0) {
            stdin.nextLine();
            String puzzle = "";
            for (int i = 0; i < 3; i++) {
                puzzle += stdin.nextLine().replaceAll(" ", "");
            }
            System.out.println(steps.containsKey(puzzle) ? steps.get(puzzle) : new Integer(-1));
        }
    }
}
