package org.ps1.linkedList;

public class ReorderList_143_2_1_3 {
    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        //identify the midpoint varient 2
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse the second half varient 1
        ListNode second = reverseList(slow.next);
        slow.next = null;
        //reorder the two lists varient 3
        ListNode first = head;
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
