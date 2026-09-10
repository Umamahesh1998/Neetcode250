# Two Pointer Pattern — Revision Notes (Code + Examples)

## 1. What is the Pattern

Two Pointer ante — oka array/string meedha rendu indices (pointers) ni ekakalamlo move chestu problem solve chese technique. Brute force lo nested loops (O(n^2)) vadalsina chota, ee pattern vadithe O(n) leda O(n log n) ki tagginchavachu.

```java
int left = 0, right = arr.length - 1;
while (left < right) {
    left++;  // or right--; or both
}
```

## 2. Variants — Code + Example

### Variant 1: Opposite Direction (Converging Pointers)

Array/string rendu chivarla nunchi (left=0, right=n-1) modalai, condition batti madhyaki move avutayi, madhyalo kalisevaraku. Sorted array meedha pair/triplet sum kanukkovadaniki ide most common approach.

```java
// Example: Two Sum II (sorted array)
public int[] twoSum(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1;
    while (left < right) {
        int sum = numbers[left] + numbers[right];
        if (sum == target) return new int[]{left + 1, right + 1};
        else if (sum < target) left++;
        else right--;
    }
    return new int[]{-1, -1};
}
```

**Trace: [2,7,11,15], target=9**
```
left=0(2), right=3(15): sum=17 > 9 → right--
left=0(2), right=2(11): sum=13 > 9 → right--
left=0(2), right=1(7):  sum=9 == 9 → FOUND! return [1,2] (1-indexed)
```

Problems: Two Sum II, Valid Palindrome, Container With Most Water, 3Sum, 4Sum, Trapping Rain Water, Boats to Save People

---

### Variant 2: Fast & Slow Pointers (Runner Technique)

Rendu pointers okate direction lo move avutayi, kani vere speed lo — slow 1 step, fast 2 steps. Fast slow ni "catch" ayithe (rendu okka node meedha kalusukunte) cycle undi ani ardham; middle element kanukkovadaniki kuda ide technique — fast end ki cheraga slow exact middle lo untundi.

```java
// Example: Linked List Cycle Detection (Floyd's Algorithm)
public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true;
    }
    return false;
}
```

**Trace: List 1→2→3→4→2 (cycle back to node with value 2)**
```
slow=1, fast=1
Step 1: slow=2, fast=3
Step 2: slow=3, fast=2 (fast wrapped via cycle)
Step 3: slow=4, fast=4  → slow == fast → CYCLE DETECTED
```

Problems: Linked List Cycle, Middle of Linked List, Happy Number, Find the Duplicate Number

---

### Variant 3: Fixed Distance / Gap Between Pointers

Rendu pointers madhya oka fixed gap (n) maintain chestham — first pointer ni n steps mundu move chesi, tarwata rendu pointers okesari move avutayi. First end ki cheraga, second pointer "n-th from end" position lo untundi.

```java
// Example: Remove Nth Node From End of List
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

**Trace: List 1→2→3→4→5, n=2**
```
dummy→1→2→3→4→5, first=dummy, second=dummy
Move first (n+1=3) steps: first at node 3
Move both together till first==null:
  first=4, second=1
  first=5, second=2
  first=null, second=3
