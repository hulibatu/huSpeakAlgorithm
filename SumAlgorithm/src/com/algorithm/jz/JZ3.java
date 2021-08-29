package com.algorithm.jz;

import java.util.ArrayList;
import java.util.Stack;

/**
 * JZ3 从尾到头打印链表
 * <p>
 * https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&&tqId=11156&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class JZ3 {

    public static void main(String[] args) {
        JZ3 jz3 = new JZ3();
        ListNode node = jz3.createListNode(new int[]{1, 2, 3});
        System.out.println("暴力法:" + jz3.printListFromTailToHead1(node).toString());
        System.out.println("递归法:" + jz3.printListFromTailToHead2(node).toString());
        System.out.println("堆栈法:" + jz3.printListFromTailToHead3(node).toString());
    }

    /**
     * 暴力法
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode currNode = listNode;
        while (currNode != null) {
            list.add(0, currNode.val);
            currNode = currNode.next;
        }
        return list;
    }

    /**
     * 递归法
     *
     * @param listNode
     * @return
     */
    ArrayList<Integer> mList = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead2(listNode.next);
            mList.add(listNode.val);
        }
        return mList;
    }

    public int getVal(ListNode listNode, ArrayList<Integer> list) {
        if (listNode.next != null) {
            list.add(getVal(listNode.next, list));
        }
        return listNode.val;
    }

    /**
     * 堆栈法
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (stack.size() > 0) {
            list.add(stack.pop());
        }
        return list;
    }

    public ListNode createListNode(int[] nums) {
        ListNode node = null;
        ListNode lastNode = null;
        int index = 0;
        while (index < nums.length) {
            ListNode nextNode = new ListNode(nums[index]);
            if (node == null) {
                node = nextNode;
            }
            if (lastNode != null) {
                lastNode.next = nextNode;
            }
            lastNode = nextNode;
            index++;
        }
        return node;
    }

    public static class ListNode {
        public int val;
        public ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
