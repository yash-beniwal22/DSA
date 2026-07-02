class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode temp = head;
        ListNode grpNext = null;
        ListNode prevNode = null;
        while (temp != null) {
            ListNode kth = kthNode(temp, k);
            if (kth == null) {
                if (prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }
            grpNext = kth.next;
            kth.next = null;
            reverseList(temp);
            if (temp == head) {
                head = kth;
            } else {
                prevNode.next = kth;
            }
            prevNode = temp;
            temp = grpNext;
        }
        return head;
    }
    private ListNode kthNode(ListNode node, int k) {
        ListNode curr = node;
        k--;
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
    private ListNode reverseList(ListNode head) {
        ListNode ptr = head;
        ListNode prev = null;
        while (ptr != null) {
            ListNode next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
        }
        return prev;
    }
}  