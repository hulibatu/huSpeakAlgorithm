package com.algorithm.jz;

import java.util.Stack;

/**
 * JZ5 用两个栈实现队列
 * <p>
 * https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&&tqId=11158&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class JZ5 {

    public static void main(String[] args) {
        JZ5 jz5 = new JZ5();
        int max = 2;
        int index = 0;
        while (index < max) {
            System.out.println("push : " + index);
            jz5.push(index);
            index++;
        }
        do {
            System.out.println("pop : " + jz5.pop());
        }
        while (jz5.stack2.size() > 0);
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
