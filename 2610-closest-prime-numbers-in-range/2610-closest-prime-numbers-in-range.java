class Solution {
    static final int MAX = (int)1e6 + 1;
    static final boolean seive[] = new boolean[MAX];
    static{
        seive[1] = true;
        for(int i = 2; i< seive.length; i++){
            if(!seive[i]){
                for(long j = (long)i*i; j<seive.length; j += i){
                    seive[(int)j] = true;
                }
            }
        }
    }
    public int[] closestPrimes(int left, int right) {
        int ans[] = {-1, -1};
        int cnt = 0;
        int prev = -1;
        int next = -1;
        List<Integer> list = new ArrayList<>();
        for(int i = left ; i<= right; i++){
            if(!seive[i]){
                list.add(i);
            }
        }
        if(list.size()<2) return ans;
        int min = Integer.MAX_VALUE;
        for(int i=1; i<list.size(); i++){
            if(min > (list.get(i)- list.get(i-1))){
                min = list.get(i) - list.get(i-1);
                ans[0]= list.get(i-1);
                ans[1] = list.get(i);
            }
        }
        return ans;
    }
}