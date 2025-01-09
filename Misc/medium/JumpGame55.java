/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 
 */
class Solution {
    public boolean canJump(int[] nums) {
        //Initialize the max Jump that can take place from an index 
        int maxJump = 0;
        for(int i = 0; i < nums.length; i++){
            //If you cant move forward return false
            if(i > maxJump){
                return false;
            }

            // Update the max Jump u can make
            maxJump = Math.max(maxJump, i + nums[i]);

            // If the last index can be reached return true
            if(maxJump >= nums.length - 1){
                return  true;
            }
        }

        return false;
    }
}