class Solution {
    public String removeOccurrences(String s, String part) {
        if (s.length() < part.length()) {
            return s;
        }
        Stack<Character> st = new Stack<>();
        int n = s.length();
        char lastPart = part.charAt(part.length() - 1);
        int partLen = part.length();
        for (char ch : s.toCharArray()) {
            st.push(ch);
            if (ch == lastPart && st.size() >= partLen) {
                boolean isValid = true;
                for (int i = 0; i < partLen; i++) {
                    if (st.get(st.size() - i - 1) != part.charAt(partLen - i - 1)) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    for (int i = 0; i < partLen; i++) {
                        st.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}