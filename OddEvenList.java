public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddHead = head, evenHead = head.next;
        ListNode tmp = head, evenTmp = evenHead, iter = evenHead.next;
        while (iter != null && iter.next != null){
            oddHead.next = iter;
            oddHead = oddHead.next;
            iter = iter.next;
            evenHead.next = iter;
            evenHead = evenHead.next;
            iter = iter.next;
        }
        if (iter != null) {
            oddHead.next = iter;
            oddHead = oddHead.next;
            iter = iter.next;
        }
        evenHead.next = null;
        oddHead.next = evenTmp;
        return tmp;
    }

    public static void main(String[] args){
        ListNode oddEvenList = ListNode.constructLinkedList(new int[]{1,2,3,4,5,6,7});
        System.out.println(new OddEvenList().oddEvenList(oddEvenList));
    }
}