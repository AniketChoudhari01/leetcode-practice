class Solution {
    public int maxDistance(String s, int k) {
        char [][] dir = new char[][]{{'N','E'},{'N','W'},{'S','E'},{'S','W'}};
        int maxi = 0;
        for(char d[]: dir){
            for(int i=0, temp = k, curr = 0; i<s.length(); i++){
                if(s.charAt(i) == d[0] || s.charAt(i) == d[1]){
                    if(temp > 0){
                        temp--;
                        curr++;
                    }else{
                        curr--;
                    }
                }else{
                    curr++;
                }
                maxi = Math.max(maxi, curr);
            }
        }
        return maxi;
    }
}