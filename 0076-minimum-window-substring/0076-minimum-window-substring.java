class Solution {
    private static boolean areEqual(int arr1[], int arr2[]){
        for(int i=0; i<128; i++){
            if(arr1[i] > arr2[i]){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int left = 0, right = 0;
        int freq1[] = new int[128];
        for(char ch: t.toCharArray()){
            freq1[(int)ch]++;
        }
        int minLen = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        int freq2[] = new int[128];
        while(right < m){
            char ch = s.charAt(right);
            freq2[(int)ch]++;
            while(right - left + 1 >= n && areEqual(freq1, freq2)){
                if(right - left +1 < minLen){
                    minLen = right - left + 1;
                    sb.setLength(0);
                    sb.append(s.substring(left, right + 1));
                }
                
                freq2[(int)s.charAt(left)]--;
                left++;
            }
            right++;
        }
        return sb.toString();
    }
}