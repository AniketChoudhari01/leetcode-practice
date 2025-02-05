class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        int n = s1.length();
        int swaps = 0;
        int i = 0, j = 0;
        for(int k = 0; k<n; k++){
            if(s1.charAt(k) != s2.charAt(k)){
                swaps++;
                if(swaps > 2){
                    return false;
                }else if(swaps == 1){
                    i = k;
                }else{
                    j = k;
                }
            }
        }
        if(s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i)) return true;

        // int freq1[] = new int[26];
        // int freq2[] = new int[26];
        // int swaps = 0;
        // for(int i=0; i<n; i++){
        //     char ch1 = s1.charAt(i);
        //     char ch2 = s2.charAt(i);
        //     if(ch1 != ch2){
        //         swaps++;
        //     }
        //     freq1[ch1 - 'a']++;
        //     freq2[ch2 - 'a']++;
        // }
        // if(!Arrays.equals(freq1, freq2)){
        //     return false;
        // }
        // if(swaps <= 2){
        //     return true;
        // }
        return false;
    }
}