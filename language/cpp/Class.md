### 题目
有如下程序，执行后输出的结果是()
``` C
#include <iostream.h>
class cla{
    static int n;
    public:
     cla(){n++;}
    ~cla(){n--;}
    static int get_n(){return n;}
};
int cla::n= 0;
int main()
{
   cla *p =new cla;
   delete p;
   cout<<"n="<<cla::get_n()<<endl;
   return 0;
}
```

```
A. n=3
B. n=4
C. n=1
D. n=0
```

** 答案: D **
类的实例化：cla *p = new cla，p分配在栈上，p指向的对象分配在堆上。
n为静态成员变量，没有this指针，属于类域，所有对象共享。
实例化——调用构造函数，所以n++；
delete——调用析构函数，所以n--。
最后输仍旧为0。


### 题目
有如下类定义：
``` CPP
class A {
public:
  int fun1();
  virtual void fun2();
private:
  int _a1;
  static int _a2;
};
class B: public A {
public:
  virtual void fun2();
};
```
请问sizeof(B)的值为：
```
A. 20
B. 16
C. 12
D. 8
```

**答案：D**

32位系统，B继承A，包含一个int变量，同时自己里面有个虚函数指针，指向虚表；
64位系统，int还是4个字节，但是指针为8个直接，为了字节对齐所以占用16个字节
