class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        //sort the array as it doesn't have any effect on our final answer
        Arrays.sort(nums);
        //now for each of the elements keep track whatever element has been used for them
        //and for each of the array elements try to use as minimum element as possible
        // Set<Integer> used = new HashSet<>();
        int maxUsedElem = nums[0]-k;//54,54,56,56 ->[54,]
        int cnt = 1;
        int n = nums.length;
        for(int i=1; i<n; i++){
            int elem = nums[i];
            // for(int range = elem-k; range<=elem+k; range++){
            //     if(!used.contains(range)){
            //         used.add(range);
            //         cnt++;
            //         break;
            //     }
            // }
            if(maxUsedElem + 1 <= (elem+k)){
                maxUsedElem = Math.max(maxUsedElem+1, elem-k);
                cnt++;
            }
        }//4,4 ,4,4 ->k=1 (3, 5)
        return cnt;
    }
}