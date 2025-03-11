class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int n1 = word1.length(), n2 = word2.length();
        int i = 0, j = 0;
        boolean flag = true;
        while (i < n1 && j < n2) {
            if (flag) {
                sb.append(word1.charAt(i++));
                flag = false;
            } else {
                sb.append(word2.charAt(j++));
                flag = true;
            }
        }
        while (i < n1) {
            sb.append(word1.charAt(i++));
        }
        while (j < n2) {
            sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }
}