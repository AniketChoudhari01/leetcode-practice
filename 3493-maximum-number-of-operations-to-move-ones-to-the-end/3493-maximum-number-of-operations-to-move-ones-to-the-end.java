class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        Set<Integer> set = new HashSet<>();
        int maxOperations = 0;
        for(int i=n-1; i>= 0; i--){
            if(s.charAt(i) == '1'){
                maxOperations += set.size();
            }else if(i-1>=0 && s.charAt(i) == '0' && s.charAt(i-1) == '0'){//skipping continuos zeros
                continue;
            }else{
                //current is only zero
                set.add(i);
            }
        }
        return maxOperations;
    }
}