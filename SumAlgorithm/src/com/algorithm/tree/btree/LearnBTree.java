package com.algorithm.tree.btree;

/**
 * B-Tree是一种自平衡树
 * B-Tree中的节点可以具有M个子节点（M> = 2）
 * 根结点 1个
 * 内部结点 具有子结点的结点
 * 叶结点 没有子结点的结点
 * <p>
 * B-Tree的约束
 * 1. t 为 B树的最小度 ，其中 t>=2
 * 2. 除 根结点 每个结点键 keys >= t-1 ，结点键总数下限
 * 3. 包含 根结点 每个结点至 keys <= 2t-1 个键，结点键总数上线
 * 4. 内部结点 t <= 子结点 <= 2t
 * 5. 结点中的键 必须升序 1<2<3
 * 6. 键左侧子结点所有键都小于该键
 * 7. 键右侧子结点所有键都大于该键
 * <p>
 * 内部结点
 * 前继结点 左侧最大值
 * 后继结点 右侧最大值
 * <p>
 * 关键操作：
 * 1. 拆分结点 叶结点达到键最大上线时 2t - 1 进行拆分，拆分后 高度不一致，影响平衡，分类后的顶结合到父结点
 * <p>
 * 合并
 */
public class LearnBTree {

    public static class BTreeNode {

        // 构成B树的最小度
        public final static int MIN_LENGTH = 3;

        // 除根结点 键最小长度
        public final static int LOW_KEYS_LENGTH = MIN_LENGTH - 1;
        // 包含根结点 键最大长度
        public final static int HIGH_KEYS_LENGTH = (MIN_LENGTH * 2) - 1;
        // 子结点 做小长度
        public final static int LOW_CHILD_NODE_LENGTH = MIN_LENGTH;
        // 子节点 最大长度
        public final static int HIGH_CHILD_NODE_LENGTH = MIN_LENGTH * 2;

        // 是否是 叶结点
        protected boolean mIsLeaf;
        // 键长度
        protected int mCurrKeysLength;
        // 存储键数组
        protected BTreeKeyValue[] mKeys;
        // 存储结点数组
        protected BTreeNode[] mChildNodes;

        public BTreeNode() {
            mIsLeaf = true;
            mCurrKeysLength = 0;
            mKeys = new BTreeKeyValue[HIGH_KEYS_LENGTH];
            mChildNodes = new BTreeNode[HIGH_CHILD_NODE_LENGTH];
        }

        public BTreeNode getChildNodeAtIndex(BTreeNode btNode, int keyIdx, int nDirection) {
            if (btNode.mIsLeaf) {
                return null;
            }
            keyIdx += nDirection;
            if (keyIdx <= 0 || keyIdx > btNode.mCurrKeysLength) {
                return null;
            }
            return btNode.mChildNodes[keyIdx];
        }

        /**
         * 返回 btNode 结点中位于 keyIdx 左子节点
         *
         * @param btNode
         * @param keyIdx
         * @return
         */
        public BTreeNode getLeftNodeAtIndex(BTreeNode btNode, int keyIdx) {
            return getChildNodeAtIndex(btNode, keyIdx, -1);
        }

        /**
         * 返回 btNode 结点中位于 keyIdx 右面子节点
         *
         * @param btNode
         * @param keyIdx
         * @return
         */
        public BTreeNode getRightNodeAtIndex(BTreeNode btNode, int keyIdx) {
            return getChildNodeAtIndex(btNode, keyIdx, 1);
        }

        /**
         * 返回 左兄弟结点
         *
         * @param parentNode
         * @param keyIdx
         * @return
         */
        public BTreeNode getLeftSiblingAtIndex(BTreeNode parentNode, int keyIdx) {
            return getChildNodeAtIndex(parentNode, keyIdx, -1);
        }

        public boolean hasLeftSiblingAtIndex(BTreeNode parentNode, int keyIdx) {
            if (keyIdx - 1 < 0) {
                return false;
            }
            return true;
        }

        /**
         * 返回 右兄弟结点
         *
         * @param parentNode
         * @param keyIdx
         * @return
         */
        public BTreeNode getRightSiblingAtIndex(BTreeNode parentNode, int keyIdx) {
            return getChildNodeAtIndex(parentNode, keyIdx, 1);
        }

        public boolean hasRightSiblingAtIndex(BTreeNode parentNode, int keyIdx) {
            if (keyIdx + 1 > parentNode.mCurrKeysLength) {
                return false;
            }
            return true;
        }

        /**
         * 拆分结点
         * @param bTreeNode
         * @return
         */
        private BTreeNode splitBTreeNode(BTreeNode bTreeNode) {
            int mid = bTreeNode.mCurrKeysLength / 2;

            BTreeNode leftNode = new BTreeNode();
            for (int i = 0; i < mid; i++) {
                leftNode.mKeys[i] = bTreeNode.mKeys[i];
                leftNode.mChildNodes[i] = bTreeNode.mChildNodes[i];
            }
            leftNode.mChildNodes[mid] = bTreeNode.mChildNodes[mid];
            leftNode.mIsLeaf = bTreeNode.mIsLeaf;
            leftNode.mCurrKeysLength = mid;

            BTreeNode rightNode = new BTreeNode();
            for (int i = mid + 1; i < bTreeNode.mCurrKeysLength; i++) {
                rightNode.mKeys[i - mid - 1] = bTreeNode.mKeys[i];
                rightNode.mChildNodes[i - mid - 1] = bTreeNode.mChildNodes[i];
            }
            rightNode.mChildNodes[bTreeNode.mCurrKeysLength - mid - 1] = bTreeNode.mChildNodes[bTreeNode.mCurrKeysLength];
            rightNode.mIsLeaf = bTreeNode.mIsLeaf;
            rightNode.mCurrKeysLength = bTreeNode.mCurrKeysLength - mid - 1;

            BTreeNode top = new BTreeNode();
            top.mCurrKeysLength = 1;
            top.mIsLeaf = false;
            top.mKeys[0] = mKeys[mid];
            top.mChildNodes[0] = leftNode;
            top.mChildNodes[1] = rightNode;
            return top;

        }


    }

    public static class BTreeKeyValue {

        public int key;
        public int value;

        public BTreeKeyValue(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
