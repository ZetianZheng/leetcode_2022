/*
 * @lc app=leetcode id=525 lang=java
 *
 * [525] Contiguous Array
 *
 * https://leetcode.com/problems/contiguous-array/description/
 *
 * algorithms
 * Medium (46.35%)
 * Likes:    5449
 * Dislikes: 233
 * Total Accepted:    266.3K
 * Total Submissions: 572.9K
 * Testcase Example:  '[0,1]'
 *
 * Given a binary array nums, return the maximum length of a contiguous
 * subarray with an equal number of 0 and 1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number
 * of 0 and 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal
 * number of 0 and 1.
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

import java.util.HashMap;
import java.util.Map;

/**
 * 求最长，0和1相等的连续数列的长度。
 * 
 * 可以通过区间的性质得到答案：
 * 1. 通过区间内0和1的数量可以算出答案
 * 2. 通过首尾的性质可以得到答案。
 *      尾部(#1 - #0) = 首部(#1 - #0)  => 区间(#1 - #0) = 0
 * 
 * 有两点特征可以确定使用双指针（用途）：
 * 1. 区间性质
 * 2. 首尾可得
 * 
 * 双指针就记录了首和尾的性质：#1; 
 * 要把握这个性质和position的对应关系：
 * 这个对应自然就想到使用hashmap。
 * hashmap 可以记录：key: (#1 - #0) val: [index1, ind2, ...]
 * 之后每一个set里面的最大减最小就可以得到答案
 * 优化：val只记录最小和最大。
 * 
 * 所以原本区间需要的O(n^2)可以降到O(n),整个数组算一次O(n),每个区间算O(1).
 * 
 * 
 */
class Solution {
    public int findMaxLength(int[] nums) {
        // #1 and #0
        int n1 = 0;
        int n0 = 0;
        int result = 0;

        // int[]{i, j} -> i 是#1 - #0 相等index中最小的index， j是最大的index
        Map<Integer,int[]> rangeMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                n0++;
            } else {
                n1++;
            }

            int key = n1 - n0;

            // update hashmap， update max index
            int[] val = rangeMap.getOrDefault(key, new int[]{i, i});
            if (val[1] < i) {
                val[1] = i;
            }
            rangeMap.put(key, val);

            // update answer
            if (key == 0) {
                result = Math.max(i + 1, result);
            } else {
                result = Math.max(rangeMap.get(key)[1] - rangeMap.get(key)[0], result);
            }

        }

        return result;
    }

    public int findMaxLength1(int[] nums) {
        int n = nums.length;
        int result = 0;
        // rangeMap: key: diff ; val: diff最开始出现的index
        Map<Integer, Integer> rangeMap = new HashMap<>();
        rangeMap.put(0, -1);
        // 也是一个hashmap，记录到ind的#1 - #0 
        // int[] diff = new int[n + 1];
        // 在优化，使用一个count来记录到当前index的#1 - #0 
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            count = count + (nums[i] == 0 ? -1 : 1);
            
            if(!rangeMap.containsKey(count)) {
                rangeMap.put(count, i); // 放入最开始的index
            } else {
                result = Math.max(result, i - rangeMap.get(count));
            }
        }

        return result;
    }
}
// @lc code=end

