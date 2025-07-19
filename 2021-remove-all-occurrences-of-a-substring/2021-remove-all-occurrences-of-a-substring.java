class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int partLen = part.length();
        for(char ch: s.toCharArray()){
            sb.append(ch);
            if(sb.length() >= partLen && sb.substring(sb.length()-partLen).equals(part)){
                for(int i=0; i<partLen; i++){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return sb.toString();
    }
}