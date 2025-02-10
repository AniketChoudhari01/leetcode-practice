class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch<='z' && ch>='a'){
                st.push(ch);
            }else{
                if(!st.isEmpty()){
                    st.pop();
                }
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}