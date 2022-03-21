package leetcode;

import java.util.ArrayList;
import java.util.List;

class RecoverTree {
    private static void swapVal(TreeNode n1, TreeNode n2) {
        int val = n1.val;
        n1.val = n2.val;
        n2.val = val;
    }

    public static void recoverTree(TreeNode root) {
        TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
        TreeNode curNode = root;
        boolean pairIsFound = false;
        List<TreeNode> candNodes = new ArrayList<>();
        while (curNode != null) {
            if (curNode.left == null) {
                pairIsFound = true;
            } else {
                TreeNode tmpNode = curNode.left;
                while (tmpNode.right != null && tmpNode.right != curNode) {
                    tmpNode = tmpNode.right;
                }
                if (tmpNode.right != curNode) {
                    tmpNode.right = curNode;
                    curNode = curNode.left;
                    pairIsFound = false;
                } else {
                    tmpNode.right = null;
                    pairIsFound = true;
                }
            }
            if (pairIsFound) {
                if (curNode.val < preNode.val) {
                    candNodes.add(preNode);
                    candNodes.add(curNode);
                }
                preNode = curNode;
                curNode = curNode.right;
            }
        }
        swapVal(candNodes.get(0), candNodes.get(candNodes.size() - 1));
    }
}
