class Solution {
    private int getDigitSum(int num) {
        int sum = 0;
        int temp = num;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        } 
        return sum;
    }

    public int maximumSum(int[] nums) {
        int maxi = -1;
        Map<Integer, Integer> map = new HashMap<>();// (digit sum , number)
        for (int num : nums) {
            int sum = getDigitSum(num);
            if(!map.containsKey(sum)){
                map.put(sum, num);
                continue;
            }
            maxi = Math.max(maxi, num + map.get(sum));
            if(map.get(sum) < num){
                map.put(sum, num);
            }
        }
        return maxi;
    }
}