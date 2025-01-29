class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n == k){
            return "0";
        }
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<n; i++){
            char ch = num.charAt(i);
            while(k>0 && !st.isEmpty() && st.peek() > ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k>0 && !st.isEmpty()){//edge cases like "22222"
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        while(sb.length()>1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}