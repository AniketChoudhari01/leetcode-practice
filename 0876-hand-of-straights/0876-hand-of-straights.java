class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if ((n % groupSize) != 0)
            return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int item : hand) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        while (!map.isEmpty()) {
            int prev = map.firstEntry().getKey();
            for (int i = 0; i < groupSize; i++) {
                if (!map.containsKey(prev + i))
                    return false;
                map.put(prev + i, map.get(prev + i) - 1);
                if (map.get(prev + i) == 0) {
                    map.remove(prev + i);
                }
            }

        }
        return true;
    }
}