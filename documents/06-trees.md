# Trees Pattern — Revision Notes (Code + Examples)

## 1. What is the Pattern

Tree ante — root nunchi start ayye hierarchical structure. Trees problems anni traversal order meedha base avutayi.

```java
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}
```

Sample tree used in all examples below:
```
        1
       / \
      2   3
     / \
    4   5
```

## 2. Variants — Code + Example

### Variant 1: DFS Traversal (Preorder, Inorder, Postorder)

Root nunchi deep ga oka path lo veli, order batti (root ముందు/మధ్యలో/చివర్లో) visit cheyadam. Preorder tree copy/serialize ki, Inorder BST sorted order ki, Postorder children-dependent computation ki.

```java
// Preorder: Root → Left → Right
public void preorder(TreeNode node, List<Integer> result) {
    if (node == null) return;
    result.add(node.val);
    preorder(node.left, result);
    preorder(node.right, result);
}

// Inorder: Left → Root → Right
public void inorder(TreeNode node, List<Integer> result) {
    if (node == null) return;
    inorder(node.left, result);
    result.add(node.val);
    inorder(node.right, result);
}

// Postorder: Left → Right → Root
public void postorder(TreeNode node, List<Integer> result) {
    if (node == null) return;
    postorder(node.left, result);
    postorder(node.right, result);
    result.add(node.val);
}
```

**Trace on sample tree:**
```
Preorder:  1, 2, 4, 5, 3
Inorder:   4, 2, 5, 1, 3
Postorder: 4, 5, 2, 3, 1
```

Trick: "Root" word position in the name = root's position in output.

Problems: Binary Tree Inorder/Preorder/Postorder Traversal, Same Tree, Subtree of Another Tree

---

### Variant 2: BFS Traversal (Level Order)

Queue vadi tree ni level-by-level (top to bottom, left to right) visit cheyadam — oka level lo unna nodes anni process chesaka matrame next level ki move avutham.

```java
// Example: Binary Tree Level Order Traversal
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int size = queue.size();
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            level.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        result.add(level);
    }
    return result;
}
```

**Trace on sample tree:**
```
Queue=[1]
Level 0: process 1 → add [2,3] → result=[[1]]
Level 1: process 2,3 → add [4,5] → result=[[1],[2,3]]
Level 2: process 4,5 → no children → result=[[1],[2,3],[4,5]]
```

Problems: Binary Tree Level Order Traversal, Right Side View, Zigzag Level Order

---

### Variant 3: Top-Down Recursion (Parent → Child info pass)

Parent node nunchi child ki information pass chestham (current depth, running sum ala) — child level lo, parent icchina info base chesukoni decision teesukuntham.

```java
// Example: Maximum Depth of Binary Tree
public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
}
```

**Trace on sample tree:**
```
maxDepth(1) = 1 + max(maxDepth(2), maxDepth(3))
  maxDepth(2) = 1 + max(maxDepth(4), maxDepth(5))
    maxDepth(4) = 1 + max(0,0) = 1
    maxDepth(5) = 1 + max(0,0) = 1
  maxDepth(2) = 1 + max(1,1) = 2
  maxDepth(3) = 1 + max(0,0) = 1
maxDepth(1) = 1 + max(2,1) = 3
Result: 3
```

Problems: Maximum Depth of Binary Tree, Path Sum, Invert Binary Tree, Count Good Nodes

---

### Variant 4: Bottom-Up Recursion (Child → Parent result return)

Child nodes result compute chesi, aa result ni parent ki return chestham — parent aa results ni combine chesi tana result decide chestundi. "Subtree gurinchi" info kavalsina problems ki (root nunchi kadu) ide approach.

```java
// Example: Diameter of Binary Tree
int diameter = 0;
public int diameterOfBinaryTree(TreeNode root) {
    height(root);
    return diameter;
}
private int height(TreeNode node) {
    if (node == null) return 0;
    int leftHeight = height(node.left);
    int rightHeight = height(node.right);
    diameter = Math.max(diameter, leftHeight + rightHeight);
    return 1 + Math.max(leftHeight, rightHeight);
}
```

**Trace on sample tree:**
```
height(4)=0, diameter=max(0,0+0)=0, returns 1
height(5)=0, diameter=max(0,0+0)=0, returns 1
height(2): leftH=height(4)=1, rightH=height(5)=1
           diameter=max(0,1+1)=2, returns 1+max(1,1)=2
height(3)=0, returns 1
height(1): leftH=height(2)=2, rightH=height(3)=1
           diameter=max(2,2+1)=3, returns 1+max(2,1)=3
Final diameter = 3
```

Problems: Diameter of Binary Tree, Balanced Binary Tree, Binary Tree Maximum Path Sum

---

### Variant 5: Binary Search Tree (BST) Specific

