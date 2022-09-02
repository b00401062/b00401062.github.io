package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LeetCode {
    private static void insertEdge(Map<Integer, List<Integer>> edges, int v0, int v1) {
        final List<Integer> neighbors = edges.getOrDefault(v0, new ArrayList<>());
        neighbors.add(v1);
        edges.putIfAbsent(v0, neighbors);
    }

    public static int[] restoreArray(int[][] adjacentPairs) {
        final Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            insertEdge(edges, pair[0], pair[1]);
            insertEdge(edges, pair[1], pair[0]);
        }
        int head = edges.entrySet().stream()
        .filter(entry -> entry.getValue().size() == 1)
        .findFirst().get().getKey();
        int[] restoredArray = new int[adjacentPairs.length + 1];
        restoredArray[0] = head;
        for (int i = 1; i < restoredArray.length; i++) {
            List<Integer> neighbors = edges.get(restoredArray[i - 1]);
            restoredArray[i] = (
                neighbors.size() == 1 ? neighbors.get(0) :
                neighbors.get(0) ^ neighbors.get(1) ^ restoredArray[i - 2]
            );
        }
        return restoredArray;
    }
}
