# Stack Pattern — Revision Notes (Code + Examples)

## 1. What is the Pattern

Stack ante — LIFO (Last In, First Out). Java lo `ArrayDeque` vadali (`java.util.Stack` kaadu — synchronized overhead, Vector-based design flaw).

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(x); stack.pop(); stack.peek(); stack.isEmpty();
```

## 2. Variants — Code + Example

### Variant 1: Matching / Validity (Bracket Problems)

Opening bracket vaste push chestham, closing bracket vaste stack top tho match cheskoni pop chestham — chivarlo stack empty aithe balanced, kakapothe invalid.

```java
// Example: Valid Parentheses
public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');
    for (char c : s.toCharArray()) {
        if (map.containsKey(c)) {
            if (stack.isEmpty() || stack.pop() != map.get(c)) return false;
        } else {
            stack.push(c);
        }
    }
    return stack.isEmpty();
}
```

**Trace: "{[()]}"**
```
'{': push → stack=['{']
'[': push → stack=['{','[']
'(': push → stack=['{','[','(']
')': pop → matches '(' ✓ → stack=['{','[']
']': pop → matches '[' ✓ → stack=['{']
'}': pop → matches '{' ✓ → stack=[]
stack empty → VALID
```

Problems: Valid Parentheses, Minimum Add to Make Parentheses Valid

---

### Variant 2: Monotonic Stack (Next Greater/Smaller Element)

Stack lo elements ni increasing or decreasing order lo maintain chestham — prathi kotha element vachinapudu, order break ayye elements ni pop chesi (result compute chesi), tarwata current element ni push chestham.

```java
// Example: Daily Temperatures
public int[] dailyTemperatures(int[] temps) {
    int[] result = new int[temps.length];
    Deque<Integer> stack = new ArrayDeque<>(); // stores indices
    for (int i = 0; i < temps.length; i++) {
        while (!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
            int idx = stack.pop();
            result[idx] = i - idx;
        }
        stack.push(i);
    }
    return result;
}
```

**Trace: [73,74,75,71,69,72,76,73]**
```
i=0(73): stack=[0]
i=1(74): 74>73 → pop 0, result[0]=1 → stack=[1]
i=2(75): 75>74 → pop 1, result[1]=1 → stack=[2]
i=3(71): stack=[2,3]
i=4(69): stack=[2,3,4]
i=5(72): 72>69→pop4,result[4]=1; 72>71→pop3,result[3]=2; stack=[2,5]
i=6(76): 76>72→pop5,result[5]=1; 76>75→pop2,result[2]=4; stack=[6]
i=7(73): stack=[6,7]
Result: [1,1,4,2,1,1,0,0]
```

Problems: Daily Temperatures, Next Greater Element I & II, Largest Rectangle in Histogram, Asteroid Collision, Car Fleet

---

### Variant 3: Expression Evaluation

Mathematical expressions (infix, postfix) ni evaluate/parse cheyadam — numbers ni push chestham, operator vaste rendu numbers pop chesi operation apply chesi result ni malli push chestham.

```java
// Example: Evaluate Reverse Polish Notation
public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (String token : tokens) {
        if (token.matches("-?\\d+")) {
            stack.push(Integer.parseInt(token));
        } else {
            int b = stack.pop(), a = stack.pop();
            switch (token) {
                case "+": stack.push(a + b); break;
                case "-": stack.push(a - b); break;
                case "*": stack.push(a * b); break;
                case "/": stack.push(a / b); break;
            }
        }
    }
    return stack.pop();
}
```

**Trace: ["2","1","+","3","*"]**
```
"2": push → stack=[2]
"1": push → stack=[2,1]
"+": pop 1, pop 2 → 2+1=3 → push → stack=[3]
"3": push → stack=[3,3]
"*": pop 3, pop 3 → 3*3=9 → push → stack=[9]
Result: 9
```

Problems: Evaluate Reverse Polish Notation, Decode String, Basic Calculator

---

### Variant 4: Design Problems

Custom data structure design cheyadaniki stack ni internal component ga vadatham — e.g., Min Stack lo, oka additional "minStack" parallel ga maintain chestham prathi push ki current-minimum track cheyadaniki.

```java
// Example: Min Stack
class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(val, minStack.isEmpty() ? val : minStack.peek()));
    }
    public void pop() { stack.pop(); minStack.pop(); }
    public int top() { return stack.peek(); }
    public int getMin() { return minStack.peek(); }
}
```

**Trace: push(3), push(5), push(2), getMin(), pop(), getMin()**
```
push(3): stack=[3], minStack=[3]
push(5): stack=[3,5], minStack=[3,3]
push(2): stack=[3,5,2], minStack=[3,3,2]
getMin(): 2
pop(): stack=[3,5], minStack=[3,3]
getMin(): 3
```

Problems: Min Stack, Implement Queue using Stacks, Implement Stack using Queues

---

### Variant 5: Simulation / Backtracking-style Processing

Real-world process ni simulate cheyadaniki stack vadatham — undo operations, path simplification: normal directory/token vaste push, ".." (go back) vaste pop.

```java
// Example: Simplify Path
public String simplifyPath(String path) {
    Deque<String> stack = new ArrayDeque<>();
    for (String part : path.split("/")) {
        if (part.equals("") || part.equals(".")) continue;
        if (part.equals("..")) {
            if (!stack.isEmpty()) stack.pop();
        } else {
            stack.push(part);
        }
    }
    StringBuilder sb = new StringBuilder();
    for (String dir : stack) sb.insert(0, "/" + dir);
    return sb.length() == 0 ? "/" : sb.toString();
}
```

**Trace: "/a/./b/../../c/"**
```
parts = [a, ., b, .., .., c]
"a": push → stack=[a]
".": skip
"b": push → stack=[a,b]
"..": pop → stack=[a]
"..": pop → stack=[]
"c": push → stack=[c]
Result: "/c"
```

Problems: Simplify Path, Remove K Digits, Asteroid Collision

---

### Variant 6: Iterative Tree/Graph Traversal (Explicit Stack)

Recursion badulu, explicit stack use chesi DFS (tree/graph traversal) implement cheyadam — call stack automatic ga chese "backtrack" pani ni, manam explicit ga stack tho chestham. Deep recursion/stack overflow avoid cheyadaniki useful.

```java
// Example: Binary Tree Preorder Traversal (Iterative)
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        result.add(node.val);
        if (node.right != null) stack.push(node.right);
        if (node.left != null) stack.push(node.left);
    }
    return result;
}
```

**Trace: tree 1(root) → left 2, right 3**
```
stack=[1]
pop 1 → result=[1] → push right(3), push left(2) → stack=[3,2]
pop 2 → result=[1,2] → no children → stack=[3]
pop 3 → result=[1,2,3] → no children → stack=[]
Result: [1,2,3] (Root→Left→Right)
```

Problems: Binary Tree Preorder/Inorder/Postorder Traversal (Iterative)

## 3. Trigger Points

- Brackets/parentheses/tags matching
- "Next greater/smaller element"
- Mathematical expression evaluate cheyali
- "Design a data structure with O(1) operation"
- Path simplification, undo operation
- "Iterative" ga traversal cheyamani cheppinapudu

## 4. Keywords to Watch For

valid parentheses | balanced brackets | next greater element | daily temperatures | evaluate expression | min stack | simplify path | iterative traversal | monotonic

## Summary Table

| # | Variant | Key Use Case |
|---|---|---|
| 1 | Matching/Validity | Balanced brackets |
| 2 | Monotonic Stack | Next greater/smaller element |
| 3 | Expression Evaluation | Calculator, RPN |
| 4 | Design | Min Stack, Queue-using-Stack |
| 5 | Simulation | Path simplify, remove digits |
| 6 | Iterative Traversal | Iterative DFS/tree traversal |
