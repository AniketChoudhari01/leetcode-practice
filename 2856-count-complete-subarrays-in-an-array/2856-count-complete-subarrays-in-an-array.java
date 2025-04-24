class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) visited.add(nums[i]);
        int unique = visited.size();
        if(unique == 1) return n*(n+1)/2;
        return countAtMostKDistinct(nums, unique) - countAtMostKDistinct(nums, unique -1);
    }

    private int countAtMostKDistinct(int nums[], int k){
        int left = 0, right = 0;
        int cnt = 0, n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(right < n){
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
            while(left < right && map.size() > k){
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            cnt += (right - left + 1);
            right++;
        }
        return cnt;
    }
}