

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int limit = n / 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > limit) {
                res.add(entry.getKey());
            }
        }

        return res;
    }
}
