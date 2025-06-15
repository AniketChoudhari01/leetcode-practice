class Solution {
    public int maxDiff(int num) {
        int n = (int)Math.floor(Math.log10(num)+1);
        int arr[] = new int[n];
        for(int i=n-1; i>=0; i--){
            arr[i] = num%10;
            num /= 10;
        }
        int arr2[] = Arrays.copyOfRange(arr, 0, n);
        int n1 = -1, n2 = -1;
        for(int i=0; i<n; i++){
            if(arr[i] == n1){
                arr[i] = 9;
                continue;
            }
            if(n1 == -1 && arr[i] != 9){
                n1 = arr[i];
                arr[i] = 9;
            }
        }
        int replace = arr2[0] > 1 ? 1 : 0;
        for(int i=0; i<n; i++){
            if(arr2[i] == n2){
                arr2[i] = replace;
                continue;
            }
            if(n2 == -1 && arr2[i] != 1 && arr2[i] != 0){
                n2 = arr2[i];
                arr2[i] = replace;
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            arr[i] -= arr2[i];
            ans = ans*10 + arr[i];
        }
        // System.out.println(Arrays.toString(arr));
        return ans;
    }
}