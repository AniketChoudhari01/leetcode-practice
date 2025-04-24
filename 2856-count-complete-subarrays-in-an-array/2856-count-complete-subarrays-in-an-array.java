class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(nums[i])) {
                visited.add(nums[i]);
            }
        }
        int unique = visited.size();
        //if condition satified then all the element next in the array will also form subarray
        int left = 0;
        Set<Integer> tempSet;
        int completeSubarrays = 0;
        while (left < n) {
            //expand till satisfy condn
            int right = left;
            tempSet = new HashSet<>();
            while (right < n && tempSet.size() < unique) {
                tempSet.add(nums[right]);
                right++;
            }
            if (tempSet.size() == unique) {
                completeSubarrays += (n - right + 1);
                // System.out.println(left+" "+right);
            }
            left++;
        }
        return completeSubarrays;
    }
}