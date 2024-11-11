class Solution {

    private boolean isIncreasing(int nums[]) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean primeSubOperation(int[] nums) {
        // It could be any prime number not just lesser one
        if (isIncreasing(nums)){
            return true;
        }

        boolean primeArr[] = new boolean[1001];
        for (int i = 2; i < primeArr.length; i++) {
            if (isPrime(i)){
                primeArr[i] = true;
            }
        }
        int prev = 0;
        // find the index from right where change has been occured
        int right = nums.length - 1;
        while (right > 0 && nums[right] > nums[right - 1]) {
            right--;
        }
       
        for (int i = 0; i <= right; i++) {
            // make everything to its min possible value
            int temp = nums[i];
            do {
                // if(i==right && temp<=2){
                //     break;
                // }
                temp--;
                while (temp>=2 && !primeArr[temp]) {
                    temp--;
                }
                // initially substract higher values
            } while (prev >= (nums[i] - temp) && temp>0);
            if(temp >1){
                nums[i] -= temp;
            }
            prev = nums[i];
            if (isIncreasing(nums)){
                return true;
            }
        }
        if (!isIncreasing(nums)) {
            return false;
        }
        return true;
    }
}