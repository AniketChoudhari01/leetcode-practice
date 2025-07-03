class Solution {
    static StringBuilder sb = new StringBuilder();
    static{
        sb.append('a');
        while(sb.length() < 500){
            int size = sb.length();
            for(int i=0; i<size; i++){
                int index = sb.charAt(i) - 'a';
                index = (index + 1)%26;
                char newChar = (char)(index + 'a');
                sb.append(newChar);
            }
        }
    }
    public char kthCharacter(int k) {
        return sb.charAt(k-1);
    }
}