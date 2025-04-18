class Solution {
    static HashMap<Integer, String> map = new HashMap<>();
    static {
        map.put(1, "1");
        map.put(2, "11");
        String str = "11";
        for (int num = 3; num< 31; num++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                int size = 1;
                char ch = str.charAt(i);
                while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                    size++;
                    i++;
                }
                sb.append(size).append(str.charAt(i));
            }
            map.put(num, sb.toString());
            str = sb.toString();
        }
    }

    public String countAndSay(int n) {
        return map.get(n);
    }
}