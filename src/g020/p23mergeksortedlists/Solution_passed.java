package g000.g20.p23mergeksortedlists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution_passed {

	public ListNode mergeKLists(ListNode[] lists) {
		Arrays.sort(lists, (o1, o2) -> {
			if (o1 == null && o2 == null) return 0;
			else if (o1 == null) return 1;
			else if (o2 == null) return -1;
			return o1.val - o2.val;
		});
		LinkedList<ListNode> llists = new LinkedList<>();
		for (ListNode l : lists) {
			if (l != null) llists.add(l);
		}
		ListNode preHead = new ListNode(0);
		ListNode current = preHead;


		// insert lower node
		while (llists.size() > 0) {
			ListNode first = llists.pollFirst();
			ListNode second = llists.size() == 0 ? null : llists.getFirst();
			do {
				current.next = first;
				current = current.next;
				first = first.next;
			} while (first != null && (second == null || first.val <= second.val));
			if (first != null) {
				ListIterator<ListNode> it = llists.listIterator();
				boolean inserted = false;
				while (it.hasNext()) {
					ListNode n = it.next();
					if(n.val >= first.val) {
						it.set(first);
						it.add(n);
						inserted = true;
						break;
					}
				}
				if(!inserted) llists.addLast(first);
			}
		}
		return preHead.next;
	}
}
