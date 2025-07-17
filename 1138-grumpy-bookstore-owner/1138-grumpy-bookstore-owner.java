class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int custSatisfied = 0;
        int maxIdx = 0;//when the most number of customers visites the shop
        int n = customers.length;
        int maxSlide = 0;
        for(int i=0; i<=n-minutes; i++){
            // if(grumpy[i] == 1) continue;//don't start here
            int currSlide = 0;
            int len = i + minutes;
            for(int j=i; j<n && j < len; j++){
                if(grumpy[j] == 1){
                    currSlide += customers[j];
                }
            }
            // System.out.println("curr "+currSlide);
            if(maxSlide < currSlide){
                maxIdx = i;
                maxSlide = currSlide;
            }
            // System.out.println("i "+i);
        }
        // System.out.println(maxIdx);
        for(int i=0; i<n; i++){
            if(i >= maxIdx && i < maxIdx + minutes){
                custSatisfied += customers[i];
            }else{
                if(grumpy[i] != 1){
                    custSatisfied += customers[i];
                }
            }
        }
        return custSatisfied;
    }
}