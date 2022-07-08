/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 *
 * https://leetcode.com/problems/unique-paths-ii/description/
 *
 * algorithms
 * Medium (37.57%)
 * Likes:    5272
 * Dislikes: 392
 * Total Accepted:    553.2K
 * Total Submissions: 1.4M
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * You are given an m x n integer array grid. There is a robot initially
 * located at the top-left corner (i.e., grid[0][0]). The robot tries to move
 * to the bottom-right corner (i.e., grid[m-1][n-1]). The robot can only move
 * either down or right at any point in time.
 * 
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that
 * the robot takes cannot include any square that is an obstacle.
 * 
 * Return the number of possible unique paths that the robot can take to reach
 * the bottom-right corner.
 * 
 * The testcases are generated so that the answer will be less than or equal to
 * 2 * 10^9.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        } else {
            dp[0][0] = 1;
        }

        for (int i = 1; i < row; i++) {
            // previous postion must be all 0, if obstacle exist, then rest must be 0.
            dp[i][0] = (dp[i - 1][0] == 1 && obstacleGrid[i][0] == 0)? 1 : 0;
        }

        for (int j = 1; j < col; j++) {
            // previous postion must be all 0, if obstacle exist, then rest must be 0.
            dp[0][j] = (dp[0][j - 1] == 1 && obstacleGrid[0][j] == 0)? 1 : 0;
        }

        for (int x = 1; x < row; x++) {
            for (int y = 1; y < col; y++) {
                if (obstacleGrid[x][y] == 1) {
                    dp[x][y] = 0;
                } else {
                    dp[x][y] = dp[x - 1][y] + dp[x][y - 1];
                }
            }
        }

        return dp[row - 1][col - 1];
    }
}
// @lc code=end

