/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 *
 * https://leetcode.com/problems/next-greater-element-ii/description/
 *
 * algorithms
 * Medium (62.15%)
 * Likes:    4785
 * Dislikes: 139
 * Total Accepted:    228K
 * Total Submissions: 365.4K
 * Testcase Example:  '[1,2,1]'
 *
 * Given a circular integer array nums (i.e., the next element of
 * nums[nums.length - 1] is nums[0]), return the next greater number for every
 * element in nums.
 * 
 * The next greater number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, return -1 for this
 * number.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2; 
 * The number 2 can't find next greater number. 
 * The second 1's next greater number needs to search circularly, which is also
 * 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,4]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;
import java.util.Stack;

/**
 * use a monotonic stack to store the bigger element, every time find a bigger element, pop all the element in the stack, set the larger element to the element which been
 * stored
 */
class NextGreaterElements2 {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // set all default value equal to -1, so the rest value which not been set up the next greater element will be -1.
        Arrays.fill(res, -1);

        // monotonic descending stack
        Stack<Integer> numStk = new Stack<>();
        // <= 2n - 1 double cycle, check the cyclic greater element
        for (int i = 0; i <= 2 * n - 1; i++) {
            // put the element in this stack if it is the first ele or stack is empty
            if (numStk.size() == 0 || i == 0) {
                numStk.push(i);
            } else {
                int cur = nums[i % n];
                // keep monotonic descending stack
                while(numStk.size() != 0 && cur > nums[numStk.peek() % n]) {
                    int prevInd = numStk.pop() % n;
                    res[prevInd] = cur;
                }
                numStk.push(i);
            }
        }


        return res;
    }
    public static void main(String[] args) {
        int[] test = nextGreaterElements(new int[]{1,2,3,4,5});
        System.out.println(Arrays.toString(test));
    }
}


// @lc code=end

