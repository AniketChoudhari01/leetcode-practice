class Solution {
    List<Integer> list;
    private void dfs(int currNum, int n){
        if(currNum > n) return;
        list.add(currNum);
        for(int i = 0; i<10; i++){
            int next = currNum*10+i;
            if(next > n) break;
            dfs(next, n);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        list = new ArrayList<>();
        for(int i=1; i<10; i++){
            dfs(i, n);
        }
        return list;
    }
}