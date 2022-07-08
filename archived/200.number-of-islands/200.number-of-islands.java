import java.util.Set;

/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (54.02%)
 * Likes:    13877
 * Dislikes: 332
 * Total Accepted:    1.6M
 * Total Submissions: 2.9M
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and
 * '0's (water), return the number of islands.
 * 
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are
 * all surrounded by water.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [
 * ⁠ ["1","1","1","1","0"],
 * ⁠ ["1","1","0","1","0"],
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["0","0","0","0","0"]
 * ]
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["0","0","1","0","0"],
 * ⁠ ["0","0","0","1","1"]
 * ]
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 * 
 * 
 */

// @lc code=start
class Solution {
    private static int[][] DIRECTIONS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    /**
     * solution 1: dfs
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] seen = new boolean[row][col];
        int islandNum = 0;
        // start from any point of grid to search island:
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // opt: start from an island
                if (grid[i][j] == '1') {
                    islandNum += dfs(grid, i, j, seen);
                }
            }
        }

        return islandNum;
    }

    /**
     * get if this is an island, mark seen point.
     * @param grid
     * @param x
     * @param y
     * @param seen
     * @return
     */
    private int dfs(char[][] grid, int x, int y, boolean[][] seen) {
        if (x < 0 || x >= grid.length ||
        y < 0 || y >= grid[0].length ||
        grid[x][y] == '0' || seen[x][y] == true) {
                return 0;
        }

        seen[x][y] = true;
        // int res = 0;
        for (int i = 0; i < 4; i++) {
            dfs(grid, x + DIRECTIONS[i][0], y + DIRECTIONS[i][1], seen);
        }

        return 1;
    }


    
    /**
     * return number of islands with different sizes
     * @param grid
     * @return
     */
    public int numIslands(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Set<Integer> islandSizeSet = new HashSet<>();

        boolean[][] seen = new boolean[row][col];
        int islandNum = 0;
        // start from any point of grid to search island:
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // opt: start from an island
                if (grid[i][j] == 1) {
                    int islandSize = dfs(grid, i, j, seen);
                    // if this is an island, and has distinct size, islandNum + 1
                    if (islandSize > 0 && !islandSizeSet.contains(islandSize)) {
                        islandNum += 1;
                        islandSizeSet.add(islandSize);
                    }
                }
            }
        }

        return islandNum;
    }

    /**
     * get the island size
     * @param grid
     * @param x
     * @param y
     * @param seen
     * @return
     */
    private int dfs(int[][] grid, int x, int y, boolean[][] seen) {
        if (x < 0 || x >= grid.length ||
        y < 0 || y >= grid[0].length ||
        grid[x][y] == 0 || seen[x][y] == true) {
                return 0;
        }

        seen[x][y] = true;
        int size = 1;
        for (int i = 0; i < 4; i++) {
            size += dfs(grid, x + DIRECTIONS[i][0], y + DIRECTIONS[i][1], seen);
        }

        return size;
    }
}
// @lc code=end

