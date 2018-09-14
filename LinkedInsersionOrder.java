public class LinkedInsersionOrder {
    public ListNode insertionSortList(ListNode head) {
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = head;

        ListNode iterNode = head.next; //First unordered Node
        ListNode beforeIter = head; //Be careful when inserting;
        while(iterNode != null){
            ListNode orderedNode = pre;
            while (orderedNode.next.val < iterNode.val) {
                orderedNode = orderedNode.next;
            }
            if(orderedNode == beforeIter){
                beforeIter = iterNode;
                iterNode = iterNode.next;
                continue;
            }
            insert(orderedNode, beforeIter);
            iterNode = beforeIter.next;

        }
        return pre.next;
    }

    private boolean insert(ListNode insertAfter, ListNode takeAfter) {
        if(takeAfter == null || takeAfter.next == null) return false;
        if(insertAfter == null || insertAfter.next == null) return false;

        ListNode take = takeAfter.next;
        takeAfter.next = take.next;

        take.next = insertAfter.next;
        insertAfter.next = take;

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);

        LinkedInsersionOrder linkedInsersionOrder = new LinkedInsersionOrder();
        System.out.println(linkedInsersionOrder.insertionSortList(head));
    }
}
