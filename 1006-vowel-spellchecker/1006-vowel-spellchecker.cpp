class Solution {
public:
    bool isVowel(char ch){
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'); 
    }
    vector<string> spellchecker(vector<string>& wordlist, vector<string>& queries) {
        //same word return the word
        //if matches up to certain captilization then return the same word
        //elses check for the positions of vowels
        int n = queries.size();
        vector<string> ans(n, "");
        unordered_set<string> set;

        for(auto &it: wordlist){
            set.insert(it);
        }

        int idx = 0;
        for(string query: queries){
            //if matches in lookup
            if(set.count(query)){
                ans[idx] = query;
            }else {
                //matches up to captilization (convert both to lower case)
                bool flag = false;
                for(string str: wordlist){
                    if(str.size() != query.size()) continue;
                    
                    bool turn = false;
                    for(int i=0; i<str.size(); i++){
                        if(tolower(str[i]) != tolower(query[i])){
                            turn = true;
                            break;
                        }
                    }
                    if(!turn){
                        flag = true;
                        ans[idx] = str;
                        break;
                    }
                }

                if(!flag){
                    //vowel match
                    // cout<<query<<"\n";
                    for(string str: wordlist){
                        if(str.size() != query.size()) continue;

                        bool inValid = false;
                        for(int i=0; i<str.size(); i++){
                            bool isVowel1 = isVowel(str[i]);
                            bool isVowel2 = isVowel(query[i]);

                            if(isVowel1 && isVowel2) continue;
                            // if(!isVowel1 && !isVowel2 && str[i] == query[i]) continue;

                            if(tolower(str[i]) != tolower(query[i])){
                                inValid = true;
                                break;
                            }
                            //if there 
                            //2 vowels continue
                            //1 vowel ek const other way
                            //2 consonents
                        }
                        if(!inValid){
                            ans[idx] = str;
                            break;
                        }
                    }
                }
            }
            idx++;
        }

        return ans;
    }
};