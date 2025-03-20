class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> open_bracks = new Stack<>();
        int n = s.length();
        char arr[] = s.toCharArray();
        for(int i=0; i<n; i++){
            char ch = arr[i];
            if(ch == '('){
                open_bracks.push(i);
            }else if(ch == ')'){
                if(!open_bracks.isEmpty()){
                    open_bracks.pop();
                }else{
                    arr[i] = '0';
                }
            }
        }
        while(!open_bracks.isEmpty()){
            arr[open_bracks.pop()] = '0';
        }
        StringBuilder sb = new StringBuilder();
        for(char ch: arr){
            if(ch != '0'){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}