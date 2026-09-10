# Sorting Algorithms — Revision Notes (Brief + Code + Examples)

## 1. What is the Pattern

Sorting ante — array ni order lo arrange cheyadam. Interview lo direct ga ("implement quicksort") leda indirect ga (bigger problem lo oka step ga) vastundi.

Sample array used in examples: **[5, 2, 8, 1, 9]**

## 2. Variants — Brief + Code + Example

### Variant 1: Bubble Sort

Adjacent elements ni repeatedly compare chesi swap cheyadam — largest element prathi pass lo "bubble up" avutundi to the end. Simplest kani slowest.

```java
public void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        boolean swapped = false;
        for (int j = 0; j < n - 1 - i; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
            }
        }
        if (!swapped) break; // already sorted, early exit
    }
}
```

**Trace on [5,2,8,1,9]:**
```
Pass 1: (5,2)swap→[2,5,8,1,9]; (5,8)no; (8,1)swap→[2,5,1,8,9]; (8,9)no
End pass 1: [2,5,1,8,9], largest(9) bubbled to end
Pass 2: (2,5)no; (5,1)swap→[2,1,5,8,9]; (5,8)no
End pass 2: [2,1,5,8,9]
Pass 3: (2,1)swap→[1,2,5,8,9]; (2,5)no
No swaps in pass 3 further → sorted: [1,2,5,8,9]
```
Time: O(n^2) | Space: O(1) | Stable: Yes

---

### Variant 2: Selection Sort

Prathi pass lo, remaining unsorted part nunchi minimum element ni vetiki, front ki teskuni vastham — swap chesi front position ki pettadam.

```java
public void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        int minIdx = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIdx]) minIdx = j;
        }
        int temp = arr[i];
        arr[i] = arr[minIdx];
        arr[minIdx] = temp;
    }
}
```

**Trace on [5,2,8,1,9]:**
```
Pass 1: min in [5,2,8,1,9]=1(idx3) → swap with idx0 → [1,2,8,5,9]
Pass 2: min in [2,8,5,9](from idx1)=2(idx1, already there) → no swap
Pass 3: min in [8,5,9](from idx2)=5(idx3) → swap with idx2 → [1,2,5,8,9]
Pass 4: min in [8,9]=8(already there) → no swap
Sorted: [1,2,5,8,9]
```
Time: O(n^2) | Space: O(1) | Stable: No

---

### Variant 3: Insertion Sort

Card game la — prathi element ni teesukuni, already-sorted left part lo correct position lo insert cheyadam, shifting larger elements right ki.

```java
public void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}
```

**Trace on [5,2,8,1,9]:**
```
Start: [5 | 2,8,1,9]
Insert 2: 2<5 → shift → [2,5 | 8,1,9]
Insert 8: 8>5 → stays → [2,5,8 | 1,9]
Insert 1: 1<8,1<5,1<2 → shift all → [1,2,5,8 | 9]
Insert 9: 9>8 → stays → [1,2,5,8,9] — sorted
```
Time: O(n^2) worst, O(n) best (nearly sorted) | Space: O(1) | Stable: Yes

---

### Variant 4: Merge Sort

Divide & Conquer — array ni half-half ga split chesi, prathi half ni recursively sort chesi, tarwata rendu sorted halves ni merge cheyadam (compare chesi chinna element ni ముందు pick chestu).

```java
public void mergeSort(int[] arr, int left, int right) {
    if (left >= right) return;
    int mid = left + (right - left) / 2;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);
    merge(arr, left, mid, right);
}

private void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left, j = mid + 1, k = 0;
    while (i <= mid && j <= right) {
        temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
    }
    while (i <= mid) temp[k++] = arr[i++];
    while (j <= right) temp[k++] = arr[j++];
    System.arraycopy(temp, 0, arr, left, temp.length);
}
```

**Trace on [5,2,8,1,9]:**
```
Split: [5,2,8,1,9] → [5,2] and [8,1,9]
  [5,2] → [5],[2] → merge → [2,5]
  [8,1,9] → [8],[1,9] → [1,9]→[1],[9]→merge→[1,9]
            merge [8] and [1,9] → [1,8,9]
Final merge: [2,5] and [1,8,9]
  compare 2,1→1; compare 2,8→2; compare 5,8→5; remaining 8,9
  → [1,2,5,8,9]
```
Time: O(n log n) all cases | Space: O(n) | Stable: Yes

---

### Variant 5: Quick Sort

Divide & Conquer — oka "pivot" teesukuni, chinna elements left ki, pedda elements right ki partition chesi, recursively rendu halves ni sort cheyadam.

```java
public void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

private int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
        }
    }
    int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
    return i + 1;
}
```

**Trace on [5,2,8,1,9], pivot = last element (9):**
```
partition([5,2,8,1,9], pivot=9):
  all of 5,2,8,1 < 9 → i moves through all, swaps with self
  swap(4,4) → pivot(9) in place, pivot index=4 → [5,2,8,1 | 9]

Recurse left [5,2,8,1], pivot=1:
  none of 5,2,8 < 1 → swap(0,3) → [1,2,8,5], pivot index=0 → [1 | 2,8,5]

Recurse [2,8,5], pivot=5:
  2<5 → i=0,swap(0,0); 8>5→no swap
  swap(1,2) → [2,5,8], pivot index=1

Final: [1,2,5,8,9]
```
Time: O(n log n) avg, O(n^2) worst | Space: O(log n) | Stable: No

