class Solution {

    public static boolean isEqual(int arr1[], int arr2[]){
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();
        if(n2<n1)
            return false;
        int freq1[]=new int[26];
        for(int i=0;i<n1;i++){
            freq1[s1.charAt(i)-'a']++;
        }
        //sliding window
        int left=0;
        int freq2[]=new int[26];
        for(int right=0; right<n2; right++){
            char ch=s2.charAt(right);
            if((right-left+1)==n1){
                freq2[ch-'a']++;
                //check
                if(isEqual(freq1, freq2)){
                    return true;
                }else{//reset freq
                    freq2[s2.charAt(left)-'a']--;
                    left++;
                }
            }else{
                freq2[ch-'a']++;
            }
        }

        return false;
    }
}