class Solution {
    public String minWindow(String s, String t) {
        // if(s.length() < t.length()){
        //     return "";
        // }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        HashSet<Character> set = new HashSet<>();
        int len = 0;
        int mini = Integer.MAX_VALUE;
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
            if (!set.contains(ch)) {
                set.add(ch);
                len++;
            }
        }
        int start = 0, end = 0;
        int left = 0, right = 0;
        int cnt = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
            int freq1 = sMap.get(ch);
            int freq2 = tMap.getOrDefault(ch, 0);
            if (tMap.containsKey(ch) && freq1 == freq2) {
                cnt++;
            }
            // System.out.println("left " + left + " right: " + right);
            // System.out.println("cnt :" + cnt);
            // System.out.println(sMap);
            while (cnt == len && left <= right) {
                ch = s.charAt(left);
                if (mini > right - left + 1) {
                    // System.out.println(left + " , " + right);
                    mini = right - left + 1;
                    start = left;
                    end = right;
                }
                int val = sMap.get(ch);
                sMap.put(ch, val - 1);
                if (tMap.containsKey(ch) && sMap.get(ch) < tMap.get(ch)) {
                    cnt--;
                }
                left++;
            }
            right++;
        }

        return mini == Integer.MAX_VALUE ? "" : s.substring(start, end + 1);
    }
}