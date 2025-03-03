
class Solution {
    // TreeMap<Integer, Integer> map;

    private void dfs(int level, TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if(ans.size() == level){
            ans.add(root.val);
        }
        // map.put(level, root.val);
        //prioritize right first
        dfs(level + 1, root.right, ans);
        dfs(level + 1, root.left, ans);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        // map = new TreeMap<>();
        List<Integer> ans = new ArrayList<>();
        dfs(0, root, ans);
        // for(Map.Entry<Integer, Integer> item: map.entrySet()){
        //     ans.add(item.getValue());
        // }
        return ans;
    }
}