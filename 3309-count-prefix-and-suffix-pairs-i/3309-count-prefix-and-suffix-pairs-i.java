class Solution {
    private int isPrefixAndSuffix(String s1, String s2) {
        if (s2.startsWith(s1) && s2.endsWith(s1)) {
            return 1;
        }
        return 0;
    }

    public int countPrefixSuffixPairs(String[] words) {
        int totalPairs = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                totalPairs += isPrefixAndSuffix(words[i], words[j]);
            }
        }
        return totalPairs;
    }
}