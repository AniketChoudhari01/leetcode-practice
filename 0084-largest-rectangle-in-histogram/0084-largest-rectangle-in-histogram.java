class Solution {
    class Pair{
        int idx, height;
        public Pair(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        Stack<Pair> st = new Stack<>();
        for(int i=0; i<n; i++){
            int startIdx = i;
            while(!st.isEmpty() && heights[i] <= st.peek().height){
                Pair pair = st.pop();
                startIdx = pair.idx;
                maxArea = Math.max(maxArea, (i-pair.idx)*pair.height);
            }
            st.push(new Pair(startIdx, heights[i]));
        }
        while(!st.isEmpty()){
            Pair pair = st.pop();
            maxArea = Math.max(maxArea, (n - pair.idx)*pair.height);
        }
        return maxArea;
    }
}