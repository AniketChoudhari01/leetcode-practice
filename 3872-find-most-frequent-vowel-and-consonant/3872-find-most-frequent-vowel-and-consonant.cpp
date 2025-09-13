class Solution {
public:
    bool isCons(char ch){
        return (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u');
    }
    int maxFreqSum(string s) {
        int freq[26] = {0};
        int maxVowel = 0, maxCons = 0;
        for(char ch: s){
            freq[ch-'a']++;
            if(isCons(ch)){
                maxCons = max(maxCons, freq[ch-'a']);
            }else{
                maxVowel = max(maxVowel, freq[ch-'a']);
            }
        }
        return maxCons + maxVowel;
    }
};