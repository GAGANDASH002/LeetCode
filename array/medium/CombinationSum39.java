class Solution {
    private void findCombinations(int ind, int[] arr, int target, List<List<Integer>>ans, List<Integer> ds){
        // base case : if target becomes zero then a valid combination is found
        if(ind == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        // Continue recursing
        if(arr[ind] <= target){
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        // If no valid combination found for an index then choose the next index element
        findCombinations(ind + 1, arr, target, ans, ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}