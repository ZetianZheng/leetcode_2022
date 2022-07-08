/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * get the max depth of every node, put that node in the same index(index == maxDepth) of the list
     */
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        maxDepth(root);
        return result;
    }

    private int maxDepth(TreeNode root) {
        // bc:
        if (root == null) {
            return 0;
        }

        // rp:
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        // current max depth: max of subtree plus 1
        int max  = Math.max(leftHeight, rightHeight) + 1;
        // postOrder: put the node into the correnspond index of list:
        if (result.size() < max) {
            result.add(new ArrayList<Integer>());
        }

        // find the index, add the value:
        result.get(max).add(root.val);
        return max;
    }
}