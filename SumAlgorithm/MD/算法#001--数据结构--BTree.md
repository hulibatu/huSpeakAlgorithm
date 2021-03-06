# BTree - B树
## 概念
m-way 多路平衡查找树 ，降低树的高度 
## 特性
1. m阶 B树，每个结点最多有 m（m>=2）个分支 
2. 除根结点和叶子结点，其他每个结点至少有 ceil(m/2) 个分支
3. 拥有 n 个分支的结点最多有 max = n-1 个关键字
4. 根结点最少有1个关键字，子结点最少有 min = ceil(m/2)-1 个关键字
## 操作
### 1.插入
1. 数据格式 key-value 格式
2. 结点关键字有序 递增/递减 
3. 插入后，关键字长度 length > max ，拆分上浮
4. 拆分上浮合并：上浮 index = ceil(length/2) ，合并到父结点
5. 父结点也达到 max ，同时进行拆分上浮
### 2.搜索
遍历查找到 第一个大于 被查找关键字的关键字
### 3.删除
1. 删除后，关键字长度 length < min ，前继/后继 取叶子结点关键字最长
2. 叶子结点 前继/后续 关键字长度 length < min ，则 借用兄弟结点关键字
3. 兄弟结点 借用后 关键字长度 length >= min：父结点关键字下沉，兄弟结点关键字上浮
4. 兄弟结点 借用后 关键字长度 length < min: 父结点关键字下沉，兄弟结点关键字合并


