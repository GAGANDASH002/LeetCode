/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

 */
class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        // Intialize an array to mark visited nodes
        int[][] visit = new int[rows][cols];
        int islands = 0;

        // direction array for refering adjacent nodes
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        // if a node's value = 1(land) and its not been visited yet then call bfs
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && visit[r][c] == 0) {
                    bfs(grid, r, c, visit, directions, rows, cols);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, int row, int col, int[][] visit, int[][] directions, int rows, int cols) {
        Queue<int[]> q = new LinkedList<>();
        // mark the node visited and add it to the queue
        visit[row][col] = 1;
        q.add(new int[]{row, col});

        // pop until queue is empty 
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0], c = point[1];

            // calculate adjacent nodes and if not visted mark them visited and add to queue
            for (int[] direction : directions) {
                int nr = r + direction[0], nc = c + direction[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1' && visit[nr][nc] == 0) {
                    q.add(new int[]{nr, nc});
                    visit[nr][nc] = 1;
                }
            }
        }
    }
}
