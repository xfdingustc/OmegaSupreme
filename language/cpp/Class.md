***
下面对静态数据成员的描述中，正确的是?
```
A. 静态数据成员可以在类体内进行初始化
B. 静态数据成员不可以被类的对象调用
C. 静态数据成员不受private控制符的作用
D. 静态数据成员可以直接用类名调用
```
**答案：D**

static数据成员必须在类体之外进行定义。通常在定义时才进行初始化。但是，当类型为const static时的整形时可以在类体内进行初始化。因此A有正确的地方，但是也有错误的情况，因此不选A。
***


下面有关友元函数与成员函数的区别，描述错误的是？
```
A. 友元函数可以让本类被友元类对象调用
B. 友元函数和类的成员函数都可以访问类的私有成员变量或者是成员函数
C. 类的成员函数是属于类的，调用的时候是通过指针this调用的
D. 友元函数是有关键字friend修饰，调用的时候也是通过指针this调用的
```

**答案：D**

类的友元函数的访问权限跟类内部的方法相同，但是友元函数不属于本类的对象，一般它是另一个类的成员函数，不能通过本类的this指针进行访问。
***


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

**答案: D**

类的实例化：cla *p = new cla，p分配在栈上，p指向的对象分配在堆上。
n为静态成员变量，没有this指针，属于类域，所有对象共享。
实例化——调用构造函数，所以n++；
delete——调用析构函数，所以n--。
最后输仍旧为0。
***


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
***
