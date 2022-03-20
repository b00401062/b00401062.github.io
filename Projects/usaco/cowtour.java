package usaco;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class cowtour {
    private enum Color { WHITE, GRAY, BLACK };
    private static class Node {
        int x, y;
        double dist = Double.POSITIVE_INFINITY;
        Color color = Color.WHITE;
        List<Node> edges = new ArrayList<Node>();
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        double getDist() { return this.dist; }
        double getDist(Node that) {
            return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
        }
    }
    private static double[] dijkstra(Node[] graph, int s) {
        Arrays.stream(graph).forEach(n -> {
            n.dist = Double.POSITIVE_INFINITY;
            n.color = Color.WHITE;
        });
        List<Node> list = new ArrayList<Node>();
        graph[s].dist = 0;
        graph[s].color = Color.GRAY;
        list.add(graph[s]);
        while (!list.isEmpty()) {
            Node node = list.stream().min(Comparator.comparing(Node::getDist)).get();
            list.remove(node);
            node.color = Color.BLACK;
            node.edges.forEach(neighbor -> {
                if (neighbor.color != Color.BLACK)
                    neighbor.dist = Math.min(neighbor.dist, node.dist + node.getDist(neighbor));
                if (neighbor.color == Color.WHITE) {
                    neighbor.color = Color.GRAY;
                    list.add(neighbor);
                }
            });
        }
        return Arrays.stream(graph).mapToDouble(Node::getDist).toArray();
    }
    public static void main(String[] args) throws IOException {
        final Scanner stdin = new Scanner(new File("cowtour.in"));
        final PrintWriter stdout = new PrintWriter(new File("cowtour.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        final int N = stdin.nextInt();
        Node[] graph = new Node[N];
        for (int i = 0; i < N; i++)
            graph[i] = new Node(stdin.nextInt(), stdin.nextInt());
        for (int i = 0; i < N; i++) {
            String line = stdin.next();
            for (int j = 0; j < N; j++)
                if (line.charAt(j) == '1')
                    graph[i].edges.add(graph[j]);
        }
        double[][] table = new double[N][N];
        for (int i = 0; i < N; i++)
            table[i] = dijkstra(graph, i);
        double[] maxDists = new double[N];
        for (int i = 0; i < N; i++)
            maxDists[i] = Arrays.stream(table[i]).filter(x -> x != Double.POSITIVE_INFINITY).max().getAsDouble();
        double[] diameters = new double[N];
        for (int n = 0; n < N; n++) {
            double[] row = table[n];
            if (diameters[n] == 0) {
                int[] indices = IntStream.range(0, N).filter(x -> row[x] != Double.POSITIVE_INFINITY).toArray();
                double tmp = 0;
                for (int i : indices)
                    for (int j : indices)
                        tmp = Math.max(tmp, table[i][j]);
                final double diameter = tmp;
                Arrays.stream(indices).forEach(x -> diameters[x] = diameter);
            }
        }
        double ans = Double.POSITIVE_INFINITY;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (table[i][j] == Double.POSITIVE_INFINITY) {
                    double[] candidates = new double[] {
                            diameters[i],
                            diameters[j],
                            maxDists[i] + maxDists[j] + graph[i].getDist(graph[j])
                    };
                    ans = Math.min(ans, Arrays.stream(candidates).max().getAsDouble());
                }
            }
        }
        stdout.println(String.format("%.6f", ans));
        stdin.close();
    }
}
