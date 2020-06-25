public class IntersectedLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        if (headA == headB) return headA;
        ListNode fast = headB;
        ListNode slow = headB;
        while (fast.next != null) fast = fast.next;
        ListNode end = fast;
        end.next = headA;
        fast = headB;
        while (true) {
            if (fast.next == null || fast.next.next == null) {
                end.next = null;
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = headB;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        end.next = null;
        return fast;
    }

    public static void main(String[] args) {
        int[] list1 = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] list2 = new int[]{2};
        ListNode nodeA = ListNode.constructLinkedList(list1);
        ListNode nodeB = ListNode.constructLinkedList(list2);
        nodeB.next = nodeA;
        System.out.println(new IntersectedLinkedList().getIntersectionNode(nodeA, nodeB));
    }
}
