import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (31.14%)
 * Likes:    17861
 * Dislikes: 1716
 * Total Accepted:    2M
 * Total Submissions: 6.3M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * 
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 * Input: nums = []
 * Output: []
 * Example 3:
 * Input: nums = [0]
 * Output: []
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 * 
 * 
 */

// @lc code=start
/**
 * solution 2: use two pointer.
 */
class SolutionThreeSum_twoPointer {
    public static int len;
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        len = nums.length;
        // sort the array
        Arrays.sort(nums);

        // the first element: start from 0 ~ len - 3, 
        // after sorted the array, if nums[i] > 0, then it cannot be added to zero 
        for (int i = 0; i < len - 2 && nums[i] <= 0; i++) {

            // i equal to 0, or current number not same as previous number(except the duplicate number)
            if (i == 0 || nums[i - 1] != nums[i]) {
                // get answer of two sum 
                twoSum(nums, i, answer);    
            }
        }

        return answer;
    }

    /**
     * use sorted + two pointer
     * @param nums
     * @param first first index 
     * @param answer 
     */
    private static void twoSum(int[] nums, int first, List<List<Integer>> answer) {
        Integer previous = nums[first];
        int left = first + 1;
        int right = len - 1;
        
        // two pointer, from start and end, count the sum equal = 0.
        while (left < right) {
            int sum = previous + nums[left] + nums[right];

            if (sum < 0) {
                // sum less than the target, move forward the left pointer
                left++;
            } else if (sum > 0) {
                // sum bigger than the target, move backward the right pointer
                right--;
            } else {
                // sum = first + second + third, move both pointers
                answer.add(Arrays.asList(previous, nums[left++], nums[right--]));

                // skip all the duplicate numbers, 
                // compare left and left - 1, becuase we moved left pointer before.
                while (left < len && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = threeSum(new int[]{-2,0,1,1,2});
        System.out.println(ans);
    }
}
// @lc code=end

