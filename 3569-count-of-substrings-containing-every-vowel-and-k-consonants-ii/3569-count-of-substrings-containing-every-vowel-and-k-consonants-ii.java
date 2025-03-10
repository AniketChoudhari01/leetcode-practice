class Solution {
    private boolean isConsonant(char ch){
        return !(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u');
    }
    private boolean hasAllVowels(int arr[]){
        return (arr['a'-'a']>=1 && arr['e'-'a']>=1 && arr['i'-'a']>=1 && arr['o'-'a']>=1 && arr['u'-'a']>=1);
    }
    public long countOfSubstrings(String word, int k) {
        return atLeastKConsonants(k, word) - atLeastKConsonants(k+1, word);
    }
    private long atLeastKConsonants(int k , String word){
        int left = 0;
        int right = 0;
        int cntCons = 0;
        int arr[] = new int[26];
        int n = word.length();
        long ans = 0;
        while(right < n){
            char ch = word.charAt(right);
            arr[ch-'a']++;
            if(isConsonant(ch)){
                cntCons++;
            }
            while(cntCons >= k && hasAllVowels(arr)){
                char c = word.charAt(left);
                ans += n - right;
                arr[c-'a']--;
                if(isConsonant(c)){
                    cntCons--;
                }
                left++;
            }
            right++;
        }
        return ans;
    }
}