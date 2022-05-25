import java.util.Arrays;

/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 *
 * https://leetcode.com/problems/rotate-array/description/
 *
 * algorithms
 * Medium (38.61%)
 * Likes:    9463
 * Dislikes: 1295
 * Total Accepted:    1.1M
 * Total Submissions: 2.9M
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation: 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^5
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * Try to come up with as many solutions as you can. There are at least three
 * different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * 
 * 
 */

// @lc code=start
/** tricky part: 
 * <p>when we rotate the array k times, 
 * k elements from the back end of the array come to the front 
 * and the rest of the elements from the front shift backwards.<p>
 * <p>we firstly reverse all the elements of the array. Then, reversing the first k elements 
 * followed by reversing the rest n-k elements gives us the required result.</p>
 * <pre>
 * Let n = 7 and k = 3.
 * Original List                   : 1 2 3 4 5 6 7
 * After reversing all numbers     : 7 6 5 4 3 2 1
 * After reversing first k numbers : 5 6 7 4 3 2 1
 * After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
 * </pre>
 * O(n), O(1)
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        // speed up the rotation
        k %= len;
        // reverse all numbers
        reverse(nums, 0, len - 1);
        // reverse first k elements;
        reverse(nums, 0, k-1);
        // reverse last k + 1 ~ len elements;
        reverse(nums, k, len - 1);
    }


    /**
     * reverse array from start to end;
     */
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // swap two elements
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
         }
    }

    /**
     * solution 2:
     * 
     * use another array, find the correct position:
     * <pre>
     * Let n = 7 and k = 3.
     * Original List: 1 2 3 4 5 6 7
     * after rotate : 5 6 7 1 2 3 4 --> Result
     * 1: 0 - 3
     * 2: 1 - 4
     * ...
     * 7: 6 - 2 ((6 + k) % 7= 2)
     * </pre>
     */
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        int[] a = new int[len];
        // put the elements of nums into correct position into a;
        for (int i = 0; i < len; i++) {
            a[(i + k)%len] = nums[i];
        }

        // copy new array to nums.
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
      }

      /** 
       * solution3 : array add implementation:
       * rotate k times, 
       * every time rotate: put last element to the first, move rest elements forward.
       * O(kn), O(1)
       * */
      public void rotate3(int[] nums, int k) {
          int len = nums.length;
          k = k % len;
          for (int i = 0; i < k; i++) {
              int last = nums[len - 1];
              for (int j = len - 1; j > 0; j--) {
                  // move forward rest elements
                  nums[j] = nums[j - 1];
              }

              nums[0] = last;
          }
      }
}
// @lc code=end

