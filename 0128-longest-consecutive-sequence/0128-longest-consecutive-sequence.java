
class Solution {
    Map<Integer, Integer> parent;
    Map<Integer, Integer> size;

    public int findUParent(int node) {
        if (parent.get(node) == node) return node;
        parent.put(node, findUParent(parent.get(node)));
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if (ulp_u == ulp_v) return;

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.put(ulp_u, ulp_v);
            size.put(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.put(ulp_v, ulp_u);
            size.put(ulp_u, size.get(ulp_v) + size.get(ulp_u));
        }
    }

    public int longestConsecutive(int[] nums) {
        parent = new HashMap<>();
        size = new HashMap<>();

        for (int x : nums) {
            if (parent.containsKey(x)) continue; // handle duplicates
            parent.put(x, x);
            size.put(x, 1);

            if (parent.containsKey(x - 1)) {
                unionBySize(x, x - 1);
            }
            if (parent.containsKey(x + 1)) {
                unionBySize(x, x + 1);
            }
        }

        int maxLen = 0;
        for (int s : size.values()) {
            maxLen = Math.max(maxLen, s);
        }
        return maxLen;
    }
}
