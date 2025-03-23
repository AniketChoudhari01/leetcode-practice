class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long st = 0, et;
        long ans = 0;
        long mat[][] = new long[m][n];
        for (int i = 0; i < m; i++) {
            ans = st;
            for (int j = 0; j < n; j++) {
                ans += (long) skill[j] * mana[i];
                mat[i][j] = ans;
            }
            // find st
            if (i != m - 1) {
                et = ans;
                long low = 0; 
                long high = et; 

                while (low <= high) {
                    long mid = low + (high - low) / 2;
                    boolean isValid = true;
                    long time = mid;

                    for (int k = 0; k < n; k++) {
                        if (time < mat[i][k]) { 
                            isValid = false;
                            break;
                        }
                        time += (long) mana[i + 1] * skill[k];
                    }

                    if (isValid) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                st = low;
            }
        }
        return ans;
    }
}