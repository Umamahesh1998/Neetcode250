# Linked List Pattern — Revision Notes (Code + Examples)

## 1. What is the Pattern

Linked List ante — nodes connected structure, prathi node lo data + next pointer. Patterns anni pointer manipulation meedha base avutayi.

```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
```

## 2. Variants — Code + Example

### Variant 1: Reversal (Full or Partial)

3 pointers (prev, curr, next) vadi list reverse cheyadam — prathi node ki next pointer ni "backward" ga point cheyinchi, prev/curr/next ni oka step munduku move chestham.

```java
// Example: Reverse Linked List
public ListNode reverseList(ListNode head) {
    ListNode prev = null, curr = head;
    while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}
```

**Trace: 1→2→3→null**
```
prev=null, curr=1
Step1: next=2. curr.next=prev(null) → 1→null. prev=1, curr=2
Step2: next=3. curr.next=prev(1) → 2→1→null. prev=2, curr=3
Step3: next=null. curr.next=prev(2) → 3→2→1→null. prev=3, curr=null
curr==null → stop. return prev(3)
Result: 3→2→1→null
```

Problems: Reverse Linked List, Reverse Linked List II, Reverse Nodes in k-Group, Swap Nodes in Pairs

---

### Variant 2: Fast & Slow Pointers

Slow 1 step, fast 2 steps move avutayi — fast end ki cheraga slow exact middle lo untundi; fast slow ni catch ayithe cycle undi ani ardham. (Two Pointer notes lo Variant 2 tho same technique, Linked List context lo repeat.)

```java
// Example: Find Middle of Linked List
public ListNode middleNode(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
```

**Trace: 1→2→3→4→5**
```
slow=1, fast=1
Step1: slow=2, fast=3
Step2: slow=3, fast=5
fast.next==null → stop. Middle = slow = 3
```

Problems: Linked List Cycle, Middle of the Linked List, Palindrome Linked List

---

### Variant 3: Merging / Combining Lists

Rendu (leda multiple) sorted linked lists ni okkati ga combine cheyadam — dummy node nunchi start chesi, chinna value unna node ni pick chesi link chestu munduku potham.

```java
// Example: Merge Two Sorted Lists
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) { curr.next = l1; l1 = l1.next; }
        else { curr.next = l2; l2 = l2.next; }
        curr = curr.next;
    }
    curr.next = (l1 != null) ? l1 : l2;
    return dummy.next;
}
```

**Trace: l1=1→3→5, l2=2→4→6**
```
l1=1,l2=2: 1<2 → curr.next=1, l1=3
l1=3,l2=2: 3>2 → curr.next=2, l2=4
l1=3,l2=4: 3<4 → curr.next=3, l1=5
l1=5,l2=4: 5>4 → curr.next=4, l2=6
l1=5,l2=6: 5<6 → curr.next=5, l1=null
l1 null → curr.next=l2(6)
Result: 1→2→3→4→5→6
```

Problems: Merge Two Sorted Lists, Merge k Sorted Lists, Sort List

---

### Variant 4: Dummy Node Technique

List ni modify cheyalsi vachinappudu (especially head remove/change avvachu chance unnappudu), oka dummy node create chesi "fake head" la use chestham — idi empty-list/head-removal edge cases ni simplify chestundi.

```java
// Example: Remove Nth Node From End (using dummy node)
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy, second = dummy;
    for (int i = 0; i <= n; i++) first = first.next;
    while (first != null) {
        first = first.next;
        second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
}
```

**Trace: 1→2→3→4→5, n=2**
```
dummy→1→2→3→4→5, first=dummy, second=dummy
Move first (n+1=3) steps: first at node 3
Move together till first==null:
  first=4, second=1
  first=5, second=2
  first=null, second=3
second.next(4) is target → second.next = second.next.next(5)
Result: 1→2→3→5
```

Problems: Remove Nth Node From End of List, Add Two Numbers

---

### Variant 5: Cycle Manipulation (Find Cycle Start)

Fast & Slow (Variant 2) tho cycle detect chesaka, ee variant advanced ga cycle start point kuda kanukkuntundi — meeting point nunchi oka pointer ni head ki restart chesi, rendu pointers ni same speed lo move chesthe, e point lo kalustaro ade cycle start.

```java
// Example: Linked List Cycle II (find cycle start)
public ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            ListNode ptr = head;
            while (ptr != slow) {
                ptr = ptr.next;
                slow = slow.next;
            }
            return ptr;
        }
    }
    return null;
}
```

