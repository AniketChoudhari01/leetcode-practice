class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        int cmnPrefix[] = new int[n];
        int cnt = 0;
        for(int i=0; i<n; i++){
            setA.add(A[i]);
            setB.add(B[i]);
            if(A[i] == B[i]){
                cnt++;
            }else if(setB.contains(A[i]) && setA.contains(B[i])){
                cnt +=2;
            }else if(setB.contains(A[i]) || setA.contains(B[i])){
                cnt++;
            }
            
            cmnPrefix[i]=cnt;
        }
        return cmnPrefix;
    }
}