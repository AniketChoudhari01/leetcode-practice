class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int prefix = 0;
        int minPrefix = 0;
        int maxPrefix = 0;

        for (int diff : differences) {
            prefix += diff;
            minPrefix = Math.min(minPrefix, prefix);
            maxPrefix = Math.max(maxPrefix, prefix);
            if((upper - maxPrefix) - (lower-minPrefix) + 1 <= 0){
                return 0;
            }
        }

        return (upper - maxPrefix) - (lower-minPrefix) + 1;
    }
}
