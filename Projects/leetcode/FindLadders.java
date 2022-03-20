package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

class FindLadders {
    private static enum Color {
        WHITE,
        GRAY,
        BLACK
    }

    private static class Node {
        public final String word;
        public Color color = Color.WHITE;
        public int distance = Integer.MAX_VALUE;
        public final List<Node> neighbors = new ArrayList<>();
        public final List<Node> parents = new ArrayList<>();

        Node(String word) {
            this.word = word;
        }

        public String word() {
            return word;
        }

        public Node color(Color color) {
            this.color = color;
            return this;
        }

        public Node distance(int distance) {
            this.distance = distance;
            return this;
        }
    }

    private static int distance(String w1, String w2) {
        assert w1.length() == w2.length();
        final int n = w1.length();
        int distance = 0;
        for (int i = 0; i < n; i++) {
            if (w1.charAt(i) == w2.charAt(i)) continue;
            distance++;
        }
        return distance;
    }

    private static List<String> ladder(Stack<Node> stack) {
        List<String> ladder = new ArrayList<>();
        ladder.addAll(stack.stream().map(Node::word).collect(Collectors.toList()));
        Collections.reverse(ladder);
        return ladder;
    }

    private static void traverse(String beginWord, List<List<String>> ladders, Stack<Node> stack) {
        if (stack.peek().word == beginWord) {
            ladders.add(ladder(stack));
            return;
        }
        for (Node parent : stack.peek().parents) {
            stack.push(parent);
            traverse(beginWord, ladders, stack);
            stack.pop();
        }
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        final int n = wordList.size();
        final Node[] nodes = wordList.stream().map(Node::new).toArray(Node[]::new);
        final Node beginNode = new Node(beginWord);
        final int endNodeIdx = wordList.indexOf(endWord);
        if (endNodeIdx == -1) return new ArrayList<>();
        final Node endNode = nodes[endNodeIdx];
        for (int i = 0; i < n; i++) {
            if (distance(beginWord, wordList.get(i)) != 1) continue;
            beginNode.neighbors.add(nodes[i]);
            nodes[i].neighbors.add(beginNode);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (distance(wordList.get(i), wordList.get(j)) != 1) continue;
                nodes[i].neighbors.add(nodes[j]);
                nodes[j].neighbors.add(nodes[i]);
            }
        }
        final Queue<Node> queue = new LinkedList<>();
        queue.add(beginNode.color(Color.GRAY).distance(0));
        while (!queue.isEmpty()) {
            final Node curNode = queue.remove();
            if (curNode == endNode) break;
            for (Node neighbor : curNode.neighbors) {
                if (neighbor.color == Color.BLACK) continue;
                if (neighbor.distance < curNode.distance + 1) continue;
                neighbor.distance(curNode.distance + 1);
                neighbor.parents.add(curNode);
                if (neighbor.color == Color.GRAY) continue;
                queue.add(neighbor.color(Color.GRAY));
            }
        }
        final List<List<String>> ladders = new ArrayList<>();
        final Stack<Node> stack = new Stack<>() {{ push(endNode); }};
        traverse(beginWord, ladders, stack);
        return ladders;
    }
}
