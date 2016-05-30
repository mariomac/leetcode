import g000.g20.p23mergeksortedlists.*;
import g000.g20.p23mergeksortedlists.ListNode;

public class Main {

    public static void main(String[] args) {
		//[[-1,1],[-3,1,4],[-2,-1,0,2]]
		/*ListNode[] ln = {
				new ListNode(-1,new ListNode(1)),
				new ListNode(-3,new ListNode(1,new ListNode(4))),
				new ListNode(-2,new ListNode(-1,new ListNode(0,new ListNode(2))))
		};*/

		//[[-10,-9,-9,-3,-1,-1,0],[-5],[4],[-8],[],[-9,-6,-5,-4,-2,2,3],[-3,-3,-2,-1,0]]
		ListNode[] ln =  {
				new ListNode(-10,new ListNode(-9,new ListNode(-9,new ListNode(-3,new ListNode(-1,new ListNode(-1,new ListNode(0))))))),
				new ListNode(-5),
				new ListNode(4),
				null,
				new ListNode(-9,new ListNode(-6,new ListNode(-5,new ListNode(-4,new ListNode(-2,new ListNode(2,new ListNode(3))))))),
				new ListNode(-3,new ListNode(-3,new ListNode(-2,new ListNode(-1,new ListNode(0)))))
		};
        Solution s = new Solution();

		ListNode l = s.mergeKLists(ln);

		while(l != null) {
			System.out.print(l.val + " ");
			l = l.next;
		}
		System.out.println();



    }
}
