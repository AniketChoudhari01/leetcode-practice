class Solution {
    public int findChampion(int n, int[][] edges) {
        int indegree[] = new int[n];
        for(int edge[]: edges){
            indegree[edge[1]]++;
        }
        int dominance = -1;
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                if(dominance != -1) return -1;
                dominance = i;
            }
        }
        return dominance;
    }
}