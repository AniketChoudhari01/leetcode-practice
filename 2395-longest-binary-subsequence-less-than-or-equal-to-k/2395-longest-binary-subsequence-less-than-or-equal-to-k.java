class Solution {
    public int longestSubsequence(String s, int k) {
        //we can take all the 0's since it is subsequence they always contribute nothing to the value and increases the length.
        int len = 0;
        // int base = 1;
        int val = 0;
        // for (char ch : s.toCharArray()) {
        //     if (ch != '0')
        //         continue;
        //     len++;
        // }
        // for (int i = s.length() - 1; i >= 0; i--) {
        //     if (s.charAt(i) == '1') {
        //         if (base + val <= k) {
        //             val += base;
        //             len++;
        //         }
        //     }
        //     base *= 2;
        //     if (base > k)
        //         break;
        // }
        int numOfBits = (int)(Math.log(k)/Math.log(2)) + 1;
        int n = s.length();
        for(int i=0; i<n; i++){
            int currBit = s.charAt(n-i-1) - '0';
            if(currBit == 1){
                if(i < numOfBits && val + (1 << i) <= k){
                    val += 1<<i;
                    len++;
                }
            }else{
                len++;
            }
        }
        return len;
    }
}