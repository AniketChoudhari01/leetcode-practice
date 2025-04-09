class Solution {
    public int minOperations(int[] nums, int k) {
        //all values ge than are identical 
        //2nd ge
        //nums[i] > h ? nums[i]=h
        //min ops to make every elem in array equal to k
        //7,7,5,3 5,5,5,3 3,3,3,3 1,1,1,1
        boolean present[] = new boolean[101];
        int cnt = 0;
        // boolean isPresentK = false;
        for (int item : nums) {
            if (item < k) return -1;
            if (item == k) continue;
            if (!present[item]) {
                present[item] = true;
                cnt++;
            }
        }
        return cnt;
    }
}