  # Sliding Window Pattern — Revision Notes (Code + Examples)

## 1. What is the Pattern

Sliding Window ante — oka "window" (contiguous range) maintain chesi, expand/shrink/slide chestu problem solve cheyadam. Prathi possible subarray check chesthe O(n^2), Sliding Window tho O(n).

```java
int left = 0;
for (int right = 0; right < arr.length; right++) {
    // add arr[right] to window
    while (/* invalid */) { left++; }
    // process window
}
```

## 2. Variants — Code + Example

### Variant 1: Fixed Size Window

Window size (k) constant ga untundi — modatlo first k elements tho window build chesi, tarwata prathi step lo oka element add chesi, oka element remove chestham (window slide avutundi, size marchakunda).

```java
// Example: Max Sum Subarray of Size K
public int maxSumSubarray(int[] arr, int k) {
    int windowSum = 0;
    for (int i = 0; i < k; i++) windowSum += arr[i];
    int maxSum = windowSum;
    for (int right = k; right < arr.length; right++) {
        windowSum += arr[right] - arr[right - k];
        maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;
}
```

**Trace: [2,1,5,1,3,2], k=3**
```
Initial window [2,1,5] → sum=8, maxSum=8
Slide: remove 2, add 1 → [1,5,1] → sum=8-2+1=7, maxSum=8
Slide: remove 1, add 3 → [5,1,3] → sum=7-1+3=9, maxSum=9
Slide: remove 5, add 2 → [1,3,2] → sum=9-5+2=6, maxSum=9
Answer: 9
```

Problems: Maximum Sum Subarray of Size K, Sliding Window Maximum, Contains Duplicate II, Find K Closest Elements

---

### Variant 2: Variable Size Window (Expand & Shrink)

Window size fixed kadu — condition batti expand avutundi (right pointer move chestu window growth), condition break ayithe shrink avutundi (left pointer move chestu invalid elements remove).

```java
// Example: Longest Substring Without Repeating Characters
public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int left = 0, maxLen = 0;
    for (int right = 0; right < s.length(); right++) {
        while (set.contains(s.charAt(right))) {
            set.remove(s.charAt(left));
            left++;
        }
        set.add(s.charAt(right));
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
```

**Trace: "abcabcbb"**
```
left=0, set={}
right=0(a): not in set → add → set={a}, len=1
right=1(b): not in set → add → set={a,b}, len=2
right=2(c): not in set → add → set={a,b,c}, len=3, maxLen=3
right=3(a): a in set → shrink: remove s[left]=a, left=1 → set={b,c}
            add a → set={b,c,a}, len=3
right=4(b): b in set → shrink: remove s[left]=b, left=2 → set={c,a}
            add b → set={c,a,b}, len=3
... continues, maxLen stays 3
```

Problems: Longest Substring Without Repeating Characters, Minimum Window Substring, Longest Repeating Character Replacement, Fruit Into Baskets, Minimum Size Subarray Sum

---

### Variant 3: Window with Frequency Map / HashMap tracking

Window lopala unna elements ni HashMap tho count/frequency track chestham — window validity simple condition meedha kadu, character-frequency comparison meedha depend avutundi (anagram/permutation match check ki).

```java
// Example: Find All Anagrams in a String
public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    Map<Character, Integer> need = new HashMap<>();
    for (char c : p.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);
    Map<Character, Integer> window = new HashMap<>();
    int left = 0, matched = 0;

    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        window.put(c, window.getOrDefault(c, 0) + 1);
        if (window.get(c).equals(need.get(c))) matched++;

        if (right - left + 1 > p.length()) {
            char lc = s.charAt(left);
            if (window.get(lc).equals(need.get(lc))) matched--;
            window.put(lc, window.get(lc) - 1);
            left++;
        }
        if (matched == need.size()) result.add(left);
    }
    return result;
}
```

**Trace: s="cbaebabacd", p="abc"**
```
need = {a:1, b:1, c:1}
window grows to size 3 (p.length):
"cba" (idx 0-2) → window matches need! → index 0 added
slide: remove 'c', add 'e' → "bae" → doesn't match
slide: remove 'b', add 'b' → "aeb" → doesn't match
... continues
"bac" (idx 6-8) → matches → index 6 added
Result: [0, 6]
```

Problems: Find All Anagrams in a String, Permutation in String, Minimum Window Substring (advanced)

---

### Variant 4: Monotonic Deque (Advanced)

Window lopala max/min efficiently track cheyadaniki simple variable saripodu — Deque (monotonic queue, decreasing/increasing order lo maintain chestham) vadi, window slide ayye kొద్దీ max/min O(1) amortized lo update avutundi.

```java
// Example: Sliding Window Maximum
public int[] maxSlidingWindow(int[] arr, int k) {
    Deque<Integer> deque = new ArrayDeque<>(); // stores indices
    int[] result = new int[arr.length - k + 1];
    for (int i = 0; i < arr.length; i++) {
        while (!deque.isEmpty() && deque.peekFirst() <= i - k) deque.pollFirst();
        while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) deque.pollLast();
        deque.offerLast(i);
        if (i >= k - 1) result[i - k + 1] = arr[deque.peekFirst()];
    }
    return result;
}
```

**Trace: [1,3,-1,-3,5,3,6,7], k=3**
```
i=0(1): deque=[0]
i=1(3): 1<3, pop 0 → deque=[1]
i=2(-1): deque=[1,2] → window[0..2] max=arr[1]=3
i=3(-3): deque=[1,2,3] → window[1..3] max=arr[1]=3
i=4(5): pop 3,2,1 (all <5) → deque=[4] → window[2..4] max=5
i=5(3): deque=[4,5] → window[3..5] max=5
i=6(6): pop 5,4 → deque=[6] → window[4..6] max=6
i=7(7): pop 6 → deque=[7] → window[5..7] max=7
Result: [3,3,5,5,6,7]
```

Problems: Sliding Window Maximum, Shortest Subarray with Sum at Least K

## 3. Trigger Points

- "Subarray/substring" word vastundi
- Fixed size k prastavinchabadindi
- "Longest/shortest" + condition
- "Contiguous" word vastundi
- Character frequency/count based (anagram, permutation)
- Brute force O(n^2)/O(n^3), optimize to O(n)

## 4. Keywords to Watch For

subarray | substring | contiguous | window of size k | longest without repeating | anagram | permutation in string | O(n)

## Two Pointer vs Sliding Window

- Two Pointer — individual elements compare (pair, triplet).
- Sliding Window — range lopala elements collectively (sum, count, frequency) track.

## Summary Table

| # | Variant | Key Use Case |
|---|---|---|
| 1 | Fixed Size | Max/min sum of size-k subarray |
| 2 | Variable Size | Longest/shortest with condition |
| 3 | Frequency Map | Anagram, permutation matching |
| 4 | Monotonic Deque | Sliding window maximum |
