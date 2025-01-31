class Solution {
    int id;

    private int dfs(int i, int j, int grid[][]) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid.length || grid[i][j] != 1) {
            return 0;
        }
        int left = 0, top = 0, right = 0, bottom = 0;
        // int temp = grid[i][j];
        grid[i][j] = id;
        top = dfs(i - 1, j, grid);
        left = dfs(i, j - 1, grid);
        bottom = dfs(i + 1, j, grid);
        right = dfs(i, j + 1, grid);
        
        return 1 + top + left + bottom + right;
        // return temp + top + left + bottom + right;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        if (n == 1 && grid[0][0] == 0) {
            return 1;
        }
        id = 2;
        Map<Integer, Integer> idMap = new HashMap<>();
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int currArea = dfs(i, j, grid);
                    idMap.put(id, currArea);
                    id++;
                }
            }
        }
        // int cntZeros = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> visitedIds = new HashSet<>();
                    int size = 0;
                    if (i - 1 >= 0 && grid[i - 1][j] != 0 && visitedIds.add(grid[i - 1][j])) {
                        size += idMap.getOrDefault(grid[i - 1][j], 0);
                    }
                    if (i + 1 < n && grid[i + 1][j] != 0 && visitedIds.add(grid[i + 1][j])) {
                        size += idMap.getOrDefault(grid[i + 1][j], 0);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] != 0 && visitedIds.add(grid[i][j - 1])) {
                        size += idMap.getOrDefault(grid[i][j - 1], 0);
                    }
                    if (j + 1 < n && grid[i][j + 1] != 0 && visitedIds.add(grid[i][j + 1])) {
                        size += idMap.getOrDefault(grid[i][j + 1], 0);
                    }
                    maxArea = Math.max(maxArea, size + 1);
                    // cntZeros++;
                }
            }
        }
        // if (cntZeros == 0) {
        // return n * n;
        // }
        return (maxArea == 0) ? n * n : maxArea;
    }
}