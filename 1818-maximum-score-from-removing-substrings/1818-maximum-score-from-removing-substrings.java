class Solution {
    public int maximumGain(String s, int x, int y) {
        //brute force approach will be seperately to calcuate all the possible ansers for each possible substring at the current point.
        //will the greedy approach work here?
        //cdbcbbaaa ba b +5
        //cdbcbbaa ab +4
        //cdbcb ba a +5
        //cdbc ba +5
        //"cdbc" score = 19
        //why starting from end
        //aabbaaxybba ab b +4
        //aabbaaxybb ab +4
        //aab ba axybb +5
        //aa ba xybb +5
        //aaxybb score = 18
        //to gain x points remove "ab" else "ba"
        char firstChar = x > y ? 'a' : 'b';
        char lastChar = x > y ? 'b' : 'a';//lastChar
        Stack<Character> st = new Stack<>();
        int score = 0;
        for(char ch: s.toCharArray()){
            if(!st.isEmpty() && st.peek() == firstChar && ch == lastChar){
                score += Math.max(x, y);
                st.pop();
                continue;
            }
            st.push(ch);
        }
        Stack<Character> st2 = new Stack<>();
        while(!st.isEmpty()){
            char ch = st.pop();
            if(!st2.isEmpty() && st2.peek() == firstChar && ch == lastChar){
                score += Math.min(x, y);
                st2.pop();
                continue;
            }
            st2.push(ch);
        }
        // System.out.println(st);
        return score;
    }
}