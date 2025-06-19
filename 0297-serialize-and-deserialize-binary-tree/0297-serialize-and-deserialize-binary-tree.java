/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        //level order traversal
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if(node != null){
                    sb.append(node.val);
                    q.offer(node.left);
                    q.offer(node.right);
                }else{
                    sb.append('#');
                }
                sb.append(',');
            }
        }
        sb.deleteCharAt(sb.length()-1);
        // System.out.println("st "+sb.toString());
        return sb.toString();
    }
    // Decodes your encoded data to tree.
    private int idx = 0;
    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;
        String arr[] = data.split(",");
        Queue<TreeNode> q = new LinkedList();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        int i=1;
        while(!q.isEmpty() && i<arr.length){
            TreeNode currNode = q.poll();
            if(!arr[i].equals("#")){
                currNode.left = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(currNode.left);
            }
            i++;
            if(i<arr.length && !arr[i].equals("#")){
                currNode.right = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(currNode.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));