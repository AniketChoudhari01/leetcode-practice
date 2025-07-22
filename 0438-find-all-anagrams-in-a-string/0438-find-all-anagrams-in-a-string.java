class Solution {
    private boolean areEqual(int arr1[], int arr2[]){
        for(int i=0; i<26; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        int freq1[] = new int[26];
        int left = 0, right = 0;
        int freq2[] = new int[26];
        List<Integer> list = new ArrayList<>();
        for(char ch: p.toCharArray()){
            freq2[ch-'a']++;
        }
        while(right < n1){
            char ch = s.charAt(right);
            freq1[ch-'a']++;
            int windowSize = right - left +1;
            if(windowSize == n2){
                // System.out.println(left+ " "+ right);
                if(areEqual(freq1, freq2)){
                    list.add(left);
                }
                freq1[s.charAt(left)-'a']--;
                left++;
            }
            right++;
        }
        return list;
    }
}