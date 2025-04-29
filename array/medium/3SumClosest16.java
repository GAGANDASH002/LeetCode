class Solution {
    public int threeSumClosest(int[] nums, int target) {
       Arrays.sort(nums);

        // Initialize sum and minDifference
       int resultSum = nums[0] + nums[1] + nums[2];
       int minDifference = Integer.MAX_VALUE;

        // Fix first element and apply two pointer approach on remaining array
       for(int i = 0; i < nums.length - 2; i++){
        // Initialize two pointers on remaining array
        int j = i + 1;
        int k = nums.length - 1;

        // Traverse remaining array
        while(j < k){
            // Find each triplet sum
            int currSum = nums[i] + nums[j] + nums[k];
            if(currSum == target){
                return target;
            }
            else if(currSum < target){
                j++;
            }
            else{
                k--;
            }

            // Find difference between sum and target
            // and update the sum with the sum with min difference to target
            int diffToTarget = Math.abs(currSum - target);
            if(diffToTarget < minDifference){
                resultSum = currSum;
                minDifference = diffToTarget;
            }
        }
       }
       return resultSum;
    }
}