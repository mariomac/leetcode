package g000.g20.p24swapnodes;

/**
 * Created by mmacias on 13/6/16.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pointer = head;
        ListNode previous = null;
        while(pointer != null && pointer.next != null) {
            ListNode first = pointer;
            ListNode second = pointer.next;
            pointer = pointer.next.next;

            if(previous != null) {
                previous.next = second;
            } else {
                head = second;
            }
            first.next = pointer;
            second.next = first;

            // for the next iteration
            previous = first;

        }
        if(pointer != null && previous != null) {
            previous.next = pointer;
        }
        return head;


    }
}
