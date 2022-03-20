package leetcode;

import java.util.Stack;

class Find132pattern {
    private static class Range {
        final int min;
        final int max;

        Range(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static boolean find132pattern(int[] nums) {
        final int n = nums.length;
        final Stack<Range> stack = new Stack<>();
        stack.push(new Range(Integer.MAX_VALUE, Integer.MAX_VALUE));
        for (final int num : nums) {
            final int min = Math.min(num, stack.peek().min);
            while (stack.peek().max <= num) {
                stack.pop();
            }
            final Range range = stack.peek();
            if (num <= range.min) {
                stack.push(new Range(min, num));
            } else if (range.min < num && num < range.max) {
                return true;
            }
        }
        return false;
    }
}
