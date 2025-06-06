/*
Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9 
*/
class Solution {
    public int trap(int[] height) {
        // initialize variables to the start and end of the array
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int water = 0;

        // check for min(leftMax, rightMax)
        // water = min(leftMax, rightMax) - height[i]
        while(left < right){
            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water+= leftMax - height[left];
            } else{
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water+= rightMax - height[right];
            }
        }

        return water;
    }
}