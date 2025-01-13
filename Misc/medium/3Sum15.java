/*

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // Sort Array to obtain only unqiue triplets
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // If value of i is same as previous element then move forward to next element  
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            // Set values of j and k
            int j = i + 1;
            int k = nums.length - 1;

            // Run loop till j and k dont cross
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                // If sum > 0 then we need smaller value so decrement k
                if (sum > 0) {
                    k--;
                // If sum < 0 then we need greater value so increment j
                } else if (sum < 0) {
                    j++;
                // If sum = 0 then add triplet to result
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    // Increment and decrement j and k until a new value is reached
                    while (nums[j] == nums[j-1] && j < k) {
                        j++;
                    }
                    
                    while (nums[k] == nums[k-1] && j < k) {
                        k--;
                    }
                }
            }
        }
        return res;        
    }
}