class Solution {
public:
    bool isVowel(char ch){
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
    bool doesAliceWin(string s) {
        //alice ->true else false
        //removes the non-empty, odd no. of vowels from string
        //bob even no of substring
        // bool alicwWin = false;
        // int vowels = 0;
        //greedyliy they try to exhaust the vowels
        for(char ch: s){
            if(isVowel(ch)){
                // vowels++;
                return true;
            }
        }
        //bob can remove 0 vowels as well
        // bool turn = 1;//alice
        // while(vowels > -1){
        //     if(turn){
        //         if(vowels%2 != 0){
        //             //exhaust all and alice wins
        //             return true;
        //         }else if(vowels > 0){
        //             vowels = 1;
        //         }else{
        //             return false;//bob wins
        //         }
        //     }else{
        //         if(vowels % 2 == 0) return false;
        //         else if(vowels%2 != 0){
        //             //do nothing don't remove any vowels
        //             vowels = 1;//removes all even occurences
        //         }else{
        //             return true;
        //         }
        //     }
        //     turn = ~turn;
        // }
        // return (vowels%2 != 0);
        return false;
    }
};