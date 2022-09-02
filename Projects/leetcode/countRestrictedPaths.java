package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class LeetCode {
    private static class Node {
        final int id;
        final List<Edge> edges = new ArrayList<>();
        int distance = Integer.MAX_VALUE;
        int pathCount = 0;
        boolean processed = false;

        Node(int id) {
            this.id = id;
        }

        public int distance() {
            return distance;
        }

        public int pathCount() {
            return pathCount;
        }

        public boolean processed() {
            return processed;
        }

        public void insertEdge(Node node, int weight) {
            edges.add(new Edge(this, node, weight));
        }
    }

    private static class Edge {
        final Node tailNode;
        final Node headNode;
        final int weight;

        Edge(Node tailNode, Node headNode, int weight) {
            this.tailNode = tailNode;
            this.headNode = headNode;
            this.weight = weight;
        }

        public Node headNode() {
            return headNode;
        }
    }

    private static class Pair {
        final int nodeID;
        final int distance;

        Pair(int nodeID, int distance) {
            this.nodeID = nodeID;
            this.distance = distance;
        }

        public int distance() {
            return distance;
        }
    }

    private static void shortestPath(List<Node> adjList, Node beginNode, Node endNode) {
        final PriorityQueue<Pair> pairs = new PriorityQueue<>(
            adjList.size(),
            Comparator.comparingInt(Pair::distance)
        );
        beginNode.distance = 0;
        beginNode.pathCount = 1;
        pairs.add(new Pair(beginNode.id, 0));
        while (true) {
            final Pair pair = pairs.poll();
            final Node currNode = adjList.get(pair.nodeID);
            if (currNode.processed) continue;
            currNode.pathCount = (int) ((
                currNode.edges.stream().
                map(Edge::headNode).
                filter(Node::processed).
                filter(node -> node.distance < currNode.distance).
                mapToLong(Node::pathCount).
                sum() + currNode.pathCount
            ) % 1000000007);
            currNode.processed = true;
            if (endNode.processed) return;
            for (Edge edge : currNode.edges) {
                Node nextNode = edge.headNode;
                if (nextNode.processed) continue;
                int distance = currNode.distance + edge.weight;
                if (nextNode.distance <= distance) continue;
                nextNode.distance = distance;
                pairs.add(new Pair(nextNode.id, distance));
            }
        }
    }

    public static int countRestrictedPaths(int n, int[][] edges) {
        final List<Node> adjList = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            adjList.add(new Node(i));
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).insertEdge(adjList.get(edge[1]), edge[2]);
            adjList.get(edge[1]).insertEdge(adjList.get(edge[0]), edge[2]);
        }
        shortestPath(adjList, adjList.get(n), adjList.get(1));
        return adjList.get(1).pathCount;
    }
}
