class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n %2 !=0) return false;
        Stack<Integer> openBrackets = new Stack<Integer>();
        Stack<Integer> unlocked = new Stack<Integer>();
        for(int i=0; i<n ;i++){
            char ch = s.charAt(i);
            char dig = locked.charAt(i);
            if(dig == '0'){
                unlocked.push(i);
                continue;
            }
            if(ch == '('){ //locked open
                openBrackets.push(i);
                continue;
            }
            
            if(!openBrackets.isEmpty()){
                openBrackets.pop();
            }else if(!unlocked.isEmpty()){
                unlocked.pop();
            }else{
                return false;
            }
        }
        while(!openBrackets.isEmpty() && !unlocked.isEmpty() && openBrackets.peek()<unlocked.peek()){
            unlocked.pop();
            openBrackets.pop();
        }
        if(!openBrackets.isEmpty()){
            return false;
        }
        return true;
    }
}