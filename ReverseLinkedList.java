public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode returnHead = preHead;

        int swapOffset = n - m + 1, preReversePos = m;
        while(--preReversePos > 0) preHead = preHead.next;

        while(swapOffset-- > 0) {
            swapNode(preHead, swapOffset);
            preHead = preHead.next;
        }

        return returnHead.next;
    }

    private boolean swapNode(ListNode head, int num) {
        ListNode swapNode = head;
        while(num-- > 0) {
            if (swapNode.next != null)
                swapNode = swapNode.next;
            else return false;
        }

        ListNode swapFrom = swapNode.next;
        swapNode.next = swapFrom.next;

        swapFrom.next = head.next;
        head.next = swapFrom;
        return true;
    }
}

class ReverseLinkedListTest{
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);

        new ReverseLinkedList().reverseBetween(a, 2, 4);
    }
}