class Solution {

    private boolean canDistribute(int dist, int quantities[], int n){
            // if(n==quantities.length && dist==quantities[quantities.length-1]){
            //     return true;
            // }
            //calculating how many I store I can fill with distribution x(dist)
            int cnt=0;
            for(int num: quantities){
                cnt+=(num/dist);
                if((num%dist)>0){
                    cnt++;
                }
            }
            if(cnt>n){
                return false;
            }
            return true;
    }
    public int minimizedMaximum(int n, int[] quantities) {

        // Arrays.sort(quantities);
        // Set<Integer> set=new HashSet<>();
        int high=0;
        for(int num:quantities){
            high=Math.max(high, num);
        }
        // int space[]=new int[set.size()];
        // Iterator<Integer> it=set.iterator();
        // int j=0;
        // while(it.hasNext()){
        //     space[j++]=it.next();
        // }

        // Arrays.sort(space);
        // System.out.println(Arrays.toString(quantities));
        // System.out.println(Arrays.toString(space));

        int m=quantities.length;
        // int ans=0;
        int low=1;
        while(low<=high){ //l=0,h=4, m=2
            int mid=(low+high)/2;
            // System.out.println(space[mid]);
            if(canDistribute(mid, quantities, n)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;

        // int curr_min=0;
        // int mini=Integer.MAX_VALUE;
        // int sum=0;
        // System.out.println(Arrays.toString(quantities));
        // for(int i=0; i<m; i++){
        //     curr_min=quantities[i];
        //     if((m-i)==n){
        //         return quantities[m-1];
        //     }else if(curr_min < n){
        //         mini=Math.max(mini, curr_min);
        //         n-=1;
        //     }else{//curr_min>>n always add for here to reduce tc
        //         sum+=quantities[i]; 
        //     }
        // }
        // int distribution=(sum/n);
        // if((sum%n)>0){
        //     distribution++;
        // }
        // System.out.println("Sum: "+sum+" maxi : "+mini);
        // if(mini!=Integer.MAX_VALUE){
        //     return Math.max(mini, distribution);//m=25
        // }
        // return distribution;

        //[1,1,1,1,1,1,2,2,2,2,3,3,4,4,4,4,4,4,4,4,4,4,5,5,5] , n=100000
        //curr_min=1,1
        //maxi=1,
        //n=100000,99999
    }
}