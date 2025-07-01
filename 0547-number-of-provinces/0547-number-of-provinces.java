class Solution {
    boolean visited[];
    private void dfs(int[][] isConnected, int src){
        if(visited[src]) return;
        visited[src] = true;
        for(int i=0; i<isConnected.length; i++){
            if(isConnected[src][i] == 1 && !visited[i]){
                dfs(isConnected, i);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int noOfProvinces = 0;
        int n = isConnected.length;
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(isConnected, i);
                noOfProvinces++;
            }
        }
        return noOfProvinces;
    }
}