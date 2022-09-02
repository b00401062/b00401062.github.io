package rosalind;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class SORT {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        List<Integer> s = Arrays.stream(stdin.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> t = Arrays.stream(stdin.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<int[]> steps = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (s.get(i).equals(t.get(i))) continue;
            int x = s.indexOf(t.get(i));
            Collections.reverse(s.subList(i, x + 1));
            steps.add(new int[] { i + 1, x + 1 });
        }
        System.out.println(steps.size());
        for (int[] step : steps)
            System.out.printf("%d %d\n", step[0], step[1]);
        stdin.close();
    }
}
