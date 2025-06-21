class Solution {
    public int minimumDeletions(String word, int k) {
        int freq[] = new int[26];
        int miniDeletes = Integer.MAX_VALUE;
        for(char ch: word.toCharArray()){
            freq[ch - 'a']++;
        }
        for(int i=0; i<26; i++){
            if(freq[i] != 0){
                int cnt = 0;
                for(int j=0; j<26; j++){
                    if(freq[j] != 0){
                        if(freq[j] < freq[i]){
                            cnt += freq[j];
                        }else if(freq[j] > freq[i] + k){
                            cnt += (freq[j] - freq[i] - k);
                        }
                    }
                }
                miniDeletes = Math.min(miniDeletes, cnt);
            }
        }
        return miniDeletes;
    }
}