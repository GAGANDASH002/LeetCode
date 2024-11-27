/* Quick-Select Approach:
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(0, nums.length-1, nums, k);
    }

    private int quickSelect(int left, int right, int nums[], int k){
        // Re initialize k as target according to array indexing
        int target = nums.length - k;
        // Select last element as Pivot and initialize a variable p at start of array
        int pivot =  nums[right];
        int p = left;

        for(int i = left; i < right; i++){
            // Swap if element is smaller than pivot
            if(nums[i] <= pivot){
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;
                p++;
            }
        }
        // Swap pivot Index and p
        int temp = nums[p];
        nums[p] = pivot;
        nums[right] = temp;

        // If kth largest element is still lesser than the pivot then check again on left side
        if(p > target){
            return quickSelect(left, p-1, nums, k);
        } 
        // If kth largest element is larger than pivot then only check right side
        else if (target > p){
            return quickSelect(p+1, right, nums, k);
        }
        // Base case
        else{
            return nums[p];
        }
    }
}*/

//MinHeap Approach:

class Solution{
    public int findKthLargest(int[] nums, int k){
        // Create minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1,n2) -> n1 - n2);

        // add first k elements to minHeap
        for(int i = 0; i < k; i++){
            minHeap.add(nums[i]);
        }

        // Traverse remaining elements in array
        for(int i = k; i < nums.length; i++){
            if(nums[i] > minHeap.peek()){
                // Remove smallest element from heap
                minHeap.poll();
                // add current element to heap
                minHeap.add(nums[i]);
            }
        }

        return minHeap.peek();
    }
}