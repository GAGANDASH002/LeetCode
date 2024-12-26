class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];      

            // Remove pre existing smaller elements from deque
            while(!deque.isEmpty() && deque.getLast() < num){
                deque.pollLast();
            }
            // Add the element
            deque.addLast(num);

            // Check if the first element of deque is out of the window size
            if( i >= k && nums[i-k] == deque.getFirst()){
                deque.pollFirst();
            }

            // Add the maximum element of each window into the result
            if(i >= k - 1){
                res.add(deque.getFirst());
            }
        }
        
        return res.stream().mapToInt(i -> i).toArray();   
    }
}