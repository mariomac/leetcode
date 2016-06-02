package g000.g10.p19removenthnode;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode preHead = new ListNode(0);
		preHead.next = head;
		ListNode tail = head;
		for(int i = 0 ; i < n - 1 ; i++) {
			tail = tail.next;
		}
		ListNode toRemove = head;
		ListNode previous = preHead;
		while(tail.next != null) {
			toRemove = toRemove.next;
			previous = previous.next;
			tail = tail.next;
		}

		if(toRemove == tail) {
			previous.next = null;
		} else {
			previous.next = toRemove.next;
		}
		return preHead.next;
	}
}
