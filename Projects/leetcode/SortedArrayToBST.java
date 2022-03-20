package leetcode;

class SortedArrayToBST {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static TreeNode construct(int[] nums, int lt, int rt) {
        final int md = (lt + rt) / 2;
        return (
            lt >= rt ? null :
            new TreeNode(
                nums[md],
                construct(nums, lt, md),
                construct(nums, md + 1, rt)
            )
        );
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length);
    }
}
