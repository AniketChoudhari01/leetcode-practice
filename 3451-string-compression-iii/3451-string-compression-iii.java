class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        word+='$';

        for (int i = 1; i < word.length(); i++) {
            if (cnt<9 && word.charAt(i) == word.charAt(i - 1)) {
                cnt++;
            } else {
                sb.append(cnt).append(word.charAt(i - 1));
                cnt = 1;
            }
        }

        return sb.toString();
    }
}