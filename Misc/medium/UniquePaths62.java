/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:

Input: m = 3, n = 7
Output: 28

Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

Approach: total possible ways at a given point is the sum of possible right ways and possible ways to go down. Therefore we have to calculate the sum of R + D for each cell of the matrix and the value of the final cell will give us the answer.
 */
class Solution {
    public int uniquePaths(int m, int n) {
        // Initialize lowermost row with all 1's as the only way possible is to go right i.e 1 way
        int[] aboveRow = new int[n];
        Arrays.fill(aboveRow, 1);

        // Run a loop for remaining rows
        for(int row = 1; row < m; row++){
            // Initalize with 1's
            int[] currentRow = new int[n];
            Arrays.fill(currentRow, 1);
            // Traverse through each column of the above row
            for(int col = 1; col<n; col++){
                // Total ways = Right ways + Down Ways
                currentRow[col] = currentRow[col - 1] + aboveRow[col];
            }
            aboveRow = currentRow;
        }
        // Return final answer
        return aboveRow[n-1];
    }
}