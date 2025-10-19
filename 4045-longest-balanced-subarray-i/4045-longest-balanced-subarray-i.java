class Solution {
    public int longestBalanced(int[] nums) {
        //map even and map odd will takw care of number of even and number of 
        //distinct odd numbers
        Map<Integer, Integer> odd = new HashMap<>();
        Map<Integer, Integer> even = new HashMap<>();
        int n = nums.length;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            odd = new HashMap<>();
            even = new HashMap<>();
            for (int j = i; j < n; j++) {
                //generate all possible subarray
                int elem = nums[j];
                if (elem % 2 == 0) {
                    even.put(elem, even.getOrDefault(elem, 0) + 1);
                } else {
                    odd.put(elem, odd.getOrDefault(elem, 0) + 1);
                }
                if (even.size() == odd.size()) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
            // int item = nums[i];
            // if (item % 2 == 0) {
            //     if (even.get(item) > 1) {
            //         even.put(item, even.get(item) - 1);
            //     } else {
            //         even.remove(item);
            //     }
            // } else {
            //     if (odd.get(item) > 1) {
            //         odd.put(item, odd.get(item) - 1);
            //     } else {
            //         odd.remove(item);
            //     }
            // }
        }
        return maxLength;
    }
}