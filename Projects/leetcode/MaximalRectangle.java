package leetcode;

import java.util.Stack;

class MaximalRectangle {
    private static class Bar {
        final int i;
        final int height;

        Bar(int i, int height) {
            this.i = i;
            this.height = height;
        }
    }

    private static int insert(Stack<Bar> stack, int i, int height, int maxArea) {
        int startIndex = i;
        while (stack.peek().height >= height) {
            Bar bar = stack.pop();
            startIndex = bar.i;
            maxArea = Math.max(maxArea, bar.height * (i - startIndex));
        }
        stack.push(new Bar(startIndex, height));
        return maxArea;
    }

    private static int largestRectangleArea(int[] heights) {
        final Stack<Bar> stack = new Stack<>();
        stack.push(new Bar(-1, -1));
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = insert(stack, i, heights[i], maxArea);
        }
        maxArea = insert(stack, heights.length, 0, maxArea);
        return maxArea;
    }

    public static int maximalRectangle(char[][] matrix) {
        final int I = matrix.length;
        if (I == 0) return 0;
        final int J = matrix[0].length;
        final int[] heights = new int[J];
        int maxArea = 0;
        for (int i = 0; i < I; i++) {
            final char[] row = matrix[i];
            for (int j = 0; j < J; j++) {
                heights[j] = (row[j] == '0') ? 0 : heights[j] + 1;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
}
