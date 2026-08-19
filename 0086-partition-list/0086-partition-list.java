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
    public ListNode partition(ListNode head, int x) {
        ListNode h1 = null;
        ListNode h2 = null;
        ListNode left = null;
        ListNode right = null;
        while(head!=null){
            ListNode next = head.next;
            head.next=null;
            if(head.val<x){
                if(right != null){
                    right.next = head;
                }else{
                    h1 = head;
                }
                right = head;
            }else{
                if(left != null){
                    left.next = head;
                }else{
                    h2 = head;
                }
                left = head;
            }
            head = next;
        }
        if(right!=null)right.next=h2;
        return h1==null?h2:h1;
    }
}