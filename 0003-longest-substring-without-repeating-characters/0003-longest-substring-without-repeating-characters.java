class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int n = s.length();
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < n) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                maxLen = Math.max(maxLen, map.size());
                boolean isRepeating = false;
                right ++;
                while (right < n && ch == s.charAt(right)) {
                    isRepeating = true;
                    right++;
                }
                if(isRepeating){
                    right--;
                }else{
                    right = map.get(ch) + 1;
                }
                left = right;
                // System.out.println(left+" , "+right);
                map.clear();
                map.put(s.charAt(left), left);

            } else {
                map.put(ch, right);
            }
            right++;
            // System.out.println(map);
        }
        return Math.max(maxLen, map.size());
    }
}