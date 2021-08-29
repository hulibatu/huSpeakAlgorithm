package com.algorithm.tree.avltree;

/**
 * 平衡二叉树
 * <p>
 * 核心：AVL树中任何节点的两个子树的高度最大差别为1
 * <p>
 * 核心操作 添加 & 删除
 * <p>
 * 难点：LL LR RR RL 4个旋转
 */
public class LearnAvlTreeTest {

    public static void main(String[] args) {

        // 构建
        AvlTree avlTree = new AvlTree();
        System.out.println("依次添加: 3 2 1 4 5 6 7 16 15 14 13 12 11 10 8 9");
        avlTree.addNode(3);
        avlTree.addNode(2);
        avlTree.addNode(1);
        avlTree.addNode(4);
        avlTree.addNode(5);
        avlTree.addNode(6);
        avlTree.addNode(7);
        avlTree.addNode(16);
        avlTree.addNode(15);
        avlTree.addNode(14);
        avlTree.addNode(13);
        avlTree.addNode(12);
        avlTree.addNode(11);
        avlTree.addNode(10);
        avlTree.addNode(8);
        avlTree.addNode(9);
        System.out.printf("\n");
        System.out.println("高度：" + avlTree.getNodeHeight(avlTree.root));
        System.out.printf("\n");
        System.out.println("前序遍历: 7 4 2 1 3 6 5 13 11 9 8 10 12 15 14 16 ");
        avlTree.proOrder(avlTree.root);
        System.out.printf("\n");
        System.out.println("中序遍历: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 ");
        avlTree.inOrder(avlTree.root);
        System.out.printf("\n");
        System.out.println("后序遍历: 1 3 2 5 6 4 8 10 9 12 11 14 16 15 13 7 ");
        avlTree.postOrder(avlTree.root);
        System.out.printf("\n");
//        System.out.println("删除&中序遍历");
//        avlTree.delNode(3);
//        avlTree.inOrder(avlTree.root);
    }

    public static class AvlTree {

        public Node root;

        // 高度
        public int getNodeHeight(Node node) {
            if (node == null) {
                return 0;
            }
            return node.height;
        }

        // 最大值
        public int max(int a, int b) {
            return a > b ? a : b;
        }

        // LL
        private Node llRotation(Node node) {
            if (node == null) {
                return null;
            }
            Node currNode = node.left;
            if (currNode != null) {
                node.left = currNode.right;
                currNode.right = node;
                node.height = max(getNodeHeight(node.left), getNodeHeight(node.right)) + 1;
                currNode.height = max(getNodeHeight(currNode.left), getNodeHeight(currNode.right)) + 1;
            }
            return currNode;
        }

        // LR
        private Node lrRotation(Node node) {
            if (node == null) {
                return null;
            }
            node.left = rrRotation(node.left);
            return llRotation(node);
        }

        // RR
        private Node rrRotation(Node node) {
            if (node == null) {
                return null;
            }
            Node currNode = node.right;
            if (currNode != null) {
                node.right = currNode.left;
                currNode.left = node;
                node.height = max(getNodeHeight(node.left), getNodeHeight(node.right)) + 1;
                currNode.height = max(getNodeHeight(currNode.left), getNodeHeight(currNode.right)) + 1;
            }
            return currNode;
        }

        //RL
        private Node rlRotation(Node node) {
            if (node == null) {
                return null;
            }
            node.right = llRotation(node.right);
            return rrRotation(node);
        }

        public void addNode(int value) {
            root = addNode(root, value);
        }

        private Node addNode(Node currNode, int value) {
            if (currNode == null) {
                currNode = new Node(value);
            } else {
                if (value < currNode.data) {
                    currNode.left = addNode(currNode.left, value);
                    if (getNodeHeight(currNode.left) - getNodeHeight(currNode.right) > 1) {
                        if (value < currNode.left.data) {
                            currNode = llRotation(currNode);
                        } else {
                            currNode = lrRotation(currNode);
                        }
                    }
                } else if (value > currNode.data) {
                    currNode.right = addNode(currNode.right, value);
                    if (getNodeHeight(currNode.right) - getNodeHeight(currNode.left) > 1) {
                        if (value > currNode.right.data) {
                            currNode = rrRotation(currNode);
                        } else {
                            currNode = rlRotation(currNode);
                        }
                    }
                }
            }
            currNode.height = max(getNodeHeight(currNode.left), getNodeHeight(currNode.right)) + 1;
            return currNode;
        }

        public void delNode(int value) {



        }

        private Node maxNode(Node node) {
            if (node == null) {
                return null;
            }
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }

        private Node minNode(Node node) {
            if (node == null) {
                return null;
            }
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        public void proOrder(Node node) {
            if (node != null) {
                System.out.printf(node.data + " ");
                proOrder(node.left);
                proOrder(node.right);
            }
        }

        public void inOrder(Node node) {
            if (node != null) {
                inOrder(node.left);
                System.out.printf(node.data + " ");
                inOrder(node.right);
            }
        }

        public void postOrder(Node node) {
            if (node != null) {
                postOrder(node.left);
                postOrder(node.right);
                System.out.printf(node.data + " ");
            }
        }

    }

    public static class Node {

        public int data;
        public int height;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }

    }

}


