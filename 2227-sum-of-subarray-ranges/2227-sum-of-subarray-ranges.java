class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int nse[] = new int[n];
        int pse[] = new int[n];
        int nge[] = new int[n];
        int pge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[i] <= nums[st.peek()]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        // System.out.println(Arrays.toString(pse));
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] < nums[st.peek()]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        // System.out.println(Arrays.toString(nse));
        st.clear();
        for(int i=0; i<n; i++){ //PGE
            while(!st.isEmpty() && nums[i] >= nums[st.peek()]){
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        // System.out.println(Arrays.toString(pge));
        st.clear();
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && nums[i] > nums[st.peek()]){
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        // System.out.println(Arrays.toString(nge));
        long res = 0;
        for(int i = 0; i<n; i++){
            //smaller
            int left1 = i-pse[i];
            int right1 = nse[i]-i;
            long cntSmallest = (long)(left1)*right1;
            //greater
            int left2 = i - pge[i];
            int right2 = nge[i] - i;
            long cntGreatest = (long)(left2)*right2;
            res += (cntGreatest - cntSmallest)*nums[i];
        }
        return res;
    }
}