class Solution {
    public int countLargestGroup(int n) {
        int max_size = 9*((int)Math.floor(Math.log10(n))+1)+1;
        // System.out.println(max_size);
        int sum[] = new int[max_size];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num = 1; num <= n; num++) {
            int curr_sum = 0;
            int temp = num;
            while (temp > 0) {
                curr_sum += temp % 10;
                temp /= 10;
            } 
            sum[curr_sum]++;
        }
        for (int size : sum) {
            if (size != 0) {
                map.put(size, map.getOrDefault(size, 0) + 1);
            }
        }
        return map.lastEntry().getValue();
    }
}