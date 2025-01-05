class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        // int postfixSum[] = new int[n];
        long totalShifts = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            totalShifts += shifts[i];
            // totalShifts %=26;
            // postfixSum[i] = total;
            char ch = (char)('a' + (s.charAt(i) - 'a' + totalShifts) % 26);
            sb.append(ch);
        }
        // for (int i = 0; i < n; i++) {
        //     char ch = (char)('a' + (s.charAt(i) - 'a' + postfixSum[i]) % 26);
        //     sb.append(ch);
        // }
        // System.out.println(Arrays.toString(postfixSum));
        return sb.reverse().toString();
    }
}