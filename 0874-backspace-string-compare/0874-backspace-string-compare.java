class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int ptr1 = n1 - 1, ptr2 = n2 - 1;
        int cnt1 = 0, cnt2 = 0;
        while (ptr1 >= 0 || ptr2 >= 0) {
            while(ptr1 >= 0){
                if(s.charAt(ptr1) == '#'){
                    cnt1++; ptr1--;
                }else if(cnt1 > 0 ){
                    cnt1--;
                    ptr1--;
                }else{
                    break;
                }
            }
            while(ptr2 >= 0){
                if(t.charAt(ptr2) == '#'){
                    cnt2++;
                    ptr2--;
                }else if(cnt2 > 0){
                    cnt2--;
                    ptr2--;
                }else{
                    break;
                }
            }
            if(ptr1 >= 0 && ptr2 >=0 && s.charAt(ptr1) != t.charAt(ptr2)){
                return false;
            }
            if((ptr1 >= 0) != (ptr2 >= 0)){
                return false;
            }
            ptr1--;
            ptr2--;
        }

        return true;
    }
}