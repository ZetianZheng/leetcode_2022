import java.util.Map;

// 1852. Distinct Numbers in Each Subarray
// Given an integer array nums and an integer k, you are asked to construct the array ans of size n-k+1 where ans[i] is the number of distinct numbers in the subarray nums[i:i+k-1] = [nums[i], nums[i+1], ..., nums[i+k-1]].
// Return the array ans.


/**
 * slide window + hashmap
 * 思路：
 * 1. 区间 subarray
 * 2. 性质：区间内不重复的元素个数，可由首尾得。
 * 可知，使用双指针。
 * 不单调，所以使用hashmap记录position和答案（result array)
 * 
 * hashmap记录number - count
 * 码： 使用hashmap的size来去重，确定有多少个不同的元素。
 */
class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Map<Integer, Integer> numCnt = new HashMap<>(); // num -> count

        int start = 0, end = 0, ind = 0;

        // slide window:
        while (end < nums.length) {
            numCnt.put(nums[end], numCnt.getOrDefault(nums[end], 0) + 1);
            // break window:
            if (end - start + 1 == k) {
                // put current distinct number into answer:
                result[ind++] = numCnt.size();

                // delete the first element;
                int s = nums[start];
                numCnt.put(s, numCnt.get(s) - 1);
                if (numCnt.get(s) < 1) {
                    numCnt.remove(s);
                }
                start++;
            }
            end++;
        }

        return result;
    }
}