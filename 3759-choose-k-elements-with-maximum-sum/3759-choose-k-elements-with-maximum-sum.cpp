#include <iostream>
#include <algorithm>
#include <vector>
#include <map>
#include <list>
#include <set>
#include <queue>
#include <bits/stdc++.h>
#define ll long long
#define pb push_back
#define ppb pop_back
#define mp make_pair
using namespace std;
using vpi = vector<pair<ll,ll>>;
using pi = pair<ll,ll>;
using vi = vector<ll>;
#define ff first
#define ss second
#define all(x) x.begin(), x.end()
#define sz(x) (int)(x).size()
class Solution
{
public:
    vector<long long> findMaxSum(vector<int> &nums1, vector<int> &nums2, int k)
    {
        multiset<ll> s;
        ll n = sz(nums1);
        vpi order;
        for (ll i = 0; i < n; i++)
        {
            order.pb({nums1[i], i});
        }
        sort(all(order));
        ll sum = 0;
        vi ans(n, 0);
        vi pending;
        for (ll i = 0; i < n; i++)
        {
            ll idx = order[i].ss;
            ll val = nums2[idx];
            ans[idx] = sum;
            pending.pb(val);
            if (i < n - 1 && order[i].ff == order[i + 1].ff)
            {
                continue;
            }
            for (auto &&val : pending)
            {
                if (s.size() < k)
                {
                    sum += val;
                    s.insert(val);
                }
                else if (*s.begin() < val)
                {
                    sum -= *s.begin();
                    s.erase(s.begin());
                    s.insert(val);
                    sum += val;
                }
            }
            pending.clear();
        }
        return ans;
    }
};