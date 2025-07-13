class Solution {
    public char processStr(String s, long k) {
        //after watching the solns
        long n = 0;//denotes the length
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '*'){
                n = Math.max(0, n-1);
            }else if(ch == '#'){
                n *= 2;
            }else if(ch == '%'){
                //no effect on length
            }else{
                n++;
            }
        }
        // System.out.println("k, n "+k+" "+n);
        if(k >= n) return '.';
        //travel in reverse direction to nullified the effect of each operation
        for(int i = s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if(ch == '*'){
                n++;
            }else if(ch == '#'){
                if(n > 0){
                    n /= 2;
                    k %= n;
                }
            }else if(ch == '%'){
                //reverse idx
                k = n - 1 - k;
            }else {
                if(k == n-1){
                    return ch;
                }
                n--;
            }
        }
        return '.';
    }
}