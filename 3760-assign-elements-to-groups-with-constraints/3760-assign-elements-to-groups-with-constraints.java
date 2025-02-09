class Solution {
    private int getMaxElem(int arr[]){
        int maxElem = arr[0];
        for(int num: arr){
            maxElem = Math.max(maxElem, num);
        }
        return maxElem;
    }
    public int[] assignElements(int[] groups, int[] elements) {
        int n = groups.length;
        int maxOfElems = getMaxElem(elements);
        boolean visited[] = new boolean[maxOfElems + 1];
        int maxElemGroups = getMaxElem(groups);
        int store[] = new int[maxElemGroups + 1];
        Arrays.fill(store, -1);
        for (int i = 0; i < elements.length; i++) {
            int item = elements[i];
            if (!visited[item]) {
                visited[item] = true;
                for (int j = item; j < store.length; j += item) {
                    if (store[j] == -1) {
                        store[j] = i;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            groups[i] = store[groups[i]];
        }
        return groups;
    }
}