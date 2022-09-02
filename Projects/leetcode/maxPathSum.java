package leetcode;

class LeetCode {
    private static class Maximum {
        int value = Integer.MIN_VALUE;

        public void compareAndSet(int value) {
            this.value = Math.max(this.value, value);
        }
    }

    private static int traverse(TreeNode root, Maximum max) {
        if (root == null) return 0;
        int maxLt = Math.max(0, traverse(root.left, max));
        int maxRt = Math.max(0, traverse(root.right, max));
        max.compareAndSet(root.val + maxLt + maxRt);
        return root.val + Math.max(maxLt, maxRt);
    }

    public static int maxPathSum(TreeNode root) {
        Maximum max = new Maximum();
        traverse(root, max);
        return max.value;
    }
}
