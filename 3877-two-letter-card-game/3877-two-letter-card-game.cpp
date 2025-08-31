class Solution {
public:
    int score(vector<string>& cards, char x) {
        // logic is written in nb
        // assume it as we have Type1 ax , Type2 xb and Typ3 as xx
        // we can pair type1 - type1
        // we can pair type2 - type2
        // we can pair typ3 with typ1 and typ2

        // now find the type1 pairs and typ2 internal pairs
        unordered_map<int, int> freq1, freq2;

        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        for (auto& c : cards) {
            if (c[0] == x && c[1] == x) {
                cnt3++;
            } else if (c[0] == x) {
                cnt1++;
                freq1[c[1]]++;
            } else if (c[1] == x) {
                cnt2++;
                freq2[c[0]]++;
            }
        }

        // now calc the max freq elem from both array
        int max1 = 0, max2 = 0;
        for (auto &[x, y] : freq1) {
            max1 = max(max1, y);
        }
        for (auto &[x, y] : freq2) {
            max2 = max(max2, y);
        }
        int pair1 = min(cnt1 / 2, cnt1-max1);
        int unpaired = cnt1 - 2*pair1;
        int pair2 = min(cnt2 / 2, cnt2-max2);
        unpaired += cnt2 - 2*pair2;

        int ans = pair1 + pair2 + min(cnt3, unpaired);
        //third in ans is min we can pair from rem of typ1 and type2 with type3

        //edge case we can break the paired one within typ1 or type2 to form a pair with typ3 and increase our ans greedy
        if(cnt3 > unpaired){
            ans += min((cnt3-unpaired)/2, pair1 + pair2);
        }
        return ans;
    }
};