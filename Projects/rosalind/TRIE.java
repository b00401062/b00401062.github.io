package rosalind;

import java.io.*;
import java.util.*;

public class TRIE {
    private static class Edge {
        int s, t; char c;
        Edge(int s, int t, char c) {
            this.s = s;
            this.t = t;
            this.c = c;
        }
    }
    private static class Node {
        Node[] c = new Node[4];
        void add(String s) {
            if (s.length() == 0) return;
            int i = "ACGT".indexOf(s.charAt(0));
            if (c[i] == null)
                c[i] = new Node();
            c[i].add(s.substring(1));
        }
        List<Edge> edges() {
            Queue<Node> q = new LinkedList<>();
            List<Edge> e = new ArrayList<>();
            int head = 0, tail = 0;
            q.add(this);
            tail++;
            do {
                Node n = q.remove();
                for (int i = 0; i < 4; i++)
                    if (n.c[i] != null) {
                        q.add(n.c[i]);
                        tail++;
                        e.add(new Edge(head + 1, tail, "ACGT".charAt(i)));
                    }
            } while (++head < tail);
            return e;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        Node root = new Node();
        while (stdin.hasNextLine())
            root.add(stdin.nextLine());
        for (Edge e : root.edges())
            System.out.printf("%d %d %c\n", e.s, e.t, e.c);
        stdin.close();
    }
}
