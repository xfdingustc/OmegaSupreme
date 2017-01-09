***
单链表的每个结点中包括一个指针link，它指向该结点的后继结点。现要将指针q指向的新结点插入到指针p指向的单链表结点之后，下面的操作系列中哪一个是正确的？
``` C
A. q = p->link; p->link = q->link
B. p = p->link = q->link; p->link
C. q->link = p->link; p->link = q;
D. p->link = 1; q->link = p->link
```

**答案: C**

首先应该让新结点q的link指向p的link也就是q->link = p->link;
然后再让p的link指向q即可.也就是p->link = p;
***
