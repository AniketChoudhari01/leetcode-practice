class Solution {
    public void rotate(int[][] matrix) {
        //90 deg = transponse + reverse row
        //180 deg = rev row + rev col
        //270 deg = transponse + rev col
        int n = matrix.length;
        int idx = 0;
        while (idx < n) {
            //idx,idx
            for (int i = idx; i < n; i++) {
                int temp = matrix[i][idx];
                matrix[i][idx] = matrix[idx][i];
                matrix[idx][i] = temp;
            }
            idx++;
        }
        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = n-1;
            while(l < r){
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}