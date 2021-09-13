package com.algorithm.tree.btree;

/**
 * B树的简单实现
 */
public class LearnBTree2 {

    /**
     * B树节点中的键值对
     *
     * @param <K>
     * @param <V>
     */
    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    /**
     * 在B树节点中搜索给定值得返回结果
     */
    private static class SearchResult{

    }

}
