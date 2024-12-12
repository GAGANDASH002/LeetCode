/*
Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:

Input: nums = [0]
Output: [[],[0]]
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      // Add the empty subset to the result first
      res.add(new ArrayList<>());
      // Traverse ove each element in the nums array
      for(int num : nums){
        // Get the current number of subsets in the result
        int size = res.size();
        // Add the element from nums array to each pre existing subset in the result
        for(int i = 0; i < size; i++){
            // retriever the existing subset
            List<Integer> newSubset = new ArrayList<>(res.get(i));
            // Add current element into the subset
            newSubset.add(num);
            // Add the newly created subset to the result
            res.add(newSubset);
        }
      }

      return res;
    }
}