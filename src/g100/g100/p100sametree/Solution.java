package g100.g100.p100sametree;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return (p == null && q == null)
               || (p != null && q != null && p.val == q.val && isSameTree(p.left, q.left)
                   && isSameTree(p.right, q.right));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
