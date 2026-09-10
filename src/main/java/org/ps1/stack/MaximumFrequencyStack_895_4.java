package org.ps1.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class FreqStack {

    // value -> frequency
    Map<Integer, Integer> freqMap;

    // frequency -> stack of values
    Map<Integer, Stack<Integer>> groupMap;

    int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        groupMap = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {

        int freq = freqMap.getOrDefault(val, 0) + 1;

        freqMap.put(val, freq);

        maxFreq = Math.max(maxFreq, freq);

        groupMap
                .computeIfAbsent(freq, k -> new Stack<>())
                .push(val);
    }

    public int pop() {

        Stack<Integer> stack = groupMap.get(maxFreq);

        int val = stack.pop();

        // decrease frequency
        int freq = freqMap.get(val);
        freqMap.put(val, freq - 1);

        // if current max-frequency group becomes empty
        if (stack.isEmpty()) {
            groupMap.remove(maxFreq);
            maxFreq--;
        }

        return val;
    }
}
public class MaximumFrequencyStack_895_4 {
    public static void main(String[] args) {

    }
}