BST ki special property untundi (left subtree < root < right subtree) — idi vadi, normal binary tree kante fast operations chestham. Key insight: BST meedha Inorder traversal chesthe sorted order vastundi.

```java
// Example: Validate Binary Search Tree
public boolean isValidBST(TreeNode root) {
    return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
}
private boolean validate(TreeNode node, long min, long max) {
    if (node == null) return true;
    if (node.val <= min || node.val >= max) return false;
    return validate(node.left, min, node.val) && validate(node.right, node.val, max);
}
```

**Trace: tree 5(root), left=3, right=8**
```
validate(5, -inf, +inf): 5 in range →
  validate(3, -inf, 5): 3 in range → children null → true
  validate(8, 5, +inf): 8 in range → children null → true
Result: true (valid BST)

Counter-example: 5(root), left=6 →
validate(6, -inf, 5): 6 >= 5 → FALSE (invalid BST)
```

Problems: Validate Binary Search Tree, Kth Smallest Element in a BST, LCA of a BST

---

### Variant 6: Tree Construction / Serialization

Tree ni array/string nunchi build cheyadam, leda tree ni array/string ga convert cheyadam — e.g., Preorder+Inorder combination unte, preorder[0] eppudu root, inorder lo aa root position left/right subtree sizes decide chestundi.

```java
// Example: Construct Binary Tree from Preorder and Inorder Traversal
public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) inorderMap.put(inorder[i], i);
    return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
}
private TreeNode build(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, Map<Integer,Integer> map) {
    if (preStart > preEnd) return null;
    TreeNode root = new TreeNode(pre[preStart]);
    int mid = map.get(root.val);
    int leftSize = mid - inStart;
    root.left = build(pre, preStart+1, preStart+leftSize, in, inStart, mid-1, map);
    root.right = build(pre, preStart+leftSize+1, preEnd, in, mid+1, inEnd, map);
    return root;
}
```

**Trace: Preorder=[1,2,4,5,3], Inorder=[4,2,5,1,3]**
```
Preorder[0]=1 is root. Find 1 in Inorder → index 3
  → left subtree has 3 elements [4,2,5], right has [3]
Root=1
  Left: Preorder=[2,4,5], Inorder=[4,2,5]
    Root=2, find in inorder → index1 → left=[4], right=[5]
  Right: Preorder=[3], Inorder=[3] → single node 3
Reconstructed tree matches original sample tree!
```

Problems: Construct Binary Tree from Preorder and Inorder, Serialize and Deserialize Binary Tree

---

### Variant 7: Iterative Traversal (Explicit Stack/Queue)

Recursion badulu, explicit Stack (DFS ki) leda Queue (BFS ki) vadatam — deep trees lo recursion stack overflow avvakunda cheyadaniki, leda "iterative" ani specifically adigite.

```java
// Example: Inorder Traversal (Iterative)
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        result.add(curr.val);
        curr = curr.right;
    }
    return result;
}
```

**Trace on sample tree (Inorder expected: 4,2,5,1,3):**
```
curr=1: push 1, curr=2. push 2, curr=4. push 4, curr=null.
stack=[1,2,4]
pop 4 → result=[4]. curr=4.right=null
pop 2 → result=[4,2]. curr=2.right=5 → push 5, curr=null
pop 5 → result=[4,2,5]. curr=null
pop 1 → result=[4,2,5,1]. curr=1.right=3 → push 3
pop 3 → result=[4,2,5,1,3]
```

Same technique as Stack pattern Variant 6 (cross-referenced).

Problems: Preorder/Inorder/Postorder Traversal (Iterative)

## 3. Trigger Points

- "Level order", "level-wise" → BFS (2)
- "Root nunchi node varaku path" → Top-Down (3)
- "Subtree" gurinchi info (height, sum, balanced) → Bottom-Up (4)
- "BST" explicitly cheppinaru → Variant 5
- "Construct", "serialize/deserialize" → Variant 6
- "Iterative" ga cheyamani cheppinaru → Variant 7

## 4. Keywords to Watch For

level order | root to leaf | subtree | balanced | diameter | BST | validate BST | kth smallest | serialize | deserialize | construct tree | iterative | lowest common ancestor

## Quick Self-Test (Variant 3 vs 4)

"Answer ki, node dagara unna info chalu (root nunchi vachina)?" → Top-down.
"Answer ki, children results combine cheyali?" → Bottom-up.

## Summary Table

| # | Variant | Key Use Case |
|---|---|---|
| 1 | DFS Traversal | Basic tree processing |
| 2 | BFS Traversal | Level-wise problems |
| 3 | Top-Down | Path-based problems |
| 4 | Bottom-Up | Subtree-based problems |
| 5 | BST-specific | Search/Insert/Delete in BST |
| 6 | Construction/Serialization | Construct/serialize/deserialize |
| 7 | Iterative Traversal | Avoid recursion overhead |
