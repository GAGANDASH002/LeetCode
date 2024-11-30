/*
Example 1:

Input: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
Output: true

Example 2:

Input: preorder = "1,#"
Output: false

Example 3:

Input: preorder = "9,#,#,1"
Output: false
 
 */
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        // Initialize vacancy to 1 as first node is root node only
        int vacancy = 1;
        // For each node check two conditions
        for(String node: nodes){
            // If node is equal to null node hence no vacancy created
            // decrease vacancy count
            vacancy--;
            // Failure case
            if(vacancy < 0) return false;
            // If node is a valid node then first decrease the vacancy
            // then add 2 as two more vacancies are created by a valid node
            if(!node.equals("#")){
                vacancy += 2;
            }
          
        }

        // At end true if vacancy is zero else false
        return vacancy == 0;
    }
}