class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) visited.add(nums[i]);
        int unique = visited.size();
        if(unique == 1) return n*(n+1)/2;
        int left = 0, right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int completeSubarrays = 0;
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
            while(left < right && map.size() == unique){
                completeSubarrays += (n - right);
                map.put(nums[left], map.get(nums[left]) -1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            right++;
        }
        return completeSubarrays;
    }
}