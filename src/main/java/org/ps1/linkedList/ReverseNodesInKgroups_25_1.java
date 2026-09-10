package org.ps1.linkedList;

public class ReverseNodesInKgroups_25_1 {
    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        //create dummy
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            //find kth node
            ListNode kth = getKthNode(groupPrev, k);

            //check less than k nodes remaining
            if (kth == null)
                break;

            ListNode groupNext = kth.next;

            //reverse current group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            //after reversal
            ListNode oldGroupStart = groupPrev.next;
            groupPrev.next = kth;
            //old start become tail
            groupPrev = oldGroupStart;
        }
        return dummy.next;
    }

    ListNode getKthNode(ListNode listNode, int k) {
        while (listNode != null && k > 0) {
            listNode = listNode.next;
            k--;
        }
        return listNode;
    }
}
