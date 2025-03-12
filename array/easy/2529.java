class Solution {
    public int maximumCount(int[] nums) {
        int negativeCount = 0;
        int positiveCount = 0;

        for (int num : nums) {
            negativeCount += (num < 0) ? 1 : 0;
            positiveCount += (num > 0) ? 1 : 0; 
        }
        
        return Math.max(negativeCount, positiveCount);
    }
}
