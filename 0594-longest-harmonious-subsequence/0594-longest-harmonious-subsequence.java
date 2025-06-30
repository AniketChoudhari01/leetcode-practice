class Solution {
    public int findLHS(int[] nums) {
        // int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // if (map.size() == 1) {
        //     return 0;
        // }
        // int startElem = -1;
        int maxLHS = 0;
        // System.out.println(map);
        for (int key: map.keySet()) {
            // int key = pair.getKey();
            if (map.containsKey(key + 1)) {
                int currSeqLen = map.get(key) + map.get(key+1);
                // currSeqLen += map.getOrDefault(key + 1, 0);
                if (maxLHS < currSeqLen) {
                    maxLHS = currSeqLen;
                    // startElem = key;
                }
            }

        }
        // System.out.println(startElem);
        return maxLHS;
    }
}