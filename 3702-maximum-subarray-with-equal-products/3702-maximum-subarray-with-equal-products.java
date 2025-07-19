class Solution {
    private int findGCD(int a, int b){
        if(a < b) return findGCD(b, a);
        if(b == 0) return a;
        return findGCD(b, a%b);
    }
    public int maxLength(int[] nums) {
        int n = nums.length;
        int len = 1;
        for(int left = 0; left <n; left++){
            int item = nums[left];
            int lcm = item, gcd = item, prod = item;
            for(int right = left + 1; right < n; right++){
                int elem = nums[right];
                lcm = (lcm * elem)/findGCD(lcm, elem);
                gcd = findGCD(gcd, elem);
                prod *= elem;
                if(prod == (gcd*lcm)){
                    len = Math.max(len, right - left + 1);
                }
            }
        }
        return len;        
    }
}