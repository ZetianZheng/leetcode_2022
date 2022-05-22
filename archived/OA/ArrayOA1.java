import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    static int removeDuplicates(int[] nums) {
        // two pointer:
        int slow = 0, fast = 0;
        int len = nums.length;
        while (fast < len) {
            if (fast == 0 || nums[fast] == nums[fast - 1]) {
                fast++;
            } else {
                slow++;
                nums[slow] = nums[fast];
                fast++;
            }
        }

        System.out.print(Arrays.toString(nums));
        return slow + 1;
    }

    static int searchInsert(int[] nums, int target) {
        //binary seach
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } 
            
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;    
            }     
        }

        if (nums[left] >= target) {
            return left;
        }

        if (nums[right] < target){
            return right + 1;
        }

        return right;
      }

      static int maxSubArray(int[] nums) {
        // presum
        int len = nums.length;
        int[] presum = new int[len + 1];
        presum[0] = 0;
        for (int i = 1; i <= len; i++) {
          presum[i] = nums[i - 1] + presum[i - 1];
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < presum.length; i++) {
          for (int j = i + 1; j <= presum.length; j++) {
            max = Math.max(max, presum[j] - presum[i]);
          }
        }
        
        return max;
  
      }
    public static void main(String[] args) {
        // int[] re = twoSum(new int[]{3, 2, 4, 5}, 6);
        // int re = removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
        int re1 = searchInsert(new int[]{1,3,5,6}, 7);
        // int re2 = maxSubArray(new int[]{4,-1,2,1,6});

        System.out.println(re1);
    }
}
// @lc code=end

