package g000.g00.p2addtwonumbers;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode preHead = new ListNode(0); // this node will be excluded from the solution
        ListNode ptr = preHead;
        while (l1 != null && l2 != null) {
            int sum = (l1.val + l2.val + carry);
            ptr.next = new ListNode(sum % 10);
            ptr = ptr.next;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode rest = l1 == null ? l2 : l1;
        while (rest != null) {
            int sum = (rest.val + carry);
            ptr.next = new ListNode(sum % 10);
            ptr = ptr.next;
            carry = sum / 10;
            rest = rest.next;
        }
        if (carry != 0) {
            ptr.next = new ListNode(carry);
        }

        return preHead.next;
    }
}

