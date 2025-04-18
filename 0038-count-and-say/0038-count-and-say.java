class Solution {
    HashMap<Integer, String> map = new HashMap<>();
    String ans_string;
    private void run_length_encoding(String str, int k, int n) {
        // System.out.println("k :"+k+" string: "+str);
        if (k == n) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {//11 k = 2, n = 3
            Stack<Character> st = new Stack<>();
            char ch = str.charAt(i);
            if (st.isEmpty()) {
                st.push(ch);//str = 21, (2)
                // i++;
            }
            while (i+1 < str.length() && st.peek() == str.charAt(i+1)) {
                st.push(str.charAt(i));
                i++;
            }
            // System.out.println("size :"+st.size()+" val: "+st.peek()+" k: "+k);
            sb.append(st.size()).append(st.peek());
        }
        ans_string = sb.toString();
        // System.out.println(ans_string);
        run_length_encoding(ans_string, k + 1, n);
    }

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        if (n == 2)
            return "11";
        ans_string = "";
        run_length_encoding("11", 2, n);
        return ans_string;
    }
}