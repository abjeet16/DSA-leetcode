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
    public ListNode insertionSortList(ListNode head) {
        ListNode t1 = head;
        while (t1 != null) {
            ListNode next = t1.next;
            ListNode t2 = head;
            ListNode prev = null;
            //System.out.println(next);
            //System.out.println(t1.val);
            while (t2 != null && t2 != t1 && t2.val < t1.val) {
                prev = t2;
                t2 = t2.next;
            }
            if (prev == null) {
                head = t1;
            } else {
                prev.next = t1;
            }
            if (t1 != t2)
                t1.next = t2;
            else{
                t1.next = null;
            }
            t1 = next;
        }
        //display(head);
        return head;
    }

    private void display(ListNode t1) {
        while (t1 != null) {
            ListNode next = t1.next;
            System.out.println(t1.val);
            t1 = next;
        }
    }
}