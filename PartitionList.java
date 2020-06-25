public class PartitionList {
    public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) return head;

        ListNode smallNodes = new ListNode(0), bigNodes = new ListNode(0), ret = new ListNode(0);
        ListNode smallIter = smallNodes, bigIter = bigNodes, returnHead = ret;
        ListNode iterNode = head;

        while (iterNode != null) {
            if (iterNode.val >= x) {
                bigIter.next = new ListNode(iterNode.val);
                bigIter = bigIter.next;
            } else {
                smallIter.next = new ListNode(iterNode.val);
                smallIter = smallIter.next;
            }
            iterNode = iterNode.next;
        }

        while (smallNodes.next != null) {
            ret.next = smallNodes.next;
            ret = ret.next;
            smallNodes = smallNodes.next;
        }
        while (bigNodes.next != null) {
            ret.next = bigNodes.next;
            ret = ret.next;
            bigNodes = bigNodes.next;
        }

        return returnHead.next;
    }
}

class PartitionListTest {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(2);
        a.next.next.next.next = new ListNode(5);
        a.next.next.next.next.next = new ListNode(2);

        System.out.println(new PartitionList().partition(a, 3));

    }
}