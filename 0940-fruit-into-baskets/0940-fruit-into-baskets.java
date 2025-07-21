class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0, right = 0;
        int maxLen = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        while(right < n){
            int fruit = fruits[right];
            hm.put(fruit, hm.getOrDefault(fruit, 0) + 1);
            while(hm.size() > 2){
                int item = fruits[left];
                hm.put(item, hm.get(item)-1);
                if(hm.get(item) == 0){
                    hm.remove(item);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left +1);
            right++;
        }
        return maxLen;
    }
}