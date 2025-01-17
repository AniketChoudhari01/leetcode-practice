class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int flip = 0;
        for (int operation : derived) {
            flip ^= operation;
        }
        return (flip>0) ? false : true;
    }
}