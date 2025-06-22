class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int rem = ((n%k) != 0 ? 1 :0);
        int len = n/k + rem;
        String ans[] = new String[len];
        int idx = 0;
        for(int i=0; i<len && idx + k < n; i++){
            ans[i] = s.substring(idx, idx+k);
            idx += k;
        }
        if(idx < n){
            StringBuilder sb = new StringBuilder(s.substring(idx));
            while(sb.length() < k){
                sb.append(fill);
            }
            ans[len - 1] = sb.toString();
        }
        return ans;
    }
}