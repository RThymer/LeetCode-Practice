public class ParadomLinkList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode rightHead = null;
        if (fast == null) {
            //Even
            rightHead = reverseLinkedList(slow);
        } else {
            //Odd
            rightHead = reverseLinkedList(slow);
        }

        while (head != null && rightHead != null) {
            if (head.val != rightHead.val) return false;
            else {
                head = head.next;
                rightHead = rightHead.next;
            }
        }
        return true;
    }

    private ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode save = null;

        while (head.next != null) {
            save = head.next;
            head.next = pre;
            pre = head;
            head = save;
        }
        head.next = pre;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        System.out.println(new ParadomLinkList().isPalindrome(head));
    }
}
