class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();
        int nge = -1;

        for (int i = 2 * n - 1; i >= 0; i--) {
            int num = nums[i % n];
            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }
            if (i < n) {
                if (!st.isEmpty()) {
                    nge = st.peek();
                } else {
                    nge = -1;
                }
                res[i] = nge;
            }

            st.push(num);
        }

        return res;
    }
}