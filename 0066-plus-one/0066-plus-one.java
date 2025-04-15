class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        Stack<Integer> st = new Stack<>();
        int carry = 1;
        for(int i=n-1; i>=0; i--){
            int curr = digits[i] + carry;
            if(curr > 9){
                carry = 1;
                st.push(curr % 10);
            }else{
                carry = 0;
                st.push(curr);
            }
        }
        if(carry == 1){
            st.push(carry);
        }
        int size = st.size();
        int arr[] = new int[size];
        for(int i = 0; i<size; i++){
            arr[i] = st.pop();
        }
        return arr;
    }
}