**Quickselect variant (Kth Largest Element):**
```java
public int findKthLargest(int[] nums, int k) {
    int target = nums.length - k; // kth largest = (n-k)th smallest (0-indexed)
    int low = 0, high = nums.length - 1;
    while (true) {
        int pi = partition(nums, low, high);
        if (pi == target) return nums[pi];
        else if (pi < target) low = pi + 1;
        else high = pi - 1;
    }
}
```

**Trace: Kth Largest, k=2, on [5,2,8,1,9]:**
```
target = 5-2 = 3 (sorted-index 3)
partition around 9 → lands index 4. 4!=3 → high=3
partition [5,2,8,1] around 1 → lands index 0. 0!=3 → low=1
partition [2,8,5] around 5 → lands index 2... continue narrowing
until pivot index == 3 → answer = 8 (2nd largest ✓)
```

---

### Variant 6: Heap Sort

Array nunchi max-heap build chesi (heapify), tarwata repeatedly max element (root) ni extract chesi array end ki pettadam, heap size తగ్గిస్తు.

```java
public void heapSort(int[] arr) {
    int n = arr.length;
    for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
    for (int i = n - 1; i > 0; i--) {
        int temp = arr[0]; arr[0] = arr[i]; arr[i] = temp;
        heapify(arr, i, 0);
    }
}

private void heapify(int[] arr, int n, int i) {
    int largest = i, left = 2 * i + 1, right = 2 * i + 2;
    if (left < n && arr[left] > arr[largest]) largest = left;
    if (right < n && arr[right] > arr[largest]) largest = right;
    if (largest != i) {
        int temp = arr[i]; arr[i] = arr[largest]; arr[largest] = temp;
        heapify(arr, n, largest);
    }
}
```

**Trace on [5,2,8,1,9]:**
```
Build max-heap:
  heapify(1): node=2(idx1), children 1(idx3),9(idx4) → largest=9 → swap → [5,9,8,1,2]
  heapify(0): node=5, children 9(idx1),8(idx2) → largest=9 → swap → [9,5,8,1,2]
              recurse heapify(1): node=5,left=1,right=2 → largest=5 → no change
  Max-heap: [9,5,8,1,2]

Extract max repeatedly:
  swap(0,4)→[2,5,8,1,9]→heapify(0) on [2,5,8,1]→largest=8→[8,5,2,1]+9
  swap(0,3)→[1,5,2,8,9]→heapify(0) on [1,5,2]→largest=5→[5,1,2]+8,9
  swap(0,2)→[2,1,5,8,9]→heapify(0) on [2,1]→largest=2→no change
  swap(0,1)→[1,2,5,8,9]→ sorted!
```
Time: O(n log n) all cases | Space: O(1) | Stable: No

---

### Variant 7: Counting Sort

Comparison-based kadu — element range chinnaga unte (e.g., 0-100), count array vadi, prathi value entisarlu vachindo count chesi, order lo output chestham. Range తెలిసినప్పుడు మాత్రమే వాడాలి.

```java
public void countingSort(int[] arr, int maxVal) {
    int[] count = new int[maxVal + 1];
    for (int num : arr) count[num]++;
    int idx = 0;
    for (int i = 0; i <= maxVal; i++) {
        while (count[i]-- > 0) arr[idx++] = i;
    }
}
```

**Trace on [5,2,8,1,9], range 0-9:**
```
count array (size 10):
index:  0 1 2 3 4 5 6 7 8 9
count: [0,1,1,0,0,1,0,0,1,1]

Read in order, output each index count[i] times:
i=1(count1)→output 1; i=2(count1)→output 2; i=5(count1)→output 5
i=8(count1)→output 8; i=9(count1)→output 9

Result: [1,2,5,8,9]
```
Time: O(n+k) | Space: O(k) | Stable: Yes (with careful implementation)

## 3. Trigger Points

- "Sort an array" direct ga → Merge Sort or Quick Sort
- "Kth largest/smallest" → Quickselect or Heap
- "Implement sorting from scratch" → explain Merge Sort (stable) or Quick Sort (in-place)
- Range/constraint chinnaga undi → Counting Sort
- "Nearly sorted array" → Insertion Sort
- Linked List sort cheyali → Merge Sort (no random access needed)
- "Stable sort kavali" → Merge Sort or Insertion Sort

## 4. Keywords to Watch For

sort an array | kth largest | kth smallest | quickselect | stable sort | in-place sort | divide and conquer | nearly sorted | counting sort range

## Summary Table

| Algorithm | Time (Avg) | Time (Worst) | Space | Stable |
|---|---|---|---|---|
| Bubble Sort | O(n^2) | O(n^2) | O(1) | Yes |
| Selection Sort | O(n^2) | O(n^2) | O(1) | No |
| Insertion Sort | O(n^2) | O(n^2) | O(1) | Yes |
| Merge Sort | O(n log n) | O(n log n) | O(n) | Yes |
| Quick Sort | O(n log n) | O(n^2) | O(log n) | No |
| Heap Sort | O(n log n) | O(n log n) | O(1) | No |
| Counting Sort | O(n+k) | O(n+k) | O(k) | Yes |

## Priority to Learn

1. **Merge Sort + Quick Sort (Quickselect)** — highest priority
2. **Heap Sort** — concept level, connects to Heap pattern
3. Bubble/Selection/Insertion/Counting — concept level chalu
