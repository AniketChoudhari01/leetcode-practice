class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open_st = new Stack<>();
        Stack<Integer> asterisk_st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open_st.push(i);
            }else if(ch == '*'){
                asterisk_st.push(i);
            }else{
                if(open_st.isEmpty() && asterisk_st.isEmpty()){
                    return false;
                }else if(!open_st.isEmpty()){
                    open_st.pop();
                }else{
                    asterisk_st.pop();
                }
            }
        }
        while(!open_st.isEmpty() && !asterisk_st.isEmpty()){
            if(open_st.peek() > asterisk_st.peek()){
                return false;
            }
            open_st.pop();
            asterisk_st.pop();
        }
        if(open_st.size() > asterisk_st.size()){
            return false;
        }
        return true;
        
    }
}
