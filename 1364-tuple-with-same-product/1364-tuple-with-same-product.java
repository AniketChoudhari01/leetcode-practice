class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        if(n < 4) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int cnt  = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int prod = nums[i]*nums[j];
                // System.out.println(prod);
                if(map.containsKey(prod)){
                    map.put(prod, map.get(prod)+1);
                    // System.out.println("present: "+prod);
                    cnt += map.get(prod);
                }else{
                    map.put(prod, 0);
                }
            }
        }
        return cnt*8;
    }
}