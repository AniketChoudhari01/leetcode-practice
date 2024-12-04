class Solution {
    private int findIdx(int j, String str1, char ch){
        for(int i=j;i<str1.length() ;i++){
            if((str1.charAt(i)==ch) || (str1.charAt(i)-'a')==((ch-'a'-1+26)%26)){
                return i;
            }
        }
        return -1;
    }

    public boolean canMakeSubsequence(String str1, String str2) {
        int j=0;
        for(int i=0;i<str2.length(); i++){
            int idx=findIdx(j,str1, str2.charAt(i));
            System.out.println(idx);
            if(idx==-1){
                return false;
            }else{
                j=idx+1;
            }
        }
        return true;
    }
}