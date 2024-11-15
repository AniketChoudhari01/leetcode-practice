class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int l=0,r=arr.length-1;
        while(l+1<arr.length && arr[l]<=arr[l+1]){
            l++;
        }
        if(l==arr.length-1){
            return 0;
        }
        while(r>0 && arr[r]>=arr[r-1]){
            r--;
        }
        int ans=Math.min(arr.length-l-1,r);
        int i=0;int j=r;
        while(i<=l && j<arr.length ){
            if(arr[i]<=arr[j]){
                ans=Math.min(ans,(j-i-1));
                i++;
            }else{
            j++;
            }
        }
        return ans;
    }
}