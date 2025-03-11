class Solution {
    public int numberOfSubstrings(String s) {
        int arr[] = new int[3];
        int n = s.length();
        int right = 0, left = 0;
        int ans = 0;
        while(right < n){
            char ch = s.charAt(right);
            arr[ch-'a']++;
            while(left < right && arr[0]>0 && arr[1]>0 && arr[2]>0){
                ans += n - right;
                arr[s.charAt(left)-'a']--;
                left++;
            }
            right++;
        }
        return ans;
    }
}