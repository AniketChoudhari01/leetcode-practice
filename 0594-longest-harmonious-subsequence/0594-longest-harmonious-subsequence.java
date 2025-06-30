class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        if (map.size() == 1) {
            return 0;
        }
        int startElem = -1;
        int maxLHS = 0;
        // System.out.println(map);
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            int key = pair.getKey();
            if (map.containsKey(key + 1)) {
                int currSeqLen = map.get(key);
                currSeqLen += map.getOrDefault(key + 1, 0);
                if (maxLHS < currSeqLen) {
                    maxLHS = currSeqLen;
                    startElem = key;
                }
            }

        }
        // System.out.println(startElem);
        return maxLHS;
    }
}