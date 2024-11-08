/* Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10

Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:

Input: heights = [2,4]
Output: 4
 
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        // Initialize stack and push -1 for reference
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;

        // Create a new array with an extra element zero at the end to calculate next
        // smallest element(nse)
        int[] newHeights = new int[heights.length + 1];
        System.arraycopy(heights, 0, newHeights, 0, heights.length);
        newHeights[heights.length] = 0;

        for (int i = 0; i < newHeights.length; i++) {
            // if the nse is found then calculate area
            while (stack.peek() != -1 && newHeights[i] <= newHeights[stack.peek()]) {
                int height = newHeights[stack.pop()];
                int width = i - stack.peek() - 1; // nse - pse - 1
                maxArea = Math.max(maxArea, height * width);
            }
            // and keep pushing the previous smallest elements into the stack
            stack.push(i);
        }

        return maxArea;
    }
}
