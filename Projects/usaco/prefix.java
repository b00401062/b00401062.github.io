package usaco;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class prefix {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("prefix.in"));
        PrintWriter stdout = new PrintWriter(new File("prefix.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        String line;
        String sequence = "";
        List<String> primitives = new ArrayList<>();
        while (!(line = stdin.nextLine().trim()).equals("."))
            primitives.addAll(Arrays.asList(line.split(" ")));
        while (stdin.hasNext())
            sequence += stdin.next();
        int seqlen = sequence.length();
        int[] counts = new int[seqlen + 1];
        Set<Integer> lengths = primitives.stream().map(String::length).collect(Collectors.toSet());
        for (int i = seqlen - 1; i >= 0; i--)
            for (int l : lengths)
                if (l <= seqlen - i && primitives.contains(sequence.substring(i, i + l)))
                    counts[i] = Math.max(counts[i], l + counts[i + l]);
        stdout.println(counts[0]);
        stdin.close();
    }
}
