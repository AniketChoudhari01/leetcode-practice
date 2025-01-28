class Solution {
    boolean isReachable[][];
    int n;
    private void floydWarshall(int preq[][]){
        for(int k = 0; k<n; k++){
            for(int i = 0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(isReachable[i][k] && isReachable[k][j]){
                        isReachable[i][j] = true;
                    }
                }
            }
        }
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] preq, int[][] queries) {
        n = numCourses;
        isReachable = new boolean[n][n];
        for(int arr[]: preq){
            isReachable[arr[0]][arr[1]]= true;
        }
        floydWarshall(preq);
        List<Boolean> resList = new ArrayList<>();
        for(int arr[]: queries ){
            if(isReachable[arr[0]][arr[1]]){
                resList.add(true);
            }else{
                resList.add(false);
            }
        }

        return resList;
    }
}