public class SwapPair {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = new ListNode(0);
        ListNode helper = newHead;

        helper.next = head;
        ListNode pos1 = head;
        ListNode pos2 = head.next;
        while (pos2 != null && pos2.next != null && pos2.next.next != null) {
            pos1.next = pos2.next;
            pos2.next = pos1;
            helper.next = pos2;

            helper = pos1;
            pos1 = pos1.next;
            pos2 = pos1.next;
        }
        if (pos2 != null && (pos2.next == null) || (pos2.next.next == null)) {
            pos1.next = pos2.next;
            pos2.next = pos1;
            helper.next = pos2;
        }
        return newHead.next;
    }
}

class SwapPairTest {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(new SwapPair().swapPairs(head));
    }
}