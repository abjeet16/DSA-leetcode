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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode rhead = null;
        ListNode res = null;
        ListNode curr = head;
        while(curr!=null){
            boolean un = true;
            ListNode temp = curr;
            curr = curr.next;
            while(curr!=null&&curr.val==temp.val){
                curr = curr.next;
                un=false;
            }
            if(un){
                if(rhead==null){
                    rhead = temp;
                    res = temp;
                }else{
                    res.next = temp;
                    res = temp;
                }
                res.next = null;
            }
        }
        return rhead;
    }
}