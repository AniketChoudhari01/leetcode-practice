
class Solution {
    TreeMap<Integer, Integer> map;

    private void dfs(int level, TreeNode root) {
        if (root == null) {
            return;
        }
        map.put(level, root.val);
        dfs(level + 1, root.left);
        dfs(level + 1, root.right);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        map = new TreeMap<>();
        dfs(0, root);
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> item: map.entrySet()){
            ans.add(item.getValue());
        }
        return ans;
    }
}