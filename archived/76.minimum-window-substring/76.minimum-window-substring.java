import java.util.Map;

/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (39.05%)
 * Likes:    10895
 * Dislikes: 545
 * Total Accepted:    786.7K
 * Total Submissions: 2M
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given two strings s and t of lengths m and n respectively, return the
 * minimum window substring of s such that every character in t (including
 * duplicates) is included in the window. If there is no such substring, return
 * the empty string "".
 * 
 * The testcases will be generated such that the answer is unique.
 * 
 * A substring is a contiguous sequence of characters within the string.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
 * from string t.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 10^5
 * s and t consist of uppercase and lowercase English letters.
 * 
 * 
 * 
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */

// @lc code=start
/**
 * 关键信息：
 * 0. string array
 * 1. 区间
 * 2. 性质：包含pattern串
 * 2.1. 尾部减首部的包含pattern串所有char。
 * 得知可以使用双指针
 * 
 * 需要用hashmap来记录性质 -> position吗 ?
 *  不需要, 因为只会增加或者减少。单调的。
 * 
 * 码问题：
 * 1. 如何判断一个子串包含所有t？
 *      使用一个hashmap记录所有t中的char以及出现次数，并记录size为required
 *      s的substring中如果出现满足次数的char，则记录formed++
 *      当formed == required的时候说明包含所有 t。
 * 2. 最后一个test没过： 注意使用equals。
 */
class Solution {
    public String minWindow(String s, String t) {
       
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
       
        // answer: 0: length, 1: left, 2: right
        int[] ans = new int[]{-1, 0, 0};

        char[] arr = s.toCharArray();
        int len = arr.length;

        // record all characters and frequence in t
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // window counts: use to compare
        Map<Character, Integer> wMap = new HashMap<>();

        // flag, used to compare if all characters meet requirement. 
        int required = tMap.size();
        int formed = 0;

        // 双指针：
        int l = 0, r = 0;

        // iterate all characters in s, 当所有pattern符合时， 缩小窗口。
        while (r < len) {
            char cur = arr[r];
            // update window count hashmap
            wMap.put(cur, wMap.getOrDefault(cur, 0) + 1);
            // 有一个character满足要求, 
            // 注意使用equals, 因为超过int位数127，java会存成Integer，== 是lazy的，object只会比较地址是否一致。所以使用equals来避免lazy比较。
            if (tMap.containsKey(cur) && wMap.get(cur).equals(tMap.get(cur))) {
                formed++;
            }

            // 所有的都符合要求，缩小窗口
            while(required == formed && l <= r) {
                char lc = arr[l];

                // update min window length
                if (ans[0] == -1 || ans[0] > r - l + 1) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                wMap.put(lc, wMap.get(lc) - 1);

                // 不再满足所有条件：
                if (tMap.containsKey(lc) && wMap.get(lc).intValue() < tMap.get(lc).intValue()) {
                    formed--;
                }

                // move forward left pointer:
                l++;
            }

            // move forward right pointer:
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
// @lc code=end

