class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        
        String []arr=sentence.split(" ");
        int i=1;
        for(String str:arr){
            if(str.startsWith(searchWord)){
                return i;
            }
            i++;
        }
        return -1;
    }
}