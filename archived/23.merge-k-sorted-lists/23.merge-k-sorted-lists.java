/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (47.15%)
 * Likes:    12737
 * Dislikes: 488
 * Total Accepted:    1.3M
 * Total Submissions: 2.8M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted
 * in ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * ⁠ 1->4->5,
 * ⁠ 1->3->4,
 * ⁠ 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: lists = []
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: lists = [[]]
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 10^4.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * 跟归并排序很像，使用分而治之的思想。
 * 递归到最基础case：mergeTwoLists
 */
class Solution {
    public ListNode mergeTwoList(ListNode l, ListNode r) {
        if (l == null) {
            return r;
        }
        
        if (r == null) {
            return l;
        }
        
        ListNode h = new ListNode();
        ListNode head = h;

        while (l != null && r != null) {
            if (l.val < r.val) {
                h.next = l;
                h = h.next;
                l = l.next;
            } else {
                h.next = r;
                h = h.next;
                r = r.next;
            }
        }

        if (l != null) {
            h.next = l;
        }

        if (r != null) {
            h.next = r;
        }

        return head.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }
    
    public ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }
        
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode l = mergeKListsHelper(lists, start, mid);
        ListNode r = mergeKListsHelper(lists, mid + 1, end);
        
        return mergeTwoList(l, r);
    }

}
// @lc code=end

