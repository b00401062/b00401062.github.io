package leetcode;

import java.util.Arrays;
import java.util.Comparator;

class LeetCode {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(boxType -> -boxType[1]));
        int deficitSize = truckSize;
        int loadedUnit = 0;
        for (int[] boxType : boxTypes) {
            if (deficitSize <= 0) break;
            int deltaSize = Math.min(boxType[0], deficitSize);
            loadedUnit += deltaSize * boxType[1];
            deficitSize -= deltaSize;
        }
        return loadedUnit;
    }
}
