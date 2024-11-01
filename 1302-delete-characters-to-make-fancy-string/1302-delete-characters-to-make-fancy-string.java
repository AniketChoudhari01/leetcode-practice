class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        if (n < 3) {
            return s;
        }
        int i = 0;
        int j = 1;
        StringBuilder sb = new StringBuilder(s);
        for (int k = 2; k < sb.length(); k++) {
            while (k<sb.length() && sb.charAt(i) == sb.charAt(j) && sb.charAt(j) == sb.charAt(k)) {
                sb.deleteCharAt(k);
            }
            i++;
            j++;
        }

        return sb.toString();

    }
}