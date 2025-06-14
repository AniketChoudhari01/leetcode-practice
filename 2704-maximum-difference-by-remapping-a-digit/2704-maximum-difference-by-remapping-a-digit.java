class Solution {
    public int minMaxDifference(int num) {
        int n = (int)Math.floor(Math.log10(num) + 1);
        int arr[] = new int[n];
        for(int i=n-1; i>=0 ;i--){
            arr[i] = num %10;
            num /= 10;
        }
        int arr2[] = Arrays.copyOf(arr, n);
        int selected = -1;
        for(int i=0; i<n; i++){
            if(selected == arr[i]){
                arr[i] = 9;
                continue;
            }
            if(selected == -1 && arr[i] != 9){
                selected = arr[i];
                arr[i] = 9;
            }
        }
        selected = -1;
        for(int i=0; i<n; i++){
            if(selected == arr2[i]){
                arr2[i] = 0;
                continue;
            }
            if(selected == -1 && arr2[i] != 0){
                selected = arr2[i];
                arr2[i] = 0;
            }
        }
        for(int i=0; i<n; i++){
            arr[i] -= arr2[i];
        }
        int ans = 0;
        for(int dig: arr){
            ans = ans*10 + dig;
        }
        // System.out.println(Arrays.toString(arr));
        return ans;
    }
}