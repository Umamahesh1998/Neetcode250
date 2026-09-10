# Prefix Sum Pattern — Revision Notes (Code + Examples)

## 1. What is the Pattern

Prefix Sum ante — array lo prathi index varaku "cumulative sum" munduganee calculate chesi store cheyadam. Range sum query O(1) lo answer avutundi (subtraction tho).

**Note:** NeetCode 250 lo "Prefix Sum" separate category ledu — "Arrays & Hashing" lo fold ayyi undi.

```java
int[] prefix = new int[arr.length + 1];
for (int i = 0; i < arr.length; i++) prefix[i+1] = prefix[i] + arr[i];
// range sum (i to j inclusive) = prefix[j+1] - prefix[i]
```

## 2. Variants — Code + Example

### Variant 1: Basic Range Sum Query

Static array (marадు) meedha, multiple range-sum queries fast ga answer cheyadaniki — munduganee prefix array build chesi pettukuntham, prathi query O(1) lo subtraction tho answer avutundi.

```java
// Example: Range Sum Query - Immutable
class NumArray {
    int[] prefix;
    public NumArray(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }
    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}
```

**Trace: arr=[1,2,3,4,5], query sumRange(1,3)**
```
prefix = [0,1,3,6,10,15]
sumRange(1,3) = prefix[4] - prefix[1] = 10 - 1 = 9
Verify: 2+3+4 = 9 ✓
```

Problems: Range Sum Query - Immutable, Running Sum of 1D Array

---

### Variant 2: Prefix Sum + HashMap (Subarray Sum Equals Target)

"Subarray sum == k" type problems ki — prefix sum ni calculate chestu, HashMap lo store chesukuntham, prathi step lo complement (currentSum - k) already map lo vundha ani check chestham. Vunte, aa subarray sum k ki equal ani ardham.

```java
// Example: Subarray Sum Equals K
public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1); // prefix sum 0 occurred once (before starting)
    int sum = 0, count = 0;
    for (int num : nums) {
        sum += num;
        if (map.containsKey(sum - k)) {
            count += map.get(sum - k);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
}
```

**Trace: nums=[1,2,3], k=3**
```
map={0:1}, sum=0, count=0
i=0(1): sum=1. sum-k=1-3=-2 → not in map. map={0:1,1:1}
i=1(2): sum=3. sum-k=3-3=0 → IS in map (count 1)! count=1
        (subarray [1,2] sums to 3). map={0:1,1:1,3:1}
i=2(3): sum=6. sum-k=6-3=3 → IS in map (count 1)! count=2
        (subarray [3] sums to 3). map={0:1,1:1,3:1,6:1}
Answer: count=2
```

Problems: Subarray Sum Equals K, Continuous Subarray Sum, Contiguous Array, Subarray Sums Divisible by K

---

### Variant 3: 2D Prefix Sum (Matrix Range Sum)

Array badulu 2D matrix meedha range sum query cheyali ante, prefix sum concept ni 2 dimensions ki extend chestham — prathi cell ki, top + left + current - overlap (inclusion-exclusion) formula tho cumulative sum build chestham.

```java
// Example: Range Sum Query 2D - Immutable
class NumMatrix {
    int[][] prefix;
    public NumMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        prefix = new int[rows + 1][cols + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                prefix[i+1][j+1] = matrix[i][j] + prefix[i][j+1] + prefix[i+1][j] - prefix[i][j];
            }
        }
    }
    public int sumRegion(int r1, int c1, int r2, int c2) {
        return prefix[r2+1][c2+1] - prefix[r1][c2+1] - prefix[r2+1][c1] + prefix[r1][c1];
    }
}
```

