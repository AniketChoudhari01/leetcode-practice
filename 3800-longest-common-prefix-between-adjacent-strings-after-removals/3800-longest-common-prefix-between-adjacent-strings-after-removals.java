class Solution {
    private int getLCP(String w1, String w2){
        //function to get the common prefix betn w1 and w2
        int k = Math.min(w1.length(), w2.length());
        int len = 0;
        while(len < k && w1.charAt(len) == w2.charAt(len)){
            len++;
        }
        return len;
    }
    public int[] longestCommonPrefix(String[] words) {
        int n = words.length;
        int ans[] = new int[n];
        int lcp[] = new int[n];
        int prefixMax[] = new int[n];
        int suffixMax[] = new int[n];
        for(int i=0; i<n-1; i++){
            lcp[i] = getLCP(words[i], words[i+1]);
        }
        //update the prefixMax
        for(int i=1; i<n; i++){
            prefixMax[i] = Math.max(prefixMax[i-1], lcp[i-1]);
        }
        //update the suffixMax
        for(int i=n-2; i>=0; i--){
            suffixMax[i] = Math.max(suffixMax[i+1], lcp[i]);
        }
        for(int i=0; i<n; i++){ //delete index
            int commonPrefix = 0;
            if(i < n-1){
                //compare if the right has the max lcp
                commonPrefix = Math.max(commonPrefix, suffixMax[i+1]);
            }
            if(i > 0){
                //compare if the left has the max lcp
                commonPrefix = Math.max(commonPrefix, prefixMax[i-1]);
            }
            if(i > 0 && i < n-1){
                commonPrefix = Math.max(commonPrefix, getLCP(words[i-1], words[i+1]));
            }
            ans[i] = commonPrefix;
        }
        // System.out.println(Arrays.toString(ans));
        return ans;
    }
}