class Solution {
    public int captureForts(int[] forts) {
        int capturedForts = 0;
        int n = forts.length;
        int prev = 0;
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (forts[i] == -1 || forts[i] == 1) {
                /* if(prev == 0){
                    prev = forts[i];
                    len = 0;
                }else */ if (prev != forts[i]) {
                    capturedForts = Math.max(capturedForts, len);
                    // len = 0;
                    // prev = forts[i];
                } /* else{
                     len = 0;
                     prev = forts[i];
                  } */
                len = 0;
                prev = forts[i];
            } else {//when 0
                if (prev != 0) {
                    len++;
                }
            }
        }
        return capturedForts;
    }
}