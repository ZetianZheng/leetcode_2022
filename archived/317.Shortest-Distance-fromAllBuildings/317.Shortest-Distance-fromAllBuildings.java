import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    private static int row;
    private static int col;
    private static final int[][] DIR = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * build a new building on the empty ground 
    * which has shortest length to all the other buildings:
    * 0: empty
    * 1: building
    * 2: obstacle
    */
    public static int shortestDistance(int[][] grid) {
        row = grid.length;
        col = grid[0].length;

        // shortest Distance
        int minDis = Integer.MAX_VALUE;

        // count all house number
        int totalHouse = 0;
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                if (grid[x][y] == 1) {
                    totalHouse += 1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // start from all empty ground:
                if (grid[i][j] == 0) {
                    minDis = Math.min(minDis, bfs(grid, i, j, totalHouse));
                }
            }
        }

        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }

    private static int bfs(int[][] grid, int x, int y, int totalHouse) {
        // visited hash set:
        boolean[][] visited = new boolean[row][col];
        
        Queue<int[]> buildingQueue = new LinkedList<>();
        
        buildingQueue.offer(new int[]{x, y});
        visited[x][y] = true;
        
        // allDistance record the answer
        int allDistance = 0;
        // steps to current position, step is the path, so begin with 0
        int steps = 0;
        // how many house been reached
        int houseReached = 0;

        // BFS:
        // queue not empty, and not reached all the house
        while (!buildingQueue.isEmpty() && houseReached != totalHouse) {
            int size = buildingQueue.size();

            // current level:
            for (int i = 0; i < size; i++) {
                int[] curr = buildingQueue.poll();

                // if this is a building, house reached + 1, update allDistance, continue to next possible pos
                if (grid[curr[0]][curr[1]] == 1) {
                    allDistance += steps;
                    houseReached += 1;
                    continue;
                }

                for (int[] p : getNextPos(grid, curr, visited)) {
                    buildingQueue.offer(p);
                }
            }

            // update level:
            steps += 1;
        }
        
        // this point cannot reach all other house, so put an obstacle here.
        if (houseReached != totalHouse) {
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (grid[r][c] == 0 && visited[r][c]) {
                        grid[r][c] = 2;
                    }
                }
            }
            return Integer.MAX_VALUE;
        }
        
        return allDistance;
    }

    private static List<int[]> getNextPos(int[][] grid, int[] cur, boolean[][] visited) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int nx = cur[0] + DIR[i][0];
            int ny = cur[1] + DIR[i][1];
            int[] np = new int[]{nx, ny};
            if (nx >= 0 && nx < row &&
                ny >= 0 && ny < col &&
                !visited[nx][ny] &&
                grid[nx][ny] != 2) {
                    list.add(np);
                    visited[nx][ny] = true;
                }
            
        }

        return list;
    }

    class Pos {
        public int x;
        public int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
 }