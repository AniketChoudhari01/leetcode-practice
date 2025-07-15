class Solution {
    static Set<Character> set = new HashSet<>();
    static {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
    }
    public boolean isValid(String word) {
        if(word.length() < 3) return false;
        int vowels = 0;
        int consonents = 0;
        for(char ch: word.toCharArray()){
            if(!Character.isDigit(ch) && (ch < 'a' || ch > 'z')  && (ch < 'A' || ch > 'Z')){
                return false;
            }
            if(set.contains(ch)){//is a vowel
                vowels++;
            }else if(!Character.isDigit(ch)){//when not a digit means it is a consonent
                consonents++;
            }
        }
        if(vowels > 0 && consonents > 0) return true;
        return false;
    }
}