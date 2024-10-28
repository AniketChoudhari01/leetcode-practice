class Solution {
    public int longestSquareStreak(int[] nums) {
        // boolean elementPresence[] = new boolean[100001];
        Set<Double> elementSet=new HashSet<>();
        for (int num : nums) {
            elementSet.add((double)num);
            // elementPresence[num] = true;
        }
        Arrays.sort(nums);
        int maxi = -1;
        for (int i = 0; i < nums.length-1; i++) {
            int curr = 1;
            // skip duplicates
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }

            double currNo = (double)nums[i];
            while (/* currNo<(nums.length/currNo) && elementPresence[currNo * currNo] */elementSet.contains(currNo*currNo)) {
                curr++;
                currNo = currNo * currNo;
                // System.out.println(currNo);
            }
            if (curr >= 2 && curr > maxi) {
                maxi = curr;
            }

        }
        return maxi;
    }
}