class Solution {
    public int numberOfBeams(String[] bank) {
        int cnt = 0;
        int prev = 0;
        for(String str: bank){
            int beams = 0;
            for(char ch: str.toCharArray()){
                if(ch == '1'){
                    beams++;
                }
            }
            cnt += (beams*prev);
            if(beams != 0) prev = beams;
        }
        return cnt;
    }
}