
class Solution {
    Map<Integer, Map<Integer, ArrayList<Integer>>> map;

    private void bfs(TreeNode root, int level, int vertical) {
        if (root == null)
            return;
        if (map.containsKey(vertical)) {
            if (map.get(vertical).containsKey(level)) {
                map.get(vertical).get(level).add(root.val);
            } else {
                map.get(vertical).put(level, new ArrayList<>());
                map.get(vertical).get(level).add(root.val);
            }
        } else {
            Map<Integer, ArrayList<Integer>> currMap = new TreeMap<>();
            currMap.put(level, new ArrayList<>());
            currMap.get(level).add(root.val);
            // System.out.println(" "+currMap);
            map.put(vertical, currMap);
        }
        bfs(root.left, level + 1, vertical - 1);
        bfs(root.right, level + 1, vertical + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        List<List<Integer>> list = new ArrayList<>();
        bfs(root, 0, 0);
        // System.out.println(map);
        for (Map.Entry<Integer, Map<Integer, ArrayList<Integer>>> item : map.entrySet()) {// vertical
            List<Integer> li = new ArrayList<>();
            for (Map.Entry<Integer, ArrayList<Integer>> item2 : item.getValue().entrySet()) {// level
                if (item2.getValue().size() > 1) {
                    Collections.sort(item2.getValue(), (a, b) -> (a - b));
                }
                for (int val : item2.getValue()) {
                    li.add(val);
                }
            }

            list.add(li);
        }
        return list;
    }
}