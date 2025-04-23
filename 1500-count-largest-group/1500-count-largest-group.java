class Solution {
    public int countLargestGroup(int n) {
        int sum[] = new int[37];
        int max_grp = 1;
        for (int num = 1; num <= n; num++) {
            int curr_sum = 0;
            int temp = num;
            while (temp > 0) {
                curr_sum += temp % 10;
                temp /= 10;
            } 
            sum[curr_sum]++;
            max_grp = Math.max(max_grp, sum[curr_sum]);
        }
        int cnt = 0;
        for (int size : sum) {
            if (size == max_grp) cnt++;
        }
        return cnt;
    }
}