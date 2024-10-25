class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder); // n*logn
        List<String> ansList = new ArrayList<>();
        String lastKept = folder[0];
        ansList.add(lastKept);
        for (int i = 1; i < folder.length; i++) { // N*N

            // if ((!folder[i].startsWith(lastKept)) || (lastKept.length() <
            // folder[i].length()
            // && folder[i].charAt(lastKept.length()) != '/')) {
            if ((!folder[i].startsWith(lastKept)) || (lastKept.length() < folder[i].length()
                    && folder[i].charAt(lastKept.length()) != '/')) {
                lastKept = folder[i];
                ansList.add(lastKept);
            }
        }
        return ansList;
    }
}