second.next(4) is target → second.next = second.next.next(5)
Result: 1→2→3→5
```

Problems: Remove Nth Node From End of List

---

### Variant 4: Merging Two Sorted Structures

Rendu (leda multiple) sorted arrays/lists ni okkokka pointer tho traverse chesi, chinna element ni pick chesi result build cheyadam — oka structure aipoyaka, migilina structure ni direct ga append cheyachu.

```java
// Example: Merge Two Sorted Arrays
public int[] merge(int[] arr1, int[] arr2) {
    int i = 0, j = 0, k = 0;
    int[] result = new int[arr1.length + arr2.length];
    while (i < arr1.length && j < arr2.length) {
        if (arr1[i] <= arr2[j]) result[k++] = arr1[i++];
        else result[k++] = arr2[j++];
    }
    while (i < arr1.length) result[k++] = arr1[i++];
    while (j < arr2.length) result[k++] = arr2[j++];
    return result;
}
```

**Trace: [1,3,5] and [2,4,6]**
```
i=0(1), j=0(2) → 1<2 → pick 1 → result=[1], i=1
i=1(3), j=0(2) → 3>2 → pick 2 → result=[1,2], j=1
i=1(3), j=1(4) → 3<4 → pick 3 → result=[1,2,3], i=2
i=2(5), j=1(4) → 5>4 → pick 4 → result=[1,2,3,4], j=2
i=2(5), j=2(6) → 5<6 → pick 5 → result=[1,2,3,4,5], i=3
i exhausted → append remaining j → result=[1,2,3,4,5,6]
```

Problems: Merge Sorted Array, Merge Two Sorted Lists, Intersection of Two Arrays

---

### Variant 5: Partitioning / In-place Rearrangement

Oka pointer (insertPos) valid elements ni track chestundi, inko pointer (i) full array ni traverse chestundi — condition satisfy chese elements ni front ki teskuni vastham, extra space vadakunda in-place ga.

```java
// Example: Move Zeroes to End
public void moveZeroes(int[] arr) {
    int insertPos = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] != 0) {
            arr[insertPos++] = arr[i];
        }
    }
    while (insertPos < arr.length) arr[insertPos++] = 0;
}
```

**Trace: [0,1,0,3,12]**
```
insertPos=0
i=0: arr[0]=0, skip
i=1: arr[1]=1 (nonzero) → arr[insertPos]=1 → arr=[1,1,0,3,12], insertPos=1
i=2: arr[2]=0, skip
i=3: arr[3]=3 (nonzero) → arr[insertPos]=3 → arr=[1,3,0,3,12], insertPos=2
i=4: arr[4]=12 → arr[insertPos]=12 → arr=[1,3,12,3,12], insertPos=3
Fill remaining (idx 3,4) with 0 → arr=[1,3,12,0,0]
```

Problems: Move Zeroes, Remove Element, Sort Colors, Remove Duplicates from Sorted Array

---

### Variant 6: Independent Comparison (Two Different Structures)

Rendu pointers rendu vere arrays/strings meedha independent ga move avutayi (compare chesi match ayithe ade pointer move, output combine kadu) — oka structure inko dhanilo "contained/matched" avutunda ani check cheyadaniki.

```java
// Example: Is Subsequence
public boolean isSubsequence(String s, String t) {
    int i = 0, j = 0;
    while (i < s.length() && j < t.length()) {
        if (s.charAt(i) == t.charAt(j)) i++;
        j++;
    }
    return i == s.length();
}
```

**Trace: s="abc", t="ahbgdc"**
```
i=0(a), j=0(a) → match → i=1, j=1
i=1(b), j=1(h) → no match → j=2
i=1(b), j=2(b) → match → i=2, j=3
i=2(c), j=3(g) → no match → j=4
i=2(c), j=4(d) → no match → j=5
i=2(c), j=5(c) → match → i=3, j=6
i == s.length(3) → TRUE
```

Problems: Is Subsequence, Backspace String Compare, Merge Strings Alternately

---

### Variant 7: Swap-based In-place Reversal

Compare/condition logic ledu — pure swap operation matrame. Left, right pointers converge avutu, prathi step lo elements ni swap chestham, array/string ni in-place ga reverse cheyadaniki.

```java
// Example: Reverse String / Array in-place
public void reverseString(char[] arr) {
    int left = 0, right = arr.length - 1;
    while (left < right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
    }
}
```

**Trace: ['h','e','l','l','o']**
```
left=0, right=4: swap → ['o','e','l','l','h'], left=1,right=3
left=1, right=3: swap → ['o','l','l','e','h'], left=2,right=2
left==right → stop → result: "olleh"
```

Problems: Reverse String, Rotate Array

---

### Variant 8: Meeting in the Middle (Advanced, rare)

Array ni rendu halves ga split chesi, prathi half ni independent ga process chesi (e.g., all possible sums), tarwata rendu results ni two-pointer tho combine cheyadam. Mostly Hard-level subset-sum type problems ki.

```java
// Concept only — split array into two halves, generate all subset sums
// for each half independently, then use two-pointer to find pairs
// matching a target across the two sorted sum-lists.
// Low priority — revisit in Month 2-3.
```

Problems: Closest Pair Sum from Two Arrays, 4Sum II

## 3. Trigger Points

- Array/String **sorted** ga undi
- **Pair/triplet** kanukkovali (sum, difference)
- **Palindrome** check cheyali
- Linked List **cycle/middle** kanukkovali
- **In-place** array modify cheyali, O(1) space
- **Two sorted structures merge** cheyali
- Brute force O(n^2) vachindi, optimize cheyali

## 4. Keywords to Watch For

sorted array | two sum | pair sum | palindrome | in-place | O(1) space | cycle detection | middle element | merge sorted | reverse | subsequence | contiguous pair

## Summary Table

| # | Variant | Key Use Case |
|---|---|---|
| 1 | Opposite Direction | Sorted array pair sum, palindrome |
| 2 | Fast & Slow | Cycle detection, middle element |
| 3 | Fixed Gap | Nth from end |
| 4 | Merging | Merge sorted arrays/lists |
| 5 | Partitioning | In-place rearrangement |
| 6 | Independent Comparison | Subsequence/match check |
| 7 | Swap-based Reversal | Reverse array/string |
| 8 | Meeting in the Middle | Subset sum optimization |
