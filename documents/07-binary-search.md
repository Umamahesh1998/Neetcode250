# Binary Search Pattern — Revision Notes (Code + Examples)

## 1. What is the Pattern

Binary Search ante — sorted search space ni prathi step lo half chesukuntu target fast ga (O(log n)) kanukkune technique.

```java
int left = 0, right = arr.length - 1;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) left = mid + 1;
    else right = mid - 1;
}
```

## 2. Variants — Code + Example

### Variant 1: Classic Binary Search

Sorted array lo, oka exact value ni kanukkovadam — mid point teesukuni, target chinnadha/peddadha ani chusi search space ni half chesukuntham.

```java
// Example: Binary Search
public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}
```

**Trace: [-1,0,3,5,9,12], target=9**
```
left=0, right=5
mid=2(val=3): 3<9 → left=3
mid=4(val=9): 9==9 → FOUND at index 4
```

Problems: Binary Search, Search Insert Position

---

### Variant 2: Boundary Search (First/Last Occurrence)

Target multiple times array lo unte, first occurrence leda last occurrence kanukkovadam — match dorikina tarwata aagakunda, first kavali ante inka left vaipu, last kavali ante inka right vaipu continue chestham.

```java
// Example: Find First and Last Position of Element in Sorted Array
public int[] searchRange(int[] nums, int target) {
    int first = findBound(nums, target, true);
    int last = findBound(nums, target, false);
    return new int[]{first, last};
}
private int findBound(int[] nums, int target, boolean findFirst) {
    int left = 0, right = nums.length - 1, result = -1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            result = mid;
            if (findFirst) right = mid - 1;
            else left = mid + 1;
        } else if (nums[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return result;
}
```

**Trace: [5,7,7,8,8,10], target=8**
```
Find FIRST:
left=0,right=5, mid=2(7): 7<8 → left=3
left=3,right=5, mid=4(8): match! result=4, right=3
left=3,right=3, mid=3(8): match! result=3, right=2
loop ends → first=3

Find LAST:
left=0,right=5, mid=2(7): 7<8 → left=3
left=3,right=5, mid=4(8): match! result=4, left=5
left=5,right=5, mid=5(10): 10>8 → right=4
loop ends → last=4

Result: [3,4]
```

Problems: Find First and Last Position of Element in Sorted Array

---

### Variant 3: Search in Rotated Sorted Array

Array sorted undi, kani rotate cheyabadindi (oka point daggara "break" avutundi) — normal binary search direct ga apply cheyalem, mundu "e half sorted ga undo" identify cheyali, tarwata target aa sorted half lo unda ani check chesi decide cheyali.

```java
// Example: Search in Rotated Sorted Array
public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;

        if (nums[left] <= nums[mid]) { // left half sorted
            if (nums[left] <= target && target < nums[mid]) right = mid - 1;
            else left = mid + 1;
        } else { // right half sorted
            if (nums[mid] < target && target <= nums[right]) left = mid + 1;
            else right = mid - 1;
        }
    }
    return -1;
}
```

**Trace: [4,5,6,7,0,1,2], target=0**
```
left=0,right=6, mid=3(7): nums[0]=4<=7 → left sorted
  0 between 4 and 7? No → search right → left=4
left=4,right=6, mid=5(1): nums[4]=0<=1 → left sorted
  0 between 0 and 1? Yes → search left → right=4
left=4,right=4, mid=4(0): 0==0 → FOUND at index 4
```

Problems: Search in Rotated Sorted Array, Find Minimum in Rotated Sorted Array

---

### Variant 4: Binary Search on Answer (Search Space is NOT the array)

Idi chala important mariyu tricky variant — ikkada array meedha search cheyamu, "possible answers" range meedha search chestham. "Ee answer valid ah kadha" ani check chese function rasi, aa function meedha binary search apply chestham.

