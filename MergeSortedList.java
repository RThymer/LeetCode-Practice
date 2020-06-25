public class MergeSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode results = new ListNode(0), headPtr = results;
        boolean isAllNull = true;
        do {
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    isAllNull = false;
                    break;
                }
            }
            ListNode currentMin = null;
            int smallestIndex = 0;
            int minTmp = Integer.MAX_VALUE;
            for (int index = 0; index < lists.length; index++) {
                if (lists[index] == null) continue;
                else if (lists[index].val < minTmp) {
                    minTmp = lists[index].val;
                    currentMin = lists[index];
                    smallestIndex = index;
                }
            }
            lists[smallestIndex] = lists[smallestIndex].next;
            results.next = currentMin;
            results = results.next;

            isAllNull = true;

        } while (!isAllNull);

        return headPtr.next;
    }
}

class MergeTest {
    public static void main(String[] args) {

        ListNode i = new ListNode(1);
        i.next = new ListNode(4);
        i.next.next = new ListNode(5);

        ListNode j = new ListNode(1);
        j.next = new ListNode(3);
        j.next.next = new ListNode(4);

        ListNode k = new ListNode(2);
        k.next = new ListNode(6);

        System.out.println(new MergeSortedList().mergeKLists(
                new ListNode[]{i, j, k}));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode constructLinkedList(int[] nodeVals) {
        if (nodeVals == null || nodeVals.length < 1) return null;
        ListNode head = new ListNode(nodeVals[0]);
        ListNode tmp = head;
        for (int i = 1; i < nodeVals.length; ++i) {
            tmp.next = new ListNode(nodeVals[i]);
            tmp = tmp.next;
        }
        return head;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode tmp = this;
        sb.append(this.val + " ");
        while (tmp.next != null) {
            tmp = tmp.next;
            sb.append(tmp.val + " ");
        }
        return sb.toString();
    }
}
