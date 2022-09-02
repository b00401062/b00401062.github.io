package leetcode;

import java.util.Stack;

class LeetCode {
    private static class Bar {
        final int i;
        final int height;

        Bar(int i, int height) {
            this.i = i;
            this.height = height;
        }
    }

    public static int insert(Stack<Bar> stack, int i, int height, int maxArea) {
        int startIndex = i;
        while (stack.peek().height >= height) {
            Bar bar = stack.pop();
            startIndex = bar.i;
            maxArea = Math.max(maxArea, bar.height * (i - startIndex));
        }
        stack.push(new Bar(startIndex, height));
        return maxArea;
    }

    public static int largestRectangleArea(int[] heights) {
        final Stack<Bar> stack = new Stack<>();
        stack.push(new Bar(-1, -1));
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = insert(stack, i, heights[i], maxArea);
        }
        maxArea = insert(stack, heights.length, 0, maxArea);
        return maxArea;
    }
}
