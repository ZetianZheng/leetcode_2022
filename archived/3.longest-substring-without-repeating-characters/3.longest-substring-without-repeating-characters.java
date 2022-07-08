import java.util.Map;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (33.08%)
 * Likes:    25810
 * Dislikes: 1122
 * Total Accepted:    3.5M
 * Total Submissions: 10.4M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not
 * a substring.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 * 
 * 
 */

// @lc code=start
/**
 * 思路：
 * 1. 需求： substring -> 代表区间; 
 * 2. without repeating, 代表区间性质, 可由首尾得。
 *  首尾可得：尾部减首部的index得到最长 nonrepeat substring
 * 所以使用双指针。
 * 
 * 由性质和position是单调的关系可知
 * 本双指针没有hashmap对应性质（longest length）和position，
 * 而是使用滑动窗口移动双指针，更新一个char count。
 * 
 * 码：
 * 如何保证nonrepeat substring?
 *  hashmap记录所有字母以及字母的index：当该字母再次出现，直接让左指针到ind的下一位即可。
 * 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if (s == null || s.isEmpty()) {
            return result;
        }
        char[] arr = s.toCharArray();

        // 记录c的最新出现index。这样在之后更新left pointer的时候就可以快速找到出现重复的字母index
        Map<Character, Integer> hm = new HashMap<>();

        // 双指针：
        for (int r = 0, l = 0; r < arr.length; r++) {
            if (hm.containsKey(arr[r])) {
                // move left pointer forward, shrink window.
                l = Math.max(l, hm.get(arr[r]) + 1);
            }

            // update hashmap, record latest char.
            hm.put(arr[r], r);

            // update result
            result = Math.max(result, r - l + 1);
        }
        
        return result;
    }
}
// @lc code=end

