/*
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]
 
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // Add all elements in nums array into a Map along with their freq
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0) + 1);
        }

        // Create a maxHeap using priorty queue
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        // add elements with higher freq into maxHeap
        for(int key: map.keySet()){
            pq.add(key);
        }

        // Add top k frequent elements into the resultant array
        int res[] = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = pq.poll();
        }
        return res;
    }
}