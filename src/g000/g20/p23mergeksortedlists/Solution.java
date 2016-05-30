package g000.g20.p23mergeksortedlists;

import java.util.*;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode preHead = new ListNode(0);
		ListNode current = preHead;
		while(l1 != null || l2 != null) {
			if(l1 == null || (l2 != null && l2.val < l1.val)) {
				current.next = l2;
				current = current.next;
				l2 = l2.next;
			} else {
				current.next = l1;
				current = current.next;
				l1 = l1.next;
			}
		}
		return preHead.next;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) return null;
		int length = lists.length;
		while(length > 1) {
			int dst = 0;
			for(int i = 0 ; i < length ; i+=2) {
				if(i == length - 1) {
					lists[dst] = lists[i];
				} else {
					lists[dst] = merge(lists[i],lists[i+1]);
				}
				dst++;
			}
			length = length / 2 + length % 2;
		}
		return lists[0];
	}
}