```java
// Example: Koko Eating Bananas
public int minEatingSpeed(int[] piles, int h) {
    int left = 1, right = Arrays.stream(piles).max().getAsInt();
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (canFinish(piles, h, mid)) right = mid; // ee speed pani chestunda, thagginchi chudu
        else left = mid + 1;
    }
    return left;
}
private boolean canFinish(int[] piles, int h, int speed) {
    int hours = 0;
    for (int pile : piles) hours += Math.ceil((double) pile / speed);
    return hours <= h;
}
```

**Trace: piles=[3,6,7,11], h=8**
```
left=1, right=11 (max pile)

mid=6: hours = ceil(3/6)+ceil(6/6)+ceil(7/6)+ceil(11/6) = 1+1+2+2 = 6
       6<=8? YES → speed works, try slower → right=6

mid=3 (left=1,right=6): hours = 1+2+3+4 = 10. 10<=8? NO → left=4

mid=5 (left=4,right=6): hours = ceil(3/5)+ceil(6/5)+ceil(7/5)+ceil(11/5)
                        = 1+2+2+3 = 8. 8<=8? YES → right=5

mid=4 (left=4,right=5): hours = ceil(3/4)+ceil(6/4)+ceil(7/4)+ceil(11/4)
                        = 1+2+2+3 = 8. 8<=8? YES → right=4

left==right==4 → answer: minimum speed = 4
```

Problems: Koko Eating Bananas, Capacity To Ship Packages Within D Days, Split Array Largest Sum

---

### Variant 5: 2D Matrix Binary Search

Sorted matrix (rows, columns sorted) meedha binary search — matrix ni "flattened 1D array" la treat cheyachu (mid index ni row/col ki convert chesi), leda row-column ni prathyekamga handle cheyachu.

```java
// Example: Search a 2D Matrix
public boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix.length, cols = matrix[0].length;
    int left = 0, right = rows * cols - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        int midVal = matrix[mid / cols][mid % cols];
        if (midVal == target) return true;
        else if (midVal < target) left = mid + 1;
        else right = mid - 1;
    }
    return false;
}
```

**Trace: matrix=[[1,3,5],[7,9,11]], target=9**
```
rows=2, cols=3, left=0, right=5 (flattened to 1D of 6 elements)
mid=2 → row=2/3=0, col=2%3=2 → matrix[0][2]=5. 5<9 → left=3
mid=4 → row=4/3=1, col=4%3=1 → matrix[1][1]=9. 9==9 → FOUND
```

Problems: Search a 2D Matrix, Search a 2D Matrix II

---

### Variant 6: Binary Search with Multiple Arrays (Advanced)

Rendu (leda ekkuva) sorted arrays meedha binary search — chala tricky, mostly Hard problems. Chinna array meedha binary search chesi, "correct partition point" kanukkovadam core idea.

```java
// Concept: Median of Two Sorted Arrays — partition-based approach
// Binary search on the SMALLER array to find correct partition point
// such that left-half max <= right-half min across both arrays.
// Full implementation is complex — low priority now, revisit later.
```

Problems: Median of Two Sorted Arrays

## 3. Trigger Points

- "Sorted array" + "find target" → Variant 1
- "First/last occurrence" → Variant 2
- "Rotated sorted array" → Variant 3
- "Minimum/maximum value satisfying a condition" → Variant 4 (chala miss ayye variant)
- "Sorted matrix" → Variant 5
- "Two sorted arrays" + "median" → Variant 6

## 4. Keywords to Watch For

sorted array | rotated sorted array | first and last position | minimize the maximum | maximize the minimum | koko eating bananas style | capacity to ship | sorted matrix | median of two arrays | O(log n)

## Quick Self-Test

"Naaku array index meedha search cheyala, leda 'answer' yokka possible range meedha search cheyala?" — index aithe 1-3/5, "answer range" aithe Variant 4.

## Summary Table

| # | Variant | Key Use Case |
|---|---|---|
| 1 | Classic Search | Exact target find |
| 2 | Boundary Search | First/last occurrence |
| 3 | Rotated Array | Search in rotated array |
| 4 | Search on Answer | Minimize/maximize condition |
| 5 | 2D Matrix | Sorted matrix search |
| 6 | Multi-array (advanced) | Median of two sorted arrays |
