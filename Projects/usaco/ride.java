package usaco;

import java.io.*;
import java.util.*;

public class ride {
    private static int hash(String str) {
        int hash = 1;
        for (int i = 0; i < str.length(); i++)
            hash = (hash * (str.charAt(i) - 'A' + 1)) % 47;
        return hash;
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("ride.in"));
        PrintWriter stdout = new PrintWriter(new File("ride.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        String comet = stdin.next();
        String group = stdin.next();
        stdout.println(hash(comet) == hash(group) ? "GO" : "STAY");
        stdin.close();
    }
}
