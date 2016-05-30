package g000.g20.p23mergeksortedlists;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		// otra tecnica mejor: ordenar las listas y sacar siempre del primero, actualizando el orden
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
