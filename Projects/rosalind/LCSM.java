package rosalind;

import java.io.*;
import java.util.*;

public class LCSM {
    private static class Node {
        String edge = "";
        Set<String> names = new HashSet<String>();
        Node[] children = new Node[4];
        Node() { }
        Node(String edge) {
            this.edge = edge;
        }
        Node(String edge, Set<String> names) {
            this.edge = edge;
            this.names = names;
        }
        public void add(String name, String seq) {
            int pos, min = Math.min(edge.length(), seq.length());
            for (pos = 0; pos < min; pos++)
                if (edge.charAt(pos) != seq.charAt(pos))
                    break;
            if (pos < edge.length()) {
                Node node = new Node(edge.substring(pos), new HashSet<String>(names));
                for (int i = 0; i < 4; i++) {
                    node.children[i] = children[i];
                    children[i] = null;
                }
                children["ACGT".indexOf(edge.charAt(pos))] = node;
                edge = edge.substring(0, pos);
            }
            if (pos < seq.length()) {
                if (children["ACGT".indexOf(seq.charAt(pos))] == null)
                    children["ACGT".indexOf(seq.charAt(pos))] = new Node(seq.substring(pos));
                children["ACGT".indexOf(seq.charAt(pos))].add(name, seq.substring(pos));
            }
            names.add(name);
        }
        public String lcs() {
            List<String> lcs = new ArrayList<>();
            lcs.add("");
            for (int i = 0; i < 4; i++)
                if (children[i] != null && children[i].names.size() == names.size())
                    lcs.add(children[i].lcs());
            return edge + lcs.stream().max(Comparator.comparingInt(String::length)).get();
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        Node root = new Node();
        String name = null, seq = null;
        while (true) {
            if (!stdin.hasNext()) {
                for (int i = 0; i < seq.length(); i++)
                    root.add(name, seq.substring(i));
                break;
            }
            String line = stdin.next();
            if (line.charAt(0) == '>') {
                if (name != null)
                    for (int i = 0; i < seq.length(); i++)
                        root.add(name, seq.substring(i));
                name = line.substring(1);
                seq = "";
            } else
                seq += line;
        }
        System.out.println(root.lcs());
        stdin.close();
    }
}
