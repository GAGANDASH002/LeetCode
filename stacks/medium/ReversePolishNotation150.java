/*
Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6

Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 
 */
class Solution {
    public int evalRPN(String[] tokens) {   
        Stack<Integer> stack = new Stack<>();

        for(String c: tokens){
            if(c.equals("+")){
                stack.push(stack.pop() + stack.pop());
            } else if(c.equals("-")){
                int secondInt = stack.pop();
                int firstInt = stack.pop();
                stack.push(firstInt - secondInt);
            } else if(c.equals("*")){
                stack.push(stack.pop() * stack.pop());
            } else if(c.equals("/")){
                int secondInt = stack.pop();
                int firstInt = stack.pop();
                stack.push(firstInt / secondInt);
            } else{
                stack.push(Integer.parseInt(c));
            }

        }
        return stack.pop();
    }
}