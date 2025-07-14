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
class Solution {
    public int getDecimalValue(ListNode head) {
        int n =  0;
        StringBuilder sb = new StringBuilder();
        while(head != null){
            sb.append(head.val);
            head = head.next;
            n++;
        }
        int res = 0;
        for(int i=0; i<n; i++){
            char ch = sb.charAt(i);
            if(ch == '1'){
                res += Math.pow(2, n-1-i);
            }
        }
        // System.out.println(sb.toString());
        return res;
    }
}