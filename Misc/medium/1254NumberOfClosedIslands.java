class Solution {
    int m, n;

    public boolean dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n)
            return false; // touches boundary, not closed

        if (grid[r][c] == 1)
            return true; // water or already visited

        grid[r][c] = 1; // mark as visited

        boolean left = dfs(grid, r, c - 1);
        boolean right = dfs(grid, r, c + 1);
        boolean up = dfs(grid, r - 1, c);
        boolean down = dfs(grid, r + 1, c);

        return left && right && up && down;
    }

    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
