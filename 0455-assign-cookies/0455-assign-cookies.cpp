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
        int child = 0, cookie = 0;
        while(cookie < cookies && child < childrens){
            if(g[child] <= s[cookie]){
                child++;
                cookie++;
                contented++;
            }else{
                cookie++;
            }
        }
        return contented;
    }
};