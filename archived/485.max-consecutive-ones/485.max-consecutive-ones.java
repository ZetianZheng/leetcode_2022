/*
 * @lc app=leetcode id=485 lang=java
 *
 * [485] Max Consecutive Ones
 *
 * https://leetcode.com/problems/max-consecutive-ones/description/
 *
 * algorithms
 * Easy (55.13%)
 * Likes:    2653
 * Dislikes: 398
 * Total Accepted:    659K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,1,0,1,1,1]'
 *
 * Given a binary array nums, return the maximum number of consecutive 1's in
 * the array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive
 * 1s. The maximum number of consecutive 1s is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * nums[i] is either 0 or 1.
 * 
 * 
 */

// @lc code=start
/**
 * intuiative way: one pass, record the max count
 * O(n), O(1)
 */
class SolutionFindMax {
    public int findMaxConsecutiveOnes(int[] nums) {
        // max: to record the max count of 1s, 
        // count: record the consecutive-ones count from the latest 0.
        int max = 0, count = 0;

        // iteration
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // count reset when nums equal to 0.
                count = 0;
            } else {
                count++;
                max = Math.max(count, max);
            }
        }

        return max;
    }
}
// @lc code=end

