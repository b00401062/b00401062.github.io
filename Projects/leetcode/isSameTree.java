package leetcode;

class LeetCode {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        return (
            p == null && q == null ? true :
            (p == null ^ q == null) || p.val != q.val ? false :
            isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
        );
    }
}
