class Solution {
    public int numberOfSubstrings(String s) {
        int freq[] = new int[3];
        int n = s.length();
        int totalSubstr = 0;
        int left = 0, right = 0;
        while (right < n) {
            char ch = s.charAt(right);
            freq[ch - 'a']++;
            while (left < right && freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                if (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                    totalSubstr += (n - right);
                }
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return totalSubstr;
    }
}