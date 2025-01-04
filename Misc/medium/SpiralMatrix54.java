/*
 * Example 1:

 Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0, right = m - 1;
        int top = 0, bottom = n - 1;

        List<Integer> res = new ArrayList<>();

        while(top <= bottom && left <= right){
        // left to right
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            top++;
        // top to bottom
            for(int i = top;  i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;
        // right to left
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
        // bottom to top
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }   
}