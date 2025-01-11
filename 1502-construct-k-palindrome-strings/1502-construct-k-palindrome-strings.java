class Solution {
    public boolean canConstruct(String s, int k) {
        // If k is greater than the length of the string, it's impossible
        if (k > s.length()) {
            return false;
        }

        // Count the frequency of each character
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Count characters with odd frequencies
        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // Check if the conditions are met
        return oddCount <= k;
    }
}
