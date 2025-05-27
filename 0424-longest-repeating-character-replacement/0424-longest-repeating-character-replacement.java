class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == k) return k;
        int count[] = new int[26];
        int start = 0, end = 0;
        int maxCnt = 0;//keep track of most popular in window
        int maxLength = 0;//maximum size encountered so far
        int windowSize = 0;
        while(end < s.length()){
            count[s.charAt(end) - 'A']++;
            maxCnt = Math.max(maxCnt, count[s.charAt(end)-'A']);
            windowSize = end - start + 1;
            if(windowSize - maxCnt > k){
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }
}