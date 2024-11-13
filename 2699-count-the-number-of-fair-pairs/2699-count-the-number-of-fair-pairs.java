class Solution {
    private int lowerBound(int nums[], int targetValue, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= targetValue) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // private int upperBound(int nums[], int targetValue, int start) {
    //     int low = start;
    //     int high = nums.length - 1;
    //     int idx = 0;
    //     while (low <= high) {
    //         int mid = (low + high) / 2;
    //         if (nums[mid] > targetValue) {
    //             high = mid - 1;
    //         } else {
    //             low = mid + 1;
    //         }
    //     }
    //     return low;
    // }

    public long countFairPairs(int[] nums, int lower, int upper) {

        int n = nums.length;
        long cntPairs = 0;
        Arrays.sort(nums);
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        //     map.put(nums[i], i);
        // }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n; i++) {
            //here (i+1) we want to search from next number till end (i!=j && i<j)
            long lowIdx = lowerBound(nums, (lower - nums[i]), i+1, n-1);
            long highIdx = lowerBound(nums, (upper + 1 - nums[i]), i+1, n-1);
            // if (highIdx<n && lowIdx>=0 && (map.get(nums[highIdx]) - map.get(nums[lowIdx]))>0) {
                long diff = highIdx - lowIdx;
                if (diff > 0) {
                    cntPairs += diff;
                }
            // }
            // System.out.println("low:" + lowIdx + " high:" + highIdx);
            /*
             * else if(lowIdx==highIdx && i!=lowIdx && i!=highIdx){
             * cntPairs++;
             * }
             */
        }
        return cntPairs;
    }
}