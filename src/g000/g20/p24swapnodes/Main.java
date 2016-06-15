package g000.g20.p24swapnodes;

public class Main {

    public static void main(String[] args) {
		Solution s = new Solution();
        ListNode ln = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4))));
        ln = s.swapPairs(ln);
        while(ln != null) {
            System.out.print(ln.val + " ");
            ln = ln.next;
        }
        System.out.println();
    }
}
