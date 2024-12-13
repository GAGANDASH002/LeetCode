class Solution {
    public String decodeString(String s) {
        // Create two stacks to store the number and the character
        Stack<Integer> st = new Stack<>();
        Stack<StringBuilder> st2 = new Stack<>();
        // Intialize an integer variable and an empty string
        int num = 0;
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()){
            // if char is digit then update num
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            } else if(c == '['){ // when encountered with a '[' push sb and num into stacks and reset their values
                st.push(num);
                st2.push(sb);
                num = 0;
                sb = new StringBuilder();
            } else if(c == ']'){ // when encountered with a ']' pop from numStack,strStack and store current value of sb in temp and append temp
            // into sb k times
                int k = st.pop();
                StringBuilder temp = sb;
                sb = st2.pop();
                while(k> 0){
                    sb.append(temp);
                    k--;
                }
            } else{ // If char is a string then append to sb
                sb.append(c);
            }
        }
        return sb.toString();
    }
}