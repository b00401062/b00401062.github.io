package leetcode;

import java.util.Stack;

class MostCompetitive {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            while (
                !stack.isEmpty() &&
                stack.peek() > num &&
                k - stack.size() < nums.length - i
            ) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(num);
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
