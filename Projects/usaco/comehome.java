package usaco;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class comehome {
    private enum Color { WHITE, GRAY, BLACK };
    private static class Edge {
        int node;
        int weight;
        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    private static class Node {
        int dist = Integer.MAX_VALUE;
        List<Edge> edges = new ArrayList<Edge>();
        Color color = Color.WHITE;
        int getDist() { return this.dist; }
    }
    public static void main(String[] args) throws IOException {
        final Scanner stdin = new Scanner(new File("comehome.in"));
        final PrintWriter stdout = new PrintWriter(new File("comehome.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        Node[] graph = new Node['z'-'A'+1];
        for (int i = 0; i < graph.length; i++)
            graph[i] = new Node();
        final int P = stdin.nextInt();
        for (int i = 0; i < P; i++) {
            int u = stdin.next().charAt(0)-'A';
            int v = stdin.next().charAt(0)-'A';
            int w = stdin.nextInt();
            graph[u].edges.add(new Edge(v, w));
            graph[v].edges.add(new Edge(u, w));
        }
        List<Node> list = new ArrayList<Node>();
        graph['Z'-'A'].dist = 0;
        graph['Z'-'A'].color = Color.GRAY;
        list.add(graph['Z'-'A']);
        while (!list.isEmpty()) {
            Node node = list.stream().min(Comparator.comparing(Node::getDist)).get();
            list.remove(node);
            node.color = Color.BLACK;
            node.edges.forEach(edge -> {
                if (graph[edge.node].color != Color.BLACK)
                    graph[edge.node].dist = Math.min(graph[edge.node].dist, node.dist + edge.weight);
                if (graph[edge.node].color == Color.WHITE) {
                    graph[edge.node].color = Color.GRAY;
                    list.add(graph[edge.node]);
                }
            });
        }
        int min = Arrays.stream(graph).limit('Z'-'A').min(Comparator.comparing(Node::getDist)).get().dist;
        int id = 'A' + IntStream.range(0, 'Z'-'A').filter(x -> graph[x].dist == min).findFirst().getAsInt();
        stdout.println(String.format("%c %d", (char) id, min));
        stdin.close();
    }
}
