class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0, right = 0;
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        while(right < n){
            int fruit = fruits[right];
            set.add(fruit);
            hm.put(fruit, hm.getOrDefault(fruit, 0) + 1);
            if(set.size() <= 2){
                maxLen = Math.max(maxLen, right - left +1);
            }
            while(set.size() > 2){
                System.out.println(set);
                int item = fruits[left];
                hm.put(item, hm.get(item)-1);
                if(hm.get(item) <= 0){
                    set.remove(item);
                }
                left++;
            }
            right++;
        }
        return maxLen;
    }
}