**Trace: matrix=[[3,0],[5,6]], query sumRegion(0,0,1,1)**
```
prefix[1][1] = 3
prefix[1][2] = 3+0 = 3
prefix[2][1] = 3+5 = 8
prefix[2][2] = matrix[1][1] + prefix[1][2] + prefix[2][1] - prefix[1][1]
             = 6 + 3 + 8 - 3 = 14
sumRegion(0,0,1,1) = prefix[2][2] = 14
Verify: 3+0+5+6 = 14 ✓
```

Problems: Range Sum Query 2D - Immutable, Matrix Block Sum

---

### Variant 4: Balance/Equilibrium Problems

"Left sum == right sum" type problems — total sum munduganee calculate chesi, tarwata prathi index ki left-running-sum track chestu, rightSum ni (total - left - current) formula tho derive chesi compare chestham.

```java
// Example: Find Pivot Index
public int pivotIndex(int[] nums) {
    int totalSum = Arrays.stream(nums).sum();
    int leftSum = 0;
    for (int i = 0; i < nums.length; i++) {
        int rightSum = totalSum - leftSum - nums[i];
        if (leftSum == rightSum) return i;
        leftSum += nums[i];
    }
    return -1;
}
```

**Trace: nums=[1,7,3,6,5,6]**
```
totalSum=28, leftSum=0
i=0: rightSum=28-0-1=27. 0==27? No. leftSum=1
i=1: rightSum=28-1-7=20. 1==20? No. leftSum=8
i=2: rightSum=28-8-3=17. 8==17? No. leftSum=11
i=3: rightSum=28-11-6=11. 11==11? YES! → pivot index=3
```

Problems: Find Pivot Index, Split Array with Equal Sum

---

### Variant 5: Difference Array (Range Update, Point Query)

Prefix Sum "range query" ki use avutundi, Difference Array "range update" ki — idi prefix sum concept ni reverse ga apply chesedi. Multiple range updates fast ga apply chesi, chivarlo prefix-sum-style reconstruct chesi final array pondutham.

```java
// Example: Range Addition
public int[] getModifiedArray(int n, int[][] updates) {
    int[] diff = new int[n + 1];
    for (int[] update : updates) {
        int start = update[0], end = update[1], val = update[2];
        diff[start] += val;
        diff[end + 1] -= val;
    }
    int[] result = new int[n];
    int runningSum = 0;
    for (int i = 0; i < n; i++) {
        runningSum += diff[i];
        result[i] = runningSum;
    }
    return result;
}
```

**Trace: n=5, updates=[[1,3,2],[2,4,3],[0,2,-2]]**
```
diff=[0,0,0,0,0,0]
Update [1,3,2]: diff[1]+=2, diff[4]-=2 → [0,2,0,0,-2,0]
Update [2,4,3]: diff[2]+=3, diff[5]-=3 → [0,2,3,0,-2,-3]
Update [0,2,-2]: diff[0]-=2, diff[3]+=2 → [-2,2,3,2,-2,-3]

Running sum (ignore last):
result[0]=-2, result[1]=0, result[2]=3, result[3]=5, result[4]=3
Answer: [-2,0,3,5,3]
```

Problems: Range Addition, Car Pooling, Corporate Flight Bookings

## 3. Trigger Points

- "Range sum" or "subarray sum" repeatedly kavali (multiple queries)
- "Subarray sum equals target/k"
- Matrix lo "submatrix/rectangle sum"
- "Equal count" or "balance" type condition
- "Multiple range updates" tarwata final array kavali

## 4. Keywords to Watch For

range sum | subarray sum equals k | cumulative sum | submatrix sum | pivot index | equal 0s and 1s | multiple queries | range update

## Summary Table

| # | Variant | Key Use Case |
|---|---|---|
| 1 | Basic Range Sum | Multiple static range queries |
| 2 | Prefix Sum + HashMap | Subarray sum == k |
| 3 | 2D Prefix Sum | Submatrix/rectangle sum |
| 4 | Balance/Equilibrium | Pivot index, equal 0s/1s |
| 5 | Difference Array | Multiple range updates |
