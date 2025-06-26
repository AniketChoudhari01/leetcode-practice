class Solution {
    public int longestSubsequence(String s, int k) {
        //we can take all the 0's since it is subsequence they always contribute nothing to the value and increases the length.
        int len = 0;
        int base = 1;
        int val = 0;
        for (char ch : s.toCharArray()) {
            if (ch != '0')
                continue;
            len++;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                if (base + val <= k) {
                    val += base;
                    len++;
                }
            }
            base *= 2;
            if (base > k)
                break;
        }
        return len;
    }
}