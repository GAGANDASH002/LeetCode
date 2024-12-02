/*
Example 1:

Input: n = 3
Output: 5

Example 2:

Input: n = 1
Output: 1
 */

class Solution {
    public int numTrees(int n) {
        // Intialize an array and mark all values upto n as 1
        int numTree[] = new int [n+1];
        for(int i = 0; i<=n; i++){
            numTree[i] = 1;
        }

        // for 0 nodes :  1 tree possible
        // for 1 node : 1 tree possible
        // hence Start loop from 2 nodes 
        for(int nodes = 2; nodes<=n; nodes++){
            // Intialize total trees possible as zero
            int total = 0;
            // Calculate total unique left subtrees and right subtrees
            // To find all possible combinations multiply both
            for(int root = 1; root<=nodes; root++){
                total+= numTree[root-1] * numTree[nodes - root];
            }
            // Set number of possible BSTs for particular n to its calc. total
            numTree[nodes] = total;
        }

        // return answer
        return numTree[n];
    }
}