class Solution {
    public int prefixCount(String[] words, String pref) {
        int totalStrings = 0;
        for(String str: words){
            if(str.startsWith(pref)){
                totalStrings++;
            }
        }
        return totalStrings;
    }
}