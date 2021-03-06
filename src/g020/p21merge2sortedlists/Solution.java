package g000.g20.p21merge2sortedlists;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode head;
		if(l1.val < l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}
		ListNode pointer = head;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				pointer.next = l1;
				l1 = l1.next;
			} else {
				pointer.next = l2;
				l2 = l2.next;
			}
			pointer = pointer.next;
		}
		ListNode tail = l1 == null ? l2 : l1;
		pointer.next = tail;
		return head;
	}
}
