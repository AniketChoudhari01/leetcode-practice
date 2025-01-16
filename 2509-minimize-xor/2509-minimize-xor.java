class Solution {
    private int cntSetBits(int num){
        int cnt = 0;
        while(num>0){
            cnt += num & 1;
            num >>= 1;
        }
        return cnt;
    }
    public int minimizeXor(int num1, int num2) {
        int x = 0;
        int cnt2 = cntSetBits(num2);
        int cnt1 = cntSetBits(num1);
        int bitArr[] = new int [32];
        int temp = num1;
        for(int i=31; i>=0; i--){
            bitArr[i] = temp & 1;
            temp >>= 1;
        }
        for(int i=0; i<32 && cnt2>0 && cnt1>0; i++){
            if(bitArr[i]!=0){
                x += (1 <<(31-i));
                cnt1--;
                cnt2--;
            }
        }
        for(int i=0; i<32 && cnt2 >0; i++){
            if(bitArr[31-i]==0){
                x += (1 << i);
                cnt2 --;
            }
        }
        return x;
    }
}