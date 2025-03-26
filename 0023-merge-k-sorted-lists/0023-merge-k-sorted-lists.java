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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ListNode list: lists){
            while(list != null){
                pq.add(list.val);
                list = list.next;
            }
        }
        if(pq.isEmpty()) return null;
        
        ListNode head = new ListNode(pq.poll());
        ListNode temp = head;
        while(!pq.isEmpty()){
            ListNode node = new ListNode(pq.poll());
            temp.next = node;
            temp = node;
        }
        return head;
    }
}