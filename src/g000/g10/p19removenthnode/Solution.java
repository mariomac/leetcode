package g000.g10.p19removenthnode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode current = head;
		for(int i = 0 ; i < n-1 ; i++) {
			current = current.next;
		}
		ListNode toRemove = head;
		ListNode previous = null;
		while(current != null) {
			previous = toRemove;
			toRemove = toRemove.next;
			current = current.next;
		}
		if(previous == null) {
			return head.next;
		} else {
			previous.next = toRemove.next;
			return head;
		}

	}
}

/**
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.


 */
