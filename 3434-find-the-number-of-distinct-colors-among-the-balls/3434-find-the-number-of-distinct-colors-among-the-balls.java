class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = limit + 1;
        int qSize = queries.length;
        int res[] = new int[qSize];
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> colorMap = new HashMap<>();
        int i = 0;
        for (int query[] : queries) {
            if (map.containsKey(query[0])) {
                int value = colorMap.getOrDefault(map.get(query[0]), 0);
                if (value - 1 <= 0) {
                    colorMap.remove(map.get(query[0]));
                } else {
                    colorMap.put(map.get(query[0]), value - 1);
                }
            }
            colorMap.put(query[1], colorMap.getOrDefault(query[1], 0) + 1);//
            map.put(query[0], query[1]);
            res[i++] = colorMap.size();
        }
        return res;
    }
}