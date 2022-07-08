import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=993 lang=java
 *
 * [993] Cousins in Binary Tree
 *
 * https://leetcode.com/problems/cousins-in-binary-tree/description/
 *
 * algorithms
 * Easy (53.82%)
 * Likes:    2770
 * Dislikes: 143
 * Total Accepted:    209.2K
 * Total Submissions: 388.5K
 * Testcase Example:  '[1,2,3,4]\n4\n3'
 *
 * Given the root of a binary tree with unique values and the values of two
 * different nodes of the tree x and y, return true if the nodes corresponding
 * to the values x and y in the tree are cousins, or false otherwise.
 * 
 * Two nodes of a binary tree are cousins if they have the same depth with
 * different parents.
 * 
 * Note that in a binary tree, the root node is at the depth 0, and children of
 * each depth k node are at the depth k + 1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [2, 100].
 * 1 <= Node.val <= 100
 * Each node has a unique value.
 * x != y
 * x and y are exist in the tree.
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
class Solution {
    /**
     * 使用bfs，看x和y什么时候放入队列，如果在遍历同一节点返回队列，则return false
     * 如果在同一层且放入节点时是不同父节点导入的，则return true
     * 没有在同一层，return false
     * 注意使用条件：每个节点的value是unique value
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) {
            return false;
        }
        // bfs:
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.offer(root);
        Set<Integer> nodeVals = new HashSet<>(){{
            add(x);
            add(y);
        }};
        while (!treeQueue.isEmpty()) {
            int size = treeQueue.size();
            // flag 记录这一层有几个值等于x或者y，如果有2个，那么返回true
            int flag = 0;
            for (int i = size; i > 0; i--) {
                TreeNode cur = treeQueue.poll();
                // 判断这两个distinct value是否是在同一层：
                if (nodeVals.contains(cur.val)) {
                    flag++;
                }
                // 判断是否是在同一个父节点下：是的话 false
                // 完成这个判断需要两个条件：1. 知道父节点是谁，2. 左右子树相等
                // 利用了unique value的条件，所以可以通过hashset的方式判断这两个值是否就是x和y
                if (cur.left != null && cur.right != null && 
                    nodeVals.contains(cur.left.val) && 
                    nodeVals.contains(cur.right.val)) {

                    return false;
                }
                if (cur.left != null) {
                    treeQueue.add(cur.left);
                }

            }

            if (flag > 1)
                return true;
            if (flag == 1) 
                return false;
        }

        return false;
    }
}
// @lc code=end

