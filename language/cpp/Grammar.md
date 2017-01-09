***
下面哪段代码是正确的
``` C
A. int f() { int *a = new int(3); return *a; }
B. int *f() { int a[3] = {1, 2, 3}; return a; }
C. vector<int> f() {vector<int> v(3); return v; }
D. void f(int *ret) { int a[3] = {1, 2, 3}; ret = a; return; }
```
**答案: C**

A：和大家说的一样，new申请的内存在离开作用域时由于没有delete，导致内存泄漏。（这块内存对于系统来说是被占用的，但是实际上已经没有人使用了，所以这块内存永远无法释放！有兴趣的可以看看malloc的源码分析）
B：数组不能复制和拷贝
C：vector容器可以复制或拷贝
D：同B
当函数参数实例化形参或者函数返回值时，一般调用对象的拷贝构造函数！
***
