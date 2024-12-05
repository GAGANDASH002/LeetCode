/* Let's see one by one.

Input: nums = [2,3,1,1,4]

near = 0
far = 0
jumps = 0
First of all, the range betwee near and far is 0, so we check only index 0. The farthest position should be

farthest position = current index + maximum jump
= 0 + 2
= 2
We check all positions in the range.

Next, before we move to the next range, we should update near, far and jumps.

This question guarantee that we can definitely reach the last index, so at least, we must move forward from the current range, so

The next near position should be

far + 1
Because far position is the most right position of current range.

The next far position should be

far = current farthest we found = 2
Of course, add +1 to jump times

jumps += 1
In the end,

   n f
[2,3,1,1,4]

jumps = 1
Next we check between index 1 and index 2.

From index 1, the farthest position should

farthest = 1 + 3 = 4
From index 2, the farthest position should

farthest = 2 + 1 = 3
We take index 4. Then update near, far and jumps.

near = far + 1 = 3
far = farthest = 4
jumps = 1 + 1 = 2
In the end,

       n f
[2,3,1,1,4]

jumps = 2
We will repeat the same algorithm. And now far position is reach the last index, so we stop iteration.

return 2(= jumps)
*/
class Solution {
    public int jump(int[] nums) {
        // Initially both near and far positions are on the first index i.e zero
        int nearPos = 0 , farPos = 0, jumps = 0;
        
        // Run the loop until far position is not the same as last index
        while(farPos < nums.length - 1){
            // Initialize farthest to zero each time
            int farthest = 0;
            for(int i = nearPos; i <= farPos; i++){
                // Update farthest
                farthest = Math.max(farthest, i + nums[i]);
            }
            // Move near and far positions ahead
            nearPos = farPos + 1;
            farPos = farthest;
            jumps++;
        }
        return jumps;
    }
}