package leetcode;

class LeetCode {
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
