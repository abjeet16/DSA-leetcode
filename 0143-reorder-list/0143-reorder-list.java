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
    ListNode start;
    int count = 0;
    public void reorderList(ListNode head) {
        start = head;
        find(head.next,1);
    }
    private void find(ListNode head,int i){
        if(head==null)
            return;
        find(head.next,i+1);
        if(i<=count){
            start.next=null;
            return;
        }
        ListNode next = start.next;
        start.next=head;
        count++;
        if(head!=next)head.next = next;
        start = next;
    }
}