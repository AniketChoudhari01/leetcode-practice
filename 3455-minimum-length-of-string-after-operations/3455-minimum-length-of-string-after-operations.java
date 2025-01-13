class Solution {
    public int minimumLength(String s) {
        int freq[] = new int[26];
        int length = 0;
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (int item : freq) {
            if (item != 0) {
                if (item % 2 == 0) {
                    length += 2;
                } else {
                    length += 1;
                }
            }

        }
        return length;

    }
}