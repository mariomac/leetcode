package g000.g20.p25reversekgroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {

	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || head.next == null || k == 1) return head;
		ListNode pointer = head;

		boolean firstIteration = true;
		boolean nextGroupComplete = true;
		ListNode previousGroupHead = null;
		do {
			ListNode advancePointer = pointer;
			for(int i = 0 ; i < k - 1 && advancePointer != null ; i++) {
				advancePointer = advancePointer.next;
				if(advancePointer == null) {
					nextGroupComplete = false;
				}
			}
			if(nextGroupComplete) {
				ListNode groupHead = pointer;
				ListNode middle = pointer.next;
				ListNode previous = pointer;
				ListNode next = middle == null ? null : middle.next;
				for(int i = 0 ; i < k - 1 ; i++) {
					middle.next = previous;
					previous = middle;
					middle = next;
					next = next == null ? null : next.next;
				}
				if(firstIteration) {
					head = previous;
					firstIteration = false;
				}
				groupHead.next = middle;
				pointer = middle;
				if(previousGroupHead != null) {
					previousGroupHead.next = middle;
				}
				previousGroupHead = groupHead;
			}
		} while(nextGroupComplete && pointer != null);
		return head;


	}
}
