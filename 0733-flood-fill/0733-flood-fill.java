class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int originalColor = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[m][n];
        q.add(new int[] { sr, sc });
        visited[sr][sc] = true;
        int dx[] = { -1, 0, 1, 0 };
        int dy[] = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int point[] = q.poll();
                image[point[0]][point[1]] = color;
                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];
                    if (x < 0 || y < 0 || x >= m || y >= n || image[x][y] != originalColor || image[x][y] == color)
                        continue;
                    image[x][y] = color;
                    q.offer(new int[] { x, y });
                }
            }
        }
        return image;
    }
}