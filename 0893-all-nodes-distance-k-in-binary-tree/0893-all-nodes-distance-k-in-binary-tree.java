/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void constructGraph(Map<Integer, List<Integer>> adjMap, TreeNode root){
        Queue<TreeNode> pq = new ArrayDeque<>();
        pq.offer(root);
        while(!pq.isEmpty()){
            TreeNode currNode = pq.poll();
            adjMap.putIfAbsent(currNode.val, new ArrayList<>());
            if(currNode.left != null){
                adjMap.putIfAbsent(currNode.left.val, new ArrayList<>());
                adjMap.get(currNode.left.val).add(currNode.val);
                adjMap.get(currNode.val).add(currNode.left.val);
                pq.offer(currNode.left);
            }
            if(currNode.right != null){
                adjMap.putIfAbsent(currNode.right.val, new ArrayList<>());
                adjMap.get(currNode.right.val).add(currNode.val);
                adjMap.get(currNode.val).add(currNode.right.val);
                pq.offer(currNode.right);
            }
        }
        System.out.println(adjMap);
    }
    List<Integer> ansList;
    private void nodesAtDistK(Map<Integer, List<Integer>> adjMap, int currVal, int dist, int k, Set<Integer> visited){
        if(dist == k) return;
        List<Integer> currList = adjMap.get(currVal);
        for(int i=0; i< currList.size(); i++){
            if(!visited.contains(currList.get(i))){
                visited.add(currList.get(i));
                if(dist + 1 == k ){
                    ansList.add(currList.get(i));
                    // System.out.println(" ans "+ ansList);
                }
                nodesAtDistK(adjMap, currList.get(i), dist + 1, k, visited);
            }
        }
        
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        constructGraph(adjMap, root);
        ansList = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);
        if(k == 0){
            ansList.add(target.val);
        }else{
            nodesAtDistK(adjMap, target.val, 0, k, visited);
        }
        return ansList;
    }
}