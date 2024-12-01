class Solution {
    public boolean checkIfExist(int[] arr) {

        HashSet<Integer> set = new HashSet<>();
        int n = arr.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                set.add(arr[i]);
            } else {
                cnt++;
            }
        }
        if (cnt > 1) {
            set.add(0);
        }
        for (int i = 0; i < n; i++) {
            if (set.contains((arr[i] * 2))) {
                return true;
            }
        }
        return false;
    }
}