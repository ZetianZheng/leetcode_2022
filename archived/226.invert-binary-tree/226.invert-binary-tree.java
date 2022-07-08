/*
 * @lc app=leetcode id=226 lang=java
 *
 * [226] Invert Binary Tree
 *
 * https://leetcode.com/problems/invert-binary-tree/description/
 *
 * algorithms
 * Easy (71.64%)
 * Likes:    8420
 * Dislikes: 113
 * Total Accepted:    1M
 * Total Submissions: 1.5M
 * Testcase Example:  '[4,2,7,1,3,6,9]'
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = []
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * 
 * 
 */

// @lc code=start
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
/**
 * 1. 是否可以通过遍历一遍二叉树得到答案？「遍历」的思维模式。
 * 2. 是否可以定义一个递归函数，通过子问题（子树）的答案推导出原问题的答案？「分解问题」的思维模式。
 * 3. 如果单独抽出一个二叉树节点，它需要做什么事情？需要在什么时候（前/中/后序位置）做
 */
class Solution {
    /**
     * 递归得到，先翻转左右子树，再对调左右子树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        // bc：为空，返回空
        if (root == null) {
            return null;
        }
        
        // rp: 翻转左右子树
        TreeNode l = invertTree(root.left);
        TreeNode r = invertTree(root.right);

        // 后序遍历位置：调换左右子树。
        root.right = l;
        root.left = r;
        return root;
    }

    /**
     * (递归）遍历得到, 遍历每一个节点，每遍历一个节点，都翻转左右子树
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        traverseInvert(root);
        return root;
    }

    private TreeNode traverseInvert(TreeNode root) {
        if (root == null) {
            return null;
        }

        // preorder: invert current left and right tree
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // rp: traverse left and right node;
        traverseInvert(root.left);
        traverseInvert(root.right);
        return root;
    }
}
// @lc code=end

