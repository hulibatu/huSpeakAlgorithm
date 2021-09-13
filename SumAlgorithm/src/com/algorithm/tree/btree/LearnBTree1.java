package com.algorithm.tree.btree;

@SuppressWarnings("all")
public class LearnBTree1<Key extends Comparable<Key>, Value> {

    // B树 阶
    private static final int M = 4;
    // B树 根结点
    private Node root;
    // B树 高度
    private int height;
    // B树 关键字个数
    private int size;

    public LearnBTree1() {
        this.root = new Node(0);
    }

    public void put(Key key, Value value) {
        if (key == null) {
            new NullPointerException("key must not be null");
        }

        Node insertNode = insertNode(root, key, value, height);
        size += 1;

        if (insertNode != null) {
            Node tempRoot = new Node(2);
            tempRoot.children[0] = new Entry(root.children[0].key, null, root);
            tempRoot.children[1] = new Entry(insertNode.children[0].key, null, insertNode);
            root = tempRoot;
            height += 1;
        }
    }

    /**
     * 插入结点
     *
     * @param node
     * @param key
     * @param value
     * @param currHeight
     * @return
     */
    private Node insertNode(Node node, Key key, Value value, int currHeight) {
        Entry entry = new Entry(key, value);
        // 关键字插入位置
        int keyIndex = 0;
        // currHeight == 0 判断是否是叶子结点
        if (currHeight == 0) {
            while (keyIndex < node.count
                    && !less(key, node.children[keyIndex].key)) {
                keyIndex++;
            }
        } else {
            while (keyIndex < node.count) {
                if (keyIndex + 1 == node.count || less(key, node.children[keyIndex].key)) {
                    Node tempNode = insertNode(node.children[keyIndex++].next, key, value, currHeight - 1);
                    if (tempNode == null) {
                        return null;
                    }
                    entry.key = tempNode.children[0].key;
                    entry.next = tempNode;
                    break;
                } else {
                    keyIndex++;
                }
            }
        }
        // 平移位置
        for (int i = node.count; i > keyIndex; i--) {
            node.children[i] = node.children[i - 1];
        }
        node.children[keyIndex] = entry;
        node.count += 1;
        return node.count < M ? null : split(node);
    }

    /**
     * 分裂上浮
     *
     * @param node
     * @return
     */
    private Node split(Node node) {
        int mid = M / 2;
        Node tempNode = new Node(mid);
        node.count = mid;
        for (int i = 0; i < mid; i++) {
            tempNode.children[i] = node.children[mid + i];
        }
        return tempNode;
    }

    public Value get(Key key) {
        if (key == null) {
            new NullPointerException("key must not be null");
        }
        return search(root, key, height);
    }

    /**
     * 搜索
     *
     * @param node
     * @param key
     * @param currHeight
     * @return
     */
    private Value search(Node node, Key key, int currHeight) {
        Entry[] currEntry = node.children;
        if (currHeight == 0) {
            for (int i = 0; i < node.count; i++) {
                if (eq(key, currEntry[i].key)) {
                    return (Value) currEntry[i].value;
                }
            }
        } else {
            for (int i = 0; i < node.count; i++) {
                if (i + 1 == node.count || less(key, currEntry[i + 1].key)) {
                    return search(currEntry[i].next, key, currHeight - 1);
                }
            }
        }
        return null;
    }

    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }

    private boolean eq(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) == 0;
    }

    @Override
    public String toString() {
        return toString(root, height, "_");
    }

    public String toString(Node currNode, int currHeight, String indent) {
        StringBuffer sb = new StringBuffer();
        Entry[] children = currNode.children;
        if (currHeight == 0) {
            for (int i = 0; i < currNode.count; i++) {
                sb.append("[" + currHeight + "] ").append(indent).append(" (" + children[i].key + ")").append("\n");
            }
        } else {
            for (int i = 0; i < currNode.count; i++) {
                if (i > 0) {
                    sb.append("[" + currHeight + "] ").append(indent).append(" (" + children[i].key + ")").append("\n");
                }
                sb.append(toString(children[i].next, currHeight - 1, indent + "_"));
            }
        }
        return sb.toString();
    }

    public static final class Node {

        // 关键字个数
        private int count;
        // 关键字存储
        private Entry[] children = new Entry[M];

        public Node(int count) {
            this.count = count;
        }
    }

    public static final class Entry {

        public Comparable key;
        public Object value;
        public Node next;

        public Entry(Comparable key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Entry(Comparable key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        LearnBTree1<String, String> st = new LearnBTree1<>();
        st.put("www.cs.princeton.edu", "128.112.136.12");
        st.put("www.cs.princeton.edu", "128.112.136.11");
        st.put("www.princeton.edu", "128.112.128.15");
        st.put("www.yale.edu", "130.132.143.21");
        st.put("www.simpsons.com", "209.052.165.60");
        st.put("www.apple.com", "17.112.152.32");
        st.put("www.amazon.com", "207.171.182.16");
        st.put("www.ebay.com", "66.135.192.87");
        st.put("www.cnn.com", "64.236.16.20");
        st.put("www.google.com", "216.239.41.99");
        st.put("www.nytimes.com", "199.239.136.200");
        st.put("www.microsoft.com", "207.126.99.140");
        st.put("www.dell.com", "143.166.224.230");
        st.put("www.slashdot.org", "66.35.250.151");
        st.put("www.espn.com", "199.181.135.201");
        st.put("www.weather.com", "63.111.66.11");
        st.put("www.yahoo.com", "216.109.118.65");

        System.out.println("cs.princeton.edu:  " + st.get("www.cs.princeton.edu"));
        System.out.println("hardvardsucks.com: " + st.get("www.harvardsucks.com"));
        System.out.println("simpsons.com:      " + st.get("www.simpsons.com"));
        System.out.println("apple.com:         " + st.get("www.apple.com"));
        System.out.println("ebay.com:          " + st.get("www.ebay.com"));
        System.out.println("dell.com:          " + st.get("www.dell.com"));
        System.out.println();

        System.out.println("size:    " + st.size);
        System.out.println("height:  " + st.height);
        System.out.println(st);
        System.out.println();

    }


}
