class Solution {
    public int possibleStringCount(String word) {
        int ans = 0;
        char prev = word.charAt(0);
        // int cnt = 1;
        for(int i=1; i<word.length(); i++){
            char curr = word.charAt(i);
            if(prev == curr){
                ans++;
            }else{
                // ans += cnt - 1;
                // cnt = 1;
                prev = curr;
            }
        }  
        // ans += cnt - 1;     
        return ans+1;
    }
}