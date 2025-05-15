class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> list = new ArrayList<>();
        int n = words.length;
        int max = 0;
        List<Integer> temp_ans = new ArrayList<>();
        for(int i=0; i<(n+1)/2; i++){
            int prev = groups[i];
            List<Integer> li = new ArrayList<>();
            li.add(i);
            for(int j = i+1; j < n; j++){
                if((groups[j]^prev) == 1){
                    prev = groups[j];
                    li.add(j);
                }
            }
            if(max < li.size()){
                temp_ans = new ArrayList<Integer>(li);
                max = li.size();
            }
        }
        for(int dig: temp_ans){
            list.add(words[dig]);
        }
        return list;
    }
}