class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        //each child at most 1 cookie
        //to content child we we can assign cookie if s[cookie_j]>= greed[child_i]
        //we have to return the maximum number of child contained?

        //greedy method sort both arrays
        int contented = 0;
        sort( g.begin(), g.end());
        sort( s.begin(), s.end());
        int childrens = g.size(), cookies = s.size();
        for(int child = 0, cookie = 0; child < childrens && child < cookies; child++){
            while(cookie < cookies && g[child] > s[cookie]){
                cookie++;
            }
            if(cookie < cookies && g[child] <= s[cookie]){
                contented++;
                cookie++;//once used I cannot assigned this cookie to any other child
            }
        }
        return contented;
    }
};