***
STL中的unordered_map和priority_queue使用的底层数据结构分别是什么?()
```
A. rbtree,queue
B. hashtable,heap
C. rbtree,heap
D. hashtable,queue
```
**答案: B**

map： map内部实现了一个红黑树，该结构具有自动排序的功能，因此map内部的所有元素都是有序的，红黑树的每一个节点都代表着map的一个元素，因此，对于map进行的查找，删除，添加等一系列的操作都相当于是对红黑树进行这样的操作，故红黑树的效率决定了map的效率。

unordered_map: unordered_map内部实现了一个哈希表，因此其元素的排列顺序是杂乱的，无序的

priority_queue：是所谓的优先级队列，说白了就是一个二叉堆，所以底层应该是用heap实现，并非名字中的queue
