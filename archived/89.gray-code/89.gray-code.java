/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 *
 * https://leetcode.com/problems/gray-code/description/
 *
 * algorithms
 * Medium (55.33%)
 * Likes:    1470
 * Dislikes: 2269
 * Total Accepted:    234.3K
 * Total Submissions: 422.7K
 * Testcase Example:  '2'
 *
 * An n-bit gray code sequence is a sequence of 2^n integers where:
 * 
 * 
 * Every integer is in the inclusive range [0, 2^n - 1],
 * The first integer is 0,
 * An integer appears no more than once in the sequence,
 * The binary representation of every pair of adjacent integers differs by
 * exactly one bit, and
 * The binary representation of the first and last integers differs by exactly
 * one bit.
 * 
 * 
 * Given an integer n, return any valid n-bit gray code sequence.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 2
 * Output: [0,1,3,2]
 * Explanation:
 * The binary representation of [0,1,3,2] is [00,01,11,10].
 * - 00 and 01 differ by one bit
 * - 01 and 11 differ by one bit
 * - 11 and 10 differ by one bit
 * - 10 and 00 differ by one bit
 * [0,2,3,1] is also a valid gray code sequence, whose binary representation is
 * [00,10,11,01].
 * - 00 and 10 differ by one bit
 * - 10 and 11 differ by one bit
 * - 11 and 01 differ by one bit
 * - 01 and 00 differ by one bit
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1
 * Output: [0,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 16
 * 
 * 
 */

// @lc code=start
/**
 * use recursion, find the relation ship between: grayCode(n) and grayCode(n - 1);
 * 二进制数组先镜像，在前面分别加上0和1，即是下一个灰码的数组。
 * n = 1: [0,     1]   1,   0
 * n = 2: [00,   01,  11,  10]  10,  11,  01,  00
 * n = 3: [000, 001, 011, 010, 110, 111, 101, 100]
 * 所以grayCode(n) = copy(grayCode(n - 1)) + map(grayCode(n - 1),  x -> (x + 2^(n - 1))
 */
class Solution {
    /**
     * recursion,
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        // base case: n = 1, 只有0,1
        if (n == 1) {
            return new ArrayList<Integer>(){{
                add(0);
                add(1);
            }};
        }
        
        // recursion part:
        List<Integer> gcnMinusOne = grayCode(n - 1);

        // postOrder, 组合n-1的grayCode和当前的后半段的grayCode
        List<Integer> gcn = new ArrayList<>();
        
        int len = gcnMinusOne.size();
        
        gcn.addAll(gcnMinusOne);
        
        // put the last half gray code to the list
        for (int i = len - 1; i >= 0; i--) {
            gcn.add(gcnMinusOne.get(i) + (int)Math.pow(2, n - 1));
        }
        
        return gcn;
    }
}
// @lc code=end

