class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if(k == n) return n;
        int left = 0, right = 0;
        int freq[] = new int[26];
        int maxLen = 0;
        int popularElemInwindow = 0, windowSize = 0;
        while(right < n){
            char ch = s.charAt(right);
            freq[ch-'A']++;
            popularElemInwindow = Math.max(popularElemInwindow, freq[ch-'A']);
            windowSize = right - left + 1;
            if(windowSize - popularElemInwindow > k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left +1);
            right++;
        }
        return maxLen;
    }
}