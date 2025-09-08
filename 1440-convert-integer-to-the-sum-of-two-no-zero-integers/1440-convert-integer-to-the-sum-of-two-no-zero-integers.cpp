class Solution {
public:
    bool isValid(int n){
        while(n > 0){
            int dig = n%10;
            if(dig == 0) return false;
            n /= 10;
        }
        return true;
    }
    vector<int> getNoZeroIntegers(int n) {
        vector<int> ans(2, 0);
        for(int i=1; i<=n; i++){
            int a = i, b = n-i;
            bool flag = isValid(i);
            if(flag && isValid(n-i)){
                ans[0] = i;
                ans[1] = n-i;
                break;
            }
        }
        return ans;
    }
};