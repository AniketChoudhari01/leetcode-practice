class Solution {
    public String compressedString(String word) {
        
        StringBuilder comp=new StringBuilder();
        word+="$";
        // for(int i=0;i<word.length();i++){
            int cnt=1;
            for(int j=1;j<word.length();j++){
                if(word.charAt(j)!=word.charAt(j-1)){
                    comp.append(cnt).append(word.charAt(j-1));
                    cnt=1;
                }else if (cnt==9){
                    comp.append(cnt).append(word.charAt(j-1));
                    cnt=1;
                }
                else{
                    cnt++;
                }
            }
            
        // }

        return comp.toString();
    }
}