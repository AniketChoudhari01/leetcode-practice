class Solution {
    public int projectionArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxInRow[] = new int[m];
        int maxInCol[] = new int[n];
        int area = 0;
        for(int i = 0; i<m; i++){
            for(int j=0; j<n; j++){
                area += (grid[i][j] != 0 ? 1 : 0);
                maxInRow[i] = Math.max(maxInRow[i], grid[i][j]);
                maxInCol[j] = Math.max(maxInCol[j], grid[i][j]);
            }
        }
        // System.out.println(Arrays.toString(maxInRow));
        // System.out.println(Arrays.toString(maxInCol));
        for(int item: maxInCol){
            area += item;
        }
        for(int item: maxInRow){
            area += item;
        }
        return area;
    }
}