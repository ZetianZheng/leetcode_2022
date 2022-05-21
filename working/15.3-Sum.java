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
class SolutionThreeSum {
    public static int len;
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        len = nums.length;
        // sort the array
        Arrays.sort(nums);

        // the first element: start from 0 ~ len - 3, after sorted the array, 
        // if nums[i] > 0, then it cannot be added to zero 
        for (int i = 0; i < len - 2 && nums[i] <= 0; i++) {

            // i equal to 0, or current number not same as previous number(except the duplicate number)
            if (i == 0 || nums[i - 1] != nums[i]) {
                // get answer of two sum 
                twoSum(nums, i, answer);    
            }
        }

        // check duplicate:

        return answer;
    }

    private static void twoSum(int[] nums, int first, List<List<Integer>> answer) {
        Set<Integer> seen = new HashSet<>();
        Integer previous = nums[first];
        
        for (int i = first + 1; i < len; i++) {
            Integer second = nums[i];
            Integer third = - previous - second;
            // first + second + third = 0
            if (seen.contains(third)){
                // add the frist triplet answer
                answer.add(
                    Stream.of(previous, second, third).collect(Collectors.toList())
                );

                // skip duplicate numbers
                while (i < len - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
             }

            seen.add(second);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = threeSum(new int[]{-2,0,1,1,2});
        System.out.println(ans);
    }
}
// @lc code=end

