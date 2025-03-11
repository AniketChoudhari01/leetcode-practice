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
        Set<Character> set;
        for(int a[]:arr){
            if(a[0]==-1 || a[1]==-1) continue;
            set = new HashSet<>();
            for(int i=a[0]+1; i<a[1];i++){
                char ch = s.charAt(i);
                set.add(ch);
            }
            ans += set.size();
        }
        return ans;
    }
}