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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next==null)return head;
        ListNode ls = null;
        ListNode rs = null;
        ListNode temp = head;
        int count = 1;
        while(count<left){
            ls = temp;
            temp = temp.next;
            count++;
        }
        ListNode start = temp;
        ListNode prev = null;
        while(count<=right){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
            count++;
        }
        if(ls!=null)ls.next=prev;
        start.next = temp;
        if(left==1)return prev;
        return head;
    }
}