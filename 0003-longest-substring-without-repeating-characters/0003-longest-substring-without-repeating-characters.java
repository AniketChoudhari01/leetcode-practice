class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int left = 0;
        int right = 0;
        int n = s.length();
        int maxLen = 0;
        Map<Character, Integer> hm = new HashMap<>();
        while(right < n){
            char ch = s.charAt(right);
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
            while(hm.get(ch) > 1){
                char ch2 = s.charAt(left);
                hm.put(ch2, hm.get(ch2)-1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;




























        // Map<Character, Integer> map = new HashMap<>();
        // while (right < n) {
        //     char ch = s.charAt(right);
        //     if (map.containsKey(ch)) {
        //         left = Math.max(left, map.get(ch) + 1);
        //     }
        //     maxLen = Math.max(maxLen, right - left + 1);
        //     map.put(ch, right);
        //     right++;
        // }
        // return maxLen;
    }
}