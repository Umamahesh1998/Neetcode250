package org.ps1.linkedList;

import java.util.PriorityQueue;

public class MergeKSortedList_23_3 {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        //add first node from everyList
        for (ListNode node : lists) {
            if (node != null)
                pq.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            //smallest current node
            ListNode node = pq.poll();
            //add to result
            current.next = node;
            current = current.next;
            //add next node from same list
            if (node.next != null)
                pq.offer(node.next);
        }
        return dummy.next;
    }
}
