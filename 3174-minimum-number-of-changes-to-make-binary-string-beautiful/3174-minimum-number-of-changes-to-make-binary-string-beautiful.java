class Solution {
    public int minChanges(String s) {
        
        int differentChar=0;
        int n=s.length();
        for(int i=1 ; i < n ; i+=2 ){
            if(s.charAt(i)!=s.charAt(i-1)){
                differentChar++;
            }
        }
   
        return differentChar;
    }
}