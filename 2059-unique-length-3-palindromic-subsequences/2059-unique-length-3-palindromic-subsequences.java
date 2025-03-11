class Solution {
    public int countPalindromicSubsequence(String s) {
        int arr[][] = new int[26][2];
        for(int a[]:arr){
            Arrays.fill(a, -1);
        }
        int n = s.length();
        for(int i=0; i<n; i++){
            int idx = s.charAt(i)-'a';
            if(arr[idx][0] == -1){
                arr[idx][0] = i;
            }else{
                arr[idx][1] = i;
            }
        }
        int ans = 0;
        boolean visited[];
        for(int a[]:arr){
            if(a[0]==-1 || a[1]==-1) continue;
            visited = new boolean[26];
            int temp = 0;
            for(int i=a[0]+1; i<a[1];i++){
                char ch = s.charAt(i);
                if(!visited[ch-'a']){
                    visited[ch-'a']= true;
                    temp++;
                }
            }
            ans += temp;
        }
        return ans;
    }
}