import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (48.59%)
 * Likes:    32135
 * Dislikes: 1019
 * Total Accepted:    6.6M
 * Total Submissions: 13.6M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * Only one valid answer exists.
 * 
 * 
 * 
 * Follow-up: Can you come up with an algorithm that is less than O(n^2) time
 * complexity?
 */

// @lc code=start
class Solution {
    /** 
     * solution 2:
     * <p> HashMap to record <p>
     * 1, 2, 3, 4, 5, 6
     * <p> O(n), only looped once to create the hashmap <p> 
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        // hash map created: 
        // key: target - current index number;
        // value: index
        Map<Integer, Integer> numsMap = new HashMap<>();
        int len = nums.length;

        // loop to find curr = target - previous index number
        // curr + previous  = target
        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            if (numsMap.containsKey(curr)) {
                // find the target lets curr + previous = target.
                result[0] = numsMap.get(curr);
                result[1] = i;
                return result;
            }
            
            numsMap.put(target - nums[i], i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] re = twoSum(new int[]{3, 2, 4, 5}, 6);
        System.out.println(re);
    }
}
// @lc code=end

