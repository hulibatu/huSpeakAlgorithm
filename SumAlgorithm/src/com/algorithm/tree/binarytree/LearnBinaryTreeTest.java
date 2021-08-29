package com.algorithm.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树 简单实现
 * <p>
 * 核心操作 删除
 * <p>
 * 难点 前驱结点、后继结点
 */
public class LearnBinaryTreeTest {

    public static void main(String[] args) {

        /**
         * 1 构建
         */
        System.out.println("依次添加: 1 5 4 3 2 8 7 6 9 0");
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addNode(1);
        binaryTree.addNode(5);
        binaryTree.addNode(4);
        binaryTree.addNode(3);
        binaryTree.addNode(2);
        binaryTree.addNode(8);
        binaryTree.addNode(7);
        binaryTree.addNode(6);
        binaryTree.addNode(9);
        binaryTree.addNode(0);

        /**
         * 2 遍历 深度优先 广度优先
         */
        System.out.println("深度优先 前序遍历: 1 0 5 4 3 2 8 7 6 9 ");
        binaryTree.proOrder(binaryTree.root);
        System.out.printf("\n");
        System.out.println("深度优先 中序遍历: 0 1 2 3 4 5 6 7 8 9 ");
        binaryTree.inOrder(binaryTree.root);
        System.out.printf("\n");
        System.out.println("深度优先 后序遍历: 0 2 3 4 6 7 9 8 5 1 ");
        binaryTree.postOrder(binaryTree.root);
        System.out.printf("\n");
        System.out.println("广度优先遍历 1 0 5 4 8 3 7 9 2 6 ");
        binaryTree.breadthFirst(binaryTree.root);
        System.out.printf("\n");

        /**
         * 3 搜索
         */
        Node selectNode = binaryTree.selectNode(binaryTree.root, 11);
        if (selectNode != null) {
            System.out.println("搜索到结点 ：" + selectNode.data);
        } else {
            System.out.println("未搜索到结点");
        }

        /**
         * 4 最大值/最小值
         */
        System.out.println("最大值：" + binaryTree.maxNode(binaryTree.root).data);
        System.out.println("最小值：" + binaryTree.minNode(binaryTree.root).data);

        /**
         * 5 前驱结点，后继结点
         */
        Node currNode = binaryTree.selectNode(binaryTree.root, 6);
        // 前驱节点
        Node beforeNode = binaryTree.beforeNode(currNode);
        if (beforeNode != null) {
            System.out.println("前驱结点：" + beforeNode.data);
        } else {
            System.out.println("未查询到前驱结点");
        }
        // 后继节点
        Node lastNode = binaryTree.lastNode(currNode);
        if (lastNode != null) {
            System.out.println("后继结点：" + lastNode.data);
        } else {
            System.out.println("未查询到后继结点");
        }

        /**
         * 6 删除
         */
        Node delNode = binaryTree.delNode(binaryTree.root, 5);
        System.out.println("删除后遍历");
        binaryTree.inOrder(delNode);

    }

    // BinaryTree
    public static class BinaryTree {

        public Node root;

        public void addNode(int value) {
            root = addNode(root, null, value);
        }

        private Node addNode(Node currNode, Node parentNode, int value) {
            if (currNode == null) {
                Node node = new Node(value, parentNode);
                return node;
            }
            if (value < currNode.data) {
                currNode.left = addNode(currNode.left, currNode, value);
            } else if (value > currNode.data) {
                currNode.right = addNode(currNode.right, currNode, value);
            }
            return currNode;
        }

        public void proOrder(Node node) {
            if (node == null) {
                return;
            }
            System.out.printf(node.data + " ");
            proOrder(node.left);
            proOrder(node.right);
        }

        public void inOrder(Node node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            System.out.printf(node.data + " ");
            inOrder(node.right);
        }

        public void postOrder(Node node) {
            if (node == null) {
                return;
            }
            postOrder(node.left);
            postOrder(node.right);
            System.out.printf(node.data + " ");
        }

        public void breadthFirst(Node node) {
            if (node == null) {
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                Node currNode = queue.remove();
                System.out.printf(currNode.data + " ");
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }

        public Node selectNode(Node currNode, int value) {
            if (currNode == null) {
                return null;
            }
            if (value < currNode.data) {
                return selectNode(currNode.left, value);
            } else if (value > currNode.data) {
                return selectNode(currNode.right, value);
            }
            return currNode;
        }

        public Node maxNode(Node node) {
            if (node == null) {
                return null;
            }
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }

        /**
         * 最小值
         */
        public Node minNode(Node node) {
            if (node == null) {
                return null;
            }
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        public Node beforeNode(Node node) {
            if (node == null) {
                return null;
            }
            if (node.left != null) {
                return maxNode(node.left);
            }
            Node parentNode = node.parent;
            while (parentNode != null && node == parentNode.left) {
                node = parentNode;
                parentNode = node.parent;
            }
            return parentNode;
        }

        public Node lastNode(Node node) {
            if (node == null) {
                return null;
            }
            if (node.right != null) {
                return minNode(node.right);
            }
            Node parentNode = node.parent;
            while (parentNode != null && node == parentNode.right) {
                node = parentNode;
                parentNode = node.parent;
            }
            return parentNode;
        }

        public Node delNode(Node currNode, int value) {
            if (currNode == null) {
                return null;
            }
            if (value == currNode.data) {
                if (currNode.left == null) {
                    currNode = currNode.right;
                } else if (currNode.right == null) {
                    currNode = currNode.left;
                } else {
//                    Node beforeNode = beforeNode(currNode);
//                    currNode.data = beforeNode.data;
//                    currNode.left = delNode(currNode.left, beforeNode.data);
                    Node lastNode = lastNode(currNode);
                    currNode.data = lastNode.data;
                    currNode.right = delNode(currNode.right, lastNode.data);
                }
            } else if (value < currNode.data) {
                currNode.left = delNode(currNode.left, value);
            } else if (value > currNode.data) {
                currNode.right = delNode(currNode.right, value);
            }
            return currNode;
        }

    }

    // Node 节点
    public static class Node {

        public int data;
        public Node parent;
        public Node left;
        public Node right;

        public Node(int data, Node parent) {
            this.data = data;
            this.parent = parent;
        }

    }


}
