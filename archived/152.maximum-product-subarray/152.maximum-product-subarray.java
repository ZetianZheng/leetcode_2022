/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (34.58%)
 * Likes:    11773
 * Dislikes: 363
 * Total Accepted:    760.2K
 * Total Submissions: 2.2M
 * Testcase Example:  '[2,3,-2,4]'
 *
 * Given an integer array nums, find a contiguous non-empty subarray within the
 * array that has the largest product, and return the product.
 * 
 * The test cases are generated so that the answer will fit in a 32-bit
 * integer.
 * 
 * A subarray is a contiguous subsequence of the array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 2 * 10^4
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * 
 */

// @lc code=start
/**
 * https://blog.csdn.net/zxzxzx0119/article/details/82986622, 见递归和td解法。
 */
class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] max_sofar = new int[len];
        int[] min_sofar = new int[len];
        max_sofar[0] = nums[0];
        min_sofar[0] = nums[0];
        int result = nums[0];
        // dp:
        for (int i = 1; i < len; i++) {
            // 有可能当前值是负，乘以之前最小值反而是最大值。
            int max = max_sofar[i - 1] * nums[i];
            int min = min_sofar[i - 1] * nums[i];
            max_sofar[i] = Math.max(max, Math.max(nums[i], min));
            min_sofar[i] = Math.min(max, Math.min(nums[i], min));
            // 保证连续：记录以本值为最后一位的累积最大乘积。
            result = Math.max(max_sofar[i], result);
        }

        return result;
        
    }

    /**
     * 滚动优化：只跟上一个值相关，所以用一个int分别记录max，min
     * @param nums
     * @return
     */
    public int maxProduct1(int[] nums) {
        int len = nums.length;
        
        int prev_max_sofar = nums[0];
        int prev_min_sofar = nums[0];
        int result = nums[0];
        // dp:
        for (int i = 1; i < len; i++) {
            // 有可能当前值是负，乘以之前最小值反而是最大值。
            int max = prev_max_sofar * nums[i];
            int min = prev_min_sofar * nums[i];
            prev_max_sofar = Math.max(max, Math.max(nums[i], min));
            prev_min_sofar = Math.min(max, Math.min(nums[i], min));
            // 保证连续：记录以本值为最后一位的累积最大乘积。
            result = Math.max(prev_max_sofar, result);
        }

        return result;
        
    }
}
// @lc code=end

