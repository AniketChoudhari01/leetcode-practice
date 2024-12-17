class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        // Count frequencies of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        int temp = 0; // To track the next smaller character

        for (int i = freq.length - 1; i >= 0; ) {
            if (freq[i] > 0) {
                int limit = Math.min(freq[i], repeatLimit);
                sb.append(String.valueOf((char) (i + 'a')).repeat(limit));
                freq[i] -= limit;

                if (freq[i] > 0) { // Need to break the sequence
                    temp = i - 1; 
                    while (temp >= 0 && freq[temp] == 0) {
                        temp--;
                    }
                    if (temp >= 0) { // Add the next smaller character
                        sb.append((char) (temp + 'a'));
                        freq[temp]--;
                    } else {
                        break; // No more characters to break the sequence
                    }
                }
            }
            // Move to the next character
            if (freq[i] == 0) {
                i--;
            }
        }

        return sb.toString();
    }
}
