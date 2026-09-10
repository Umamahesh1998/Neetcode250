package org.ps1.twopointer;

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1() {
    }

    ListNode1(int val) {
        this.val = val;
    }

    ListNode1(int val, ListNode1 next) {
        this.val = val;
        this.next = next;
    }
}

public class MiddleOfLinkedList_876_2 {
    public static void main(String[] args) {

    }

    public ListNode1 middleNode(ListNode1 head) {
        ListNode1 slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
