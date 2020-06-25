public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int totalNum = 1;
        ListNode itNode = head;
        while (itNode.next != null) {
            totalNum++;
            itNode = itNode.next;
        }

        k = k % totalNum;

        while (k-- > 0) {
            itNode = head;
            while (itNode.next.next != null)
                itNode = itNode.next;
            itNode.next.next = head;
            head = itNode.next;
            itNode.next = null;
        }

        return head;
    }
}

class RotateListTest {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        System.out.println(new RotateList().rotateRight(list, 2));
    }
}
