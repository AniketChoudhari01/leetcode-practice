/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private ListNode globalHead;
    private TreeNode buildBST(int len){
        if(len <= 0 || globalHead == null) return null;
        TreeNode leftSubtree = buildBST(len/2);
        TreeNode root = new TreeNode(globalHead.val);
        root.left = leftSubtree;
        globalHead = globalHead.next;
        root.right = buildBST(len - len/2 -1);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        //Using recursion 
        //step 1: traverse sll to find len
        int n = 1;
        ListNode curr = head;
        while(curr.next != null){
            n++;
            curr = curr.next;
        }
        // System.out.println(n);
        //using recursion to create a bst
        globalHead = head;
        return buildBST(n);
    }
}