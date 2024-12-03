/*
Example 1:  

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6

Example 2:

Input: matrix = [["0"]]
Output: 0

Example 3:

Input: matrix = [["1"]]
Output: 1
*/
class Solution {
    // Use function created for calculating Max area in a histogram

    public int largestRectangleArea(int[] heights) {
        // Initialize stack and push -1 for reference
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;

        // Create a new array with an extra element zero at the end to calculate next
        // smallest element (nse)
        int[] newHeights = new int[heights.length + 1];
        System.arraycopy(heights, 0, newHeights, 0, heights.length);
        newHeights[heights.length] = 0;

        for (int i = 0; i < newHeights.length; i++) {
            // If the nse is found, then calculate area
            while (stack.peek() != -1 && newHeights[i] <= newHeights[stack.peek()]) {
                int height = newHeights[stack.pop()];
                int width = i - stack.peek() - 1; // nse - pse - 1
                maxArea = Math.max(maxArea, height * width);
            }
            // Push current index into the stack
            stack.push(i);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0; // Handle edge case for empty matrix

        int cols = matrix[0].length;
        // Initalize a heights array for storing the value of matrix in form of a histogram
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < cols; j++) {
                // Update histogram: Increment height if '1', reset to 0 if '0'
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            // Calculate the maximal rectangle for the current row's histogram
            int area = largestRectangleArea(heights);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
