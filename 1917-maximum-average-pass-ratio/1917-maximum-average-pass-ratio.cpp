class Solution {
public:
    double maxAverageRatio(vector<vector<int>>& classes, int extraStudents) {
        priority_queue<pair<double,pair<int, int>>> pq;//max heap
        
        for(auto it: classes){
            int a = it[0], b = it[1];
            double ratio = double(a+1)/double(b+1) - double(a)/double(b);
            pq.push({ratio, {a, b}});
        }

        while(extraStudents--){
            auto curr = pq.top();
            pq.pop();
            int a = curr.second.first +1;
            int b = curr.second.second +1;
            double ratio = double(a+1)/double(b+1) - double(a)/double(b);
            pq.push({ratio, {a, b}});
        }
        double ans = 0.0;
        while(!pq.empty()){
            auto curr = pq.top();
            pq.pop();
            int a = curr.second.first;
            int b = curr.second.second;
            ans += double(a)/b;
        }
        return ans/classes.size();
    }
};