**Trace: 1→2→3→4→5→3 (cycle back to node value 3)**
```
Phase 1 (meeting point):
slow=1,fast=1 → slow=2,fast=3 → slow=3,fast=5 → slow=4,fast=4 → MEET at value 4

Phase 2 (find cycle start):
ptr=head(1), slow stays at 4
ptr=1,slow=4 → not equal → ptr=2,slow=5
ptr=2,slow=5 → not equal → ptr=3,slow=3
ptr==slow (both at value 3) → cycle starts at node 3
```

Problems: Linked List Cycle II, Happy Number

---

### Variant 6: Copy / Clone with Extra Pointers

Linked list ni clone cheyali, kani normal `next` tappa extra pointer (random pointer lanti) kuda untundi — HashMap vadi original-to-copy mapping track chesi, tarwata aa mapping use chesi copy nodes ni correctly link chestham.

```java
// Example: Copy List with Random Pointer
public Node copyRandomList(Node head) {
    Map<Node, Node> map = new HashMap<>();
    Node curr = head;
    while (curr != null) {
        map.put(curr, new Node(curr.val));
        curr = curr.next;
    }
    curr = head;
    while (curr != null) {
        map.get(curr).next = map.get(curr.next);
        map.get(curr).random = map.get(curr.random);
        curr = curr.next;
    }
    return map.get(head);
}
```

**Trace: A(rand→C) → B(rand→A) → C(rand→B)**
```
Pass 1: map = {A:A', B:B', C:C'} (copies with just val)
Pass 2: link using map
  A'.next=map[B]=B', A'.random=map[C]=C'
  B'.next=map[C]=C', B'.random=map[A]=A'
  C'.next=null, C'.random=map[B]=B'
Result: cloned list A'→B'→C' with correct random pointers
```

Problems: Copy List with Random Pointer, Clone Graph

---

### Variant 7: Design (HashMap + Doubly Linked List)

Custom data structure design cheyali (O(1) get/put kavali) ante, Linked List ni internal building block ga vadatham — HashMap (fast lookup) + Doubly Linked List (fast insertion/deletion at both ends) combination.

```java
// Example: LRU Cache
class LRUCache {
    class Node { int key, val; Node prev, next; Node(int k,int v){key=k;val=v;} }
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(0,0), tail = new Node(0,0);
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail; tail.prev = head;
    }
    private void remove(Node node) {
        node.prev.next = node.next; node.next.prev = node.prev;
    }
    private void insertToFront(Node node) {
        node.next = head.next; node.prev = head;
        head.next.prev = node; head.next = node;
    }
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node); insertToFront(node);
        return node.val;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) remove(map.get(key));
        Node node = new Node(key, value);
        map.put(key, node);
        insertToFront(node);
        if (map.size() > capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
```

**Trace: capacity=2**
```
put(1,1): cache={1:1}, order(front→back): [1]
put(2,2): cache={1:1,2:2}, order: [2,1]
get(1): return 1, move 1 to front → order: [1,2]
put(3,3): capacity exceeded → evict LRU(2, at back)
          cache={1:1,3:3}, order: [3,1]
get(2): -1 (evicted)
```

Problems: LRU Cache, LFU Cache, Design Circular Queue

## 3. Trigger Points

- "Reverse" word direct ga vastundi
- "Cycle" undha ani adugutaru
- "Middle element" kavali
- "Merge" multiple lists
- Head remove/change avvachu chance undi
- "Random pointer" leda extra field tho clone
- "Design a data structure with O(1) get/put" — LRU/LFU

## 4. Keywords to Watch For

reverse linked list | cycle | middle node | merge sorted lists | remove nth node | random pointer | deep copy | LRU | LFU | k-group

## Important: Technique Transfer to Arrays

Fast & Slow (Variant 2/5) apply avutundi arrays ki kuda — **Find the Duplicate Number**: array values ni "next pointer" la treat chesi implicit linked list la cycle detect chestham.

## Summary Table

| # | Variant | Key Use Case |
|---|---|---|
| 1 | Reversal | Full/partial list reversal |
| 2 | Fast & Slow | Cycle detection, middle element |
| 3 | Merging | Merge sorted lists |
| 4 | Dummy Node | Simplify head-modification edge cases |
| 5 | Cycle Manipulation | Find cycle start point |
| 6 | Copy/Clone | Deep copy with extra pointers |
| 7 | Design | LRU Cache, LFU Cache |
