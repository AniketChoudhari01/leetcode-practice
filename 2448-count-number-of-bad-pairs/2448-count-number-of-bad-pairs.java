class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long totalPairs = (long)n*(n-1)/2;
        long goodPairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int j=0; j<n; j++){
            int diff = j - nums[j];
            goodPairs += map.getOrDefault(diff, 0);
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        System.out.println(goodPairs);

        return totalPairs - goodPairs;
    }
}