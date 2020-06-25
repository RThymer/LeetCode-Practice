public class DeleteDuplicateElement {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode arrange = new ListNode(0), tmp = arrange, iter = head;
        arrange.next = head;
        boolean dulplicated = false;
        while (iter != null) {
            if (iter.next != null && iter.val == iter.next.val) {
                iter = iter.next;
                dulplicated = true;
            } else if (dulplicated) {
                arrange.next = iter.next;
                iter = iter.next;
                dulplicated = false;
            } else {
                arrange.next = iter;
                arrange = arrange.next;
                iter = iter.next;
                dulplicated = false;
            }
        }
        return tmp.next;
    }
}

class DeleteDuplicateElementTest {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(3);
        a.next.next.next.next = new ListNode(4);
        a.next.next.next.next.next = new ListNode(4);
        a.next.next.next.next.next.next = new ListNode(5);

        System.out.println(new DeleteDuplicateElement().deleteDuplicates(a));

    }
}
