package com.basic.leetcode;

import java.util.Stack;

/**
 *
 */
public class MyQueue {

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        int param_3 = obj.peek();
        System.out.println(param_3);
        int param_2 = obj.pop();
        System.out.println(param_2);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }

    private Integer front;

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (s1.empty()) front = x;
        while (!s1.isEmpty()) s2.push(s1.pop());
        s2.push(x);
        while (!s2.isEmpty()) s1.push(s2.pop());
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        Integer pop = s1.pop();
        if (!s1.isEmpty()) front = s1.peek();
        return pop;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return front;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
