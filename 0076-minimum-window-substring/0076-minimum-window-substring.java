class Solution {
    // private static boolean areEqual(int arr1[], int arr2[]){
    //     for(int i=0; i<128; i++){
    //         if(arr1[i] > arr2[i]){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int left = 0, right = 0;
        int freq1[] = new int[128];
        for(char ch: t.toCharArray()){
            freq1[(int)ch]++;
        }
        int cnt = 0; //keeps track of required element count for pattern(t) in s
        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;
        while(right < m){
            char ch = s.charAt(right);
            if(freq1[(int)ch] > 0){
                cnt++;
            }
            freq1[(int)ch]--;
            while(cnt == n){
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    startIdx = left;
                }
                char ch2 = s.charAt(left);
                freq1[(int)ch2]++;
                if(freq1[(int)ch2] > 0){
                    cnt--;
                }
                left++;
            }
            right++;
        }
        return startIdx != -1 ? s.substring(startIdx, startIdx + minLen) : ""; 
    // StringBuilder sb = new StringBuilder();
    // int freq2[] = new int[128];
    // while(right < m){//O(m)
    //     char ch = s.charAt(right);
    //     freq2[(int)ch]++;
    //     while(right - left + 1 >= n && areEqual(freq1, freq2)){ //O(m)*O(128)
    //         if(right - left +1 < minLen){
    //             minLen = right - left + 1;
    //             sb.setLength(0);
    //             sb.append(s.substring(left, right + 1));
    //         }
    //         freq2[(int)s.charAt(left)]--;
    //         left++;
    //     }
    //     right++;
    // }
    // return sb.toString();
    // //O(N^2)
}
}