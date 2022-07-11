/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 *
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 *
 * algorithms
 * Easy (58.90%)
 * Likes:    6032
 * Dislikes: 1054
 * Total Accepted:    487.9K
 * Total Submissions: 823.8K
 * Testcase Example:  '[10,15,20]'
 *
 * You are given an integer array cost where cost[i] is the cost of i^th step
 * on a staircase. Once you pay the cost, you can either climb one or two
 * steps.
 * 
 * You can either start from the step with index 0, or the step with index 1.
 * 
 * Return the minimum cost to reach the top of the floor.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 * 
 * 
 */

// @lc code=start
class Solution {
    int[] cost;
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        this.cost = cost;
        // the top is the next element after the last element
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return cs(n);
    }

    // recursion: + TD 
    // return the minimum cost to the current pos.
    private int cs(int n) {
        // bc: if top: n < 2, can get the top with out cost
        if (n < 2) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        } else {
            dp[n] = Math.min(cs(n - 1) + cost[n - 1], cs(n - 2) + cost[n - 2]) ;

            return dp[n];
        }
    }

    // BU
    public int minCostClimbingStairs0(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2;i < dp.length;i++){
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[cost.length];
    }
}
// @lc code=end

