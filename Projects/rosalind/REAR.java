package rosalind;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class REAR {
    private static int reversal(List<Integer> s, List<Integer> t) {
        final int n = s.size();
        final Map<List<Integer>, Integer> distance = new HashMap<List<Integer>, Integer>() {{ put(s, 0); }};
        final Queue<List<Integer>> queue = new LinkedList<List<Integer>>() {{ add(s); }};
        while (queue.size() > 0 && !distance.containsKey(t)) {
            List<Integer> u = new ArrayList<>(queue.remove());
            int d = distance.get(u);
            for (int i = 0; i < n; i++)
                for (int j = i+2; j <= n; j++) {
                    Collections.reverse(u.subList(i, j));
                    List<Integer> v = new ArrayList<>(u);
                    Collections.reverse(u.subList(i, j));
                    if (distance.containsKey(v)) continue;
                    distance.put(v, d+1);
                    queue.add(v);
                    if (v.equals(t)) return distance.get(t);
                }
        }
        return distance.get(t);
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        do {
            List<Integer> s = Arrays.stream(stdin.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> t = Arrays.stream(stdin.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            System.out.println(reversal(s, t));
        } while (stdin.hasNext() && stdin.nextLine().equals(""));
        stdin.close();
    }
}
