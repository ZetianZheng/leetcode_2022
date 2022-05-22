/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (60.69%)
 * Likes:    9195
 * Dislikes: 245
 * Total Accepted:    1.7M
 * Total Submissions: 2.8M
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 * 
 * 
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 
 * 
 * 
 * Follow up: Could you minimize the total number of operations done?
 */

// @lc code=start
/**
 * two pointer, fast and slow,
 * <p> remove all pointer which be 0, then fill the rest of array with 0.
 * <p> O(n), need two loop, one to copy non-0 value to 0 value, 
 * second loop to fill the rest array</p>
 * @param nums
 */
class Solution {
    public static void moveZeroes(int[] nums) {
        int ind = removeElements(nums, 0);
        while (ind < nums.length) {
            nums[ind++] = 0;
        }
    }

    public static int removeElements(int[] nums, int target) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            // fast pointer look forward until found the target.
            if (nums[fast] != target) {
                nums[slow] = nums[fast];
                slow++;
            } 
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }
}
// @lc code=end

