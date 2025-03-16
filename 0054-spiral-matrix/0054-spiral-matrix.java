class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ansList = new ArrayList<>();
        int m = mat.length;
        int n = mat[0].length;
        int top = 0, left = 0, right = n - 1, bottom = m - 1;
        while (top <= bottom && left <= right) {
            // right traversal
            for (int i = left; i <= right; i++) {
                ansList.add(mat[top][i]);
            }
            top++;
            // right most column
            for (int i = top; i <= bottom; i++) {
                ansList.add(mat[i][right]);
            }
            right--;
            // bottom row
            if (top <= bottom) { // Imagine where there is only single row
                for (int i = right; i >= left; i--) {
                    ansList.add(mat[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                // first column
                for (int i = bottom; i >= top; i--) {
                    ansList.add(mat[i][left]);
                }
                left++;
            }

        }
        return ansList;
    }
}