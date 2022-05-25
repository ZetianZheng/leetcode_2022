import java.util.Arrays;

/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (46.45%)
 * Likes:    5848
 * Dislikes: 250
 * Total Accepted:    802.5K
 * Total Submissions: 1.7M
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an integer array nums of length n and an integer target, find three
 * integers in nums such that the sum is closest to target.
 * 
 * Return the sum of the three integers.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -10^4 <= target <= 10^4
 * 
 * 
 */

// @lc code=start
/**
 * three pointer, one pivot to confirm the first element
 * <p> then use two sum closest to get rest two elememnts.</p>
 * <p> we are comparing the target and sum, so we need a "delta" to represent the gap between them</p>
 * <p> time: O(n^2) two loop</p>
 */
class Solution3Sum {
    public int len;
    public int threeSumClosest(int[] nums, int target) {

        len = nums.length;
        // sort array: O(nlogn), cause we want to use two pointer
        Arrays.sort(nums);

        // save the minimum delta(差值)
        int delta = Integer.MAX_VALUE;
        
        // the pivot elemt(first) from 0 ~ len - 3
        for (int i = 0; i < len - 2; i++) {
            // get two sum closest to target - nums[i]
            // current sum equals to twoSum + nums[i]
            int sum = nums[i] + twoSumClosest(nums, i, target - nums[i]);

            // update delta if the gap between sum and target is smaller
            if (Math.abs(delta) > Math.abs(target - sum)) {
                // can not abs the delta, 要保证delta的正负性。
                delta = target - sum;
            }
        }

        // return target - delta which is the closest sum.
        return target - delta;
    }

    /**
     * get two sum closest to target. use two pointer
     * @param nums
     * @param firstInd
     * @param target
     * @return
     */
    public int twoSumClosest(int[] nums, int firstInd, int target) {
        int left = firstInd + 1, right = len - 1;

        // delta
        int delta = Integer.MAX_VALUE;
        while (left < right) {
            int sum = nums[left] + nums[right];
            // update delta if the gap between sum and target is smaller
            if (Math.abs(delta) > Math.abs(target - sum)) {
                delta = target - sum;
            }
            // move pointer(TwoSum: two pointer + sorted)
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        // return the closest sum, delta + sum = target
        return target - delta;  
    }
}
// @lc code=end

