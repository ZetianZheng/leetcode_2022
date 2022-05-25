import java.util.Stack;

/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 *
 * https://leetcode.com/problems/max-area-of-island/description/
 *
 * algorithms
 * Medium (69.78%)
 * Likes:    6036
 * Dislikes: 149
 * Total Accepted:    475K
 * Total Submissions: 679.9K
 * Testcase Example:  '[[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]'
 *
 * You are given an m x n binary matrix grid. An island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * The area of an island is the number of cells with a value 1 in the island.
 * 
 * Return the maximum area of an island in grid. If there is no island, return
 * 0.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid =
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected
 * 4-directionally.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 * 
 * 
 */

// @lc code=start
/**
 * Solution 1: DFS
 * Recursion, id : findAreaFrom(int row, int col), Recursion part: 4-directions, base case: isValid(int row, int col) return 0.
 * 1. use a matrix visited to record if this point has been vistied or not.
 * 2. DFS each point to get the area of island
 * 3. Start from all possible points, update the maxArea
 * 
 * O(rowNum * colNum)
 */
class Solution {
    int[][] DIRECTIONS = new int[][]{{1,0}, {0, 1}, {-1,0}, {0, -1}};
    int[][] grid;
    boolean[][] visited;
    int rowNum;
    int colNum;
    
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.rowNum = grid.length;
        this.colNum = grid[0].length;
        
        this.visited = new boolean[rowNum][colNum];
        int max = 0;
        // recursion from each point, update max area:
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                max = Math.max(max, findAreaFrom(row, col));
            }
        }
        
        return max;
    }
    
    public int findAreaFrom(int row, int col){
        // base case: return 0;
        if (!isValid(row, col)) {
            return 0;
        }
        // set this point visited:
        visited[row][col] = true;
        
        int area = 1;
        for (int i = 0; i < 4; i++) {
            int newRow = row + DIRECTIONS[i][0];
            int newCol = col + DIRECTIONS[i][1];
            
            area += findAreaFrom(newRow, newCol);
        }
        
        return area;
    }
    
    /** 
     * solution 2: use Stack,
     */
    public int maxAreaOfIsland2(int[][] grid) {
        this.grid = grid;
        this.rowNum = grid.length;
        this.colNum = grid[0].length;
        
        this.visited = new boolean[rowNum][colNum];
        Stack<int[]> islandStack = new Stack<>();
        int max = 0;
        // start from each point, update max area:
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if (!isValid(row, col)) {
                    continue;
                }
                // start search from current valid point
                islandStack.push(new int[]{row, col});
                visited[row][col] = true;
                int currArea = 0;
                // use stack to get all possible point:
                while(!islandStack.isEmpty()) {
                    int[] point = islandStack.pop();
                    int x = point[0];
                    int y = point[1];
                    // after get the point(valid), currArea += 1
                    currArea += 1;
                    
                    // try 4 - direction
                    for (int i = 0; i < 4; i++) {
                        int newRow = x + DIRECTIONS[i][0];
                        int newCol = y + DIRECTIONS[i][1];
                        
                        // if the new point isValid, push this point to stack, set it as visited.
                        if (isValid(newRow, newCol)) {
                            islandStack.push(new int[]{newRow, newCol});
                            visited[newRow][newCol] = true;
                        }
                    }
                }

                max = Math.max(max, currArea);
            }
        }
        
        return max;
    }
    // ALl base cases: this point should be: on the board, not been visited, is an Island.
    public boolean isValid(int row, int col) {
        return row >= 0 && row < rowNum &&
            col >= 0 && col < colNum && 
            visited[row][col] == false && 
            grid[row][col] == 1;
    }
}
// @lc code=end

