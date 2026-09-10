package org.ps1.twopointer;

class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2() {
    }

    ListNode2(int val) {
        this.val = val;
    }

    ListNode2(int val, ListNode2 next) {
        this.val = val;
        this.next = next;
    }
}

public class RemoveNthNodeFromEndofList_19_3 {
    public static void main(String[] args) {

    }

    public ListNode2 removeNthFromEnd(ListNode2 head, int n) {
        ListNode2 dummy = new ListNode2(0);
        dummy.next = head;
        ListNode2 slow = dummy;
        ListNode2 fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
