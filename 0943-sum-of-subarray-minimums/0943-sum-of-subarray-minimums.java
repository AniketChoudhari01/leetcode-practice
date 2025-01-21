class Solution {
    private int[] findPSE(int pse[], int arr[]){
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i])
                st.pop();
            pse[i] = (!st.isEmpty() ? st.peek(): -1);
            st.push(i);
        }
        return pse;
    }
    private int[] findNSE(int nse[], int arr[]){
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();
            nse[i] = (!st.isEmpty()? st.peek(): arr.length);
            st.push(i);
        }
        return nse;
    }
    public int sumSubarrayMins(int[] arr) {
        int n= arr.length;
        int exp = (int)1e9 + 7;
        int res = 0;
        int nse[] = new int[n];//nxt smallest elem
        int pse[] = new int[n];//previous smallest elem
        nse = findNSE(nse, arr);
        pse = findPSE(pse, arr);

        for(int i=0; i<n; i++){
            int left = (i - pse[i]);
            int right = (nse[i] - i);
            res = (int)(res + ((long)left*right % exp)*arr[i]%exp)%exp;
        }
        return res;
    }
}