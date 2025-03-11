
class Solution {
    TreeMap<Integer, Integer> map;
    private void findRightView(TreeNode root, int horizontal){
        if(root == null) return;
        findRightView(root.left, horizontal + 1);
        map.put(horizontal, root.val);
        findRightView(root.right, horizontal + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        map = new TreeMap<>();
        findRightView(root, 0);
        List<Integer> ansList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> item:map.entrySet()){
            ansList.add(item.getValue());
        }
        return ansList;
    }
}