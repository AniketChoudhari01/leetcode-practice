class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        int freq[] = new int[1001];
        int cnt = nums1.length;
        for (int[] arr : nums1) {
            freq[arr[0]] = arr[1];
        }
        for (int arr[] : nums2) {
            if(freq[arr[0]]==0) cnt++;
            freq[arr[0]] += arr[1];
        }
        int ans[][] = new int[cnt][2];
        for(int i=0, j = 0; i<freq.length; i++){
            if(freq[i] != 0){
                ans[j][0] = i;
                ans[j++][1] = freq[i];
            }
        }
        return ans;
    }
}