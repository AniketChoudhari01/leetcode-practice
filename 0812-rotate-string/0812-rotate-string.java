class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        int n=s.length();
        int idx=0;
        for(int i=0; i<n; i++){
            idx=s.indexOf(goal.charAt(0), i);
            if(idx==-1){
                return false;
            }else{
                int j=0;
                i=idx;
                while(j<goal.length() && s.charAt(i)==goal.charAt(j)){
                    i=(i+1)%n;
                    j++;
                }
                if(j==goal.length()){
                    return true;
                }
            }
            i=idx;
        }
        

        return false;
    }
}