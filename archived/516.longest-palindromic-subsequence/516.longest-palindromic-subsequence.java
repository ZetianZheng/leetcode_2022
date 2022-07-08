import java.util.Arrays;

/*
 * @lc app=leetcode id=516 lang=java
 *
 * [516] Longest Palindromic Subsequence
 *
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 *
 * algorithms
 * Medium (59.41%)
 * Likes:    5337
 * Dislikes: 248
 * Total Accepted:    260.6K
 * Total Submissions: 437.1K
 * Testcase Example:  '"bbbab"'
 *
 * Given a string s, find the longest palindromic subsequence's length in s.
 * 
 * A subsequence is a sequence that can be derived from another sequence by
 * deleting some or no elements without changing the order of the remaining
 * elements.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s consists only of lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        // dp[i][j] -> lps for s.slice(i, j)
        int[][] dp = new int[len][len];
        // for those start < end, set as 0.
        Arrays.fill(dp, 0);

        // set the single char as a palindrome string with size 1
        for (int a = 0; a < len; a++) {
            dp[a][a] = 1;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }

    int[][] f = null;
    char[] s = null;
    int res = 0;

    private void Compute(int i, int j) {
        if (f[i][j] != -1) {
            return;
        }

        if (i == j) {
            f[i][j] = 1;
            return;
        }

        if (i + 1 == j) {
            if (s[i] == s[j]) {
                f[i][j] = 2;
            }
            else {
                f[i][j] = 1;
            }

            return;
        }

        Compute(i + 1, j);
        Compute(i, j - 1);
        Compute(i + 1, j - 1);
        f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
        if (s[i] == s[j]) {
            f[i][j] = Math.max(f[i][j], f[i + 1][j - 1] + 2);
        }
    }

    // recursion method:
    public int longestPalindromeSubseq0(String ss) {
        s = ss.toCharArray();
        int n = s.length;
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
        
        int i, j;
        f = new int[n][n];    
        for (i = 0; i < n; ++i) {
            for (j = i; j < n; ++j) {
                f[i][j] = -1;
            }
        }
        
        Compute(0, n - 1);       
        
        for (i = 0; i < n; ++i) {
            for (j = i; j < n; ++j) {
                res = Math.max(res, f[i][j]);
            }
        }
        
        return res;
    }
}
// @lc code=end

