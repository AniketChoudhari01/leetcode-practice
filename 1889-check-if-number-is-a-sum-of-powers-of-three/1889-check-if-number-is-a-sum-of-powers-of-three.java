class Solution {
    public boolean checkPowersOfThree(int n) {
        while(n >= 3){
            if(n % 3 > 1) return false;
            n = n/3;
        }
        return n == 1;
    }
}