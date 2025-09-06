class Solution {
    using ll = long long;
public:
    long long minOperations(vector<vector<int>>& queries) {
        // 2, 3, 4 -> (1, 1, 2) it is the maximum no of ops among them right and
        // that will be for the maximum element from them for now I feel the
        // optimal pairing can be done between the smallest and largest element
        ll ans = 0;

        for (auto& query : queries) {
            ll a = query[0], b = query[1];
            ll ops = 0;
            // concepts comes here is off binary lengths when divided by 4 we
            // shift an element by 2 right side that means we can use the
            // concept of binary length i.e 3 = (11)2 in , 6 =(110)2 in binary
            // we can represent them like this so there binary lengths are 2, 3
            // respectively. to find the no. of ops required for individual
            // number to make 0, we need to further divide thei binary length by
            // 2 and check how many ops are required for each of this numbers if
            // we calcualte the num of total required to find the [1, l-1] and
            // [1, r] we can substract them to find for [l, r];
            //here d is the number of divisions needed
            for(ll d = 1, prev = 1; d<17; d++){
                ll curr = prev * 4;
                //check if interval (a,b) and (prev, curr-1) overlaps
                ll l = max(a, prev);
                ll r = min(b, curr-1);
                if(r >= l){
                    //means overlaps
                    ops += (r-l+1)*d;
                }
                prev = curr;
            }
            ans += (ops+1)/2;
        }
        return ans;
    }
};