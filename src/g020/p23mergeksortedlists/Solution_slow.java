package g000.g20.p23mergeksortedlists;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution_slow {

	// TODO: quicksort
	private void sort(ListNode[] lists) {
		Arrays.sort(lists, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
	}

	public ListNode mergeKLists(ListNode[] lists) {
		// otra tecnica mejor: ordenar las listas y sacar siempre del primero, actualizando el orden
		sort(lists);

		ListNode preHead = new ListNode(0);
		ListNode current = preHead;
		boolean finished = false;
		while(!finished) {
			ListNode lower = null;
			ListNode secondLower = null;
			int idx = 0, lowerIndex = 0;
			for(ListNode l : lists) {
				if(l != null && (lower == null || lower.val > l.val)) {
					secondLower = lower;
					lower = l;
					lowerIndex = idx;
				}
				idx++;
			}
			if(lower == null) {
				finished = true;
			} else {
				current.next = lower;
				current = current.next;
				// optimization: insert values from the same queue that are lower than the second lower
				for(ListNode l = lower.next ; secondLower != null && l != null && l.val <= secondLower.val ; l = l.next) {
					current = l;
				}
				lists[lowerIndex] = current.next;
			}
		}
		return preHead.next;
	}
}
