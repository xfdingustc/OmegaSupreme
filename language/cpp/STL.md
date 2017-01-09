***
``` CPP
std::vector::iterator
```
没有重载下面哪个运算符
```
A. ==
B. ++
C. *
D. >>
```
**答案: D**

迭代器可以看成一个指针，指针没有移位运算

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

***
以下代码实现了从表中删除重复项的功能，请选择其中空白行应填入的正确代码（）
``` CPP
template<typename T>
void removeDuplicates(list<T> &aList) {
  T curValue;
  list<T>::iterator cur, p;
  cur = aList.begin();
  while (cur != aList.end()) {
    curValue = *cur;
    //空白行
    while (p != aList.end()) {
      if (*p == curValue) {
        //空白行
      } else {
        p++;
      }
    }
  }
}
```

```
A. p=curr+1;aList.erase(p++);
B. p=++curr;aList.erase(p++);
C. p=curr+1;aList.erase(p);
D. p=++curr;aList.erase(p);
```

**答案：B**

当使用一个容器的insert或者erase函数通过迭代器插入或删除元素"可能"会导致迭代器失效
iterator失效主要有两种情况：
1. iterator变量已经变成了“野指针”，对它进行*,++,--都会引起程序内存操作异常；
2. iterator所指向的变量已经不是你所以为的那个变量了。
不同的容器，他们erase()的返回值的内容是不同的，有的会返回被删除元素的下一个的iterator，有的则会返回删除元素的个数。
对于非结点类，如数组类的容器 vector,string,deque 容器标准写法是这样:

``` CPP
 //vector<int> m_vector;
 for(vector<int>::iterator iter = m_vector.begin(); iter != m_vector.end();) {
    if (需要删除)  {
      iter=m_vector.erase(iter);
    } else {
      ++iter;
    }
}
```
数组型数据结构：该数据结构的元素是分配在连续的内存中，insert和erase操作，都会使得删除点和插入点之后的元素挪位置，所以，插入点和删除掉之后的迭代器全部失效，也就是说`insert(*iter)(或erase(*iter))`，然后在iter++，是没有意义的。解决方法：`erase(*iter)`的返回值是下一个有效迭代器的值。 `iter = cont.erase(iter)`;

对于结点类容器(如:list,map,set)是这样:

``` CPP
 //map<int,int> m_map;
for (map<int,int>::iterator iter = m_map.begin(); iter != m_map.end();) {
  if (需要删除) {
    m_map.erase(iter++);
  } else {
    ++iter;
  }
}
```
链表型数据结构：对于list型的数据结构，使用了不连续分配的内存，删除运算使指向删除位置的迭代器失效，但是不会失效其他迭代器.解决办法两种，erase(*iter)会返回下一个有效迭代器的值，或者erase(iter++).

树形数据结构： 使用红黑树来存储数据，插入不会使得任何迭代器失效；删除运算使指向删除位置的迭代器失效，但是不会失效其他迭代器.erase迭代器只是被删元素的迭代器失效，但是返回值为void，所以采用erase(iter++)。
```
