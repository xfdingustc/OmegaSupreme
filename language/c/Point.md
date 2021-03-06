***
test.c文件中包括如下语句：
``` C
#define INT_PTR int*
typedef int* int_ptr;
INT_PTR a, b;
int_ptr c, d;
```
文件中定义的四个变量，哪个变量不是指针类型？
```
A. a
B. b
C. c
D. d
```

** 答案: B **
#define为宏定义指令 int*为宏体是整型指针，INT_PTR为宏名；经过预处理，进行宏替换，INT_PTR a,b;替换为int* a,b;故a是整型指针而b是整型。
typedef作用是给已存在的数据类型引入一个别名，语法 typedef 已有类型名 类型别名，所以 int_ptr
是int*整型指针类型的别名。
***

定义一个函数指针，指向的函数有两个int形参并且返回一个函数指针，返回的指针指向一个有一个int形参且返回int的函数？
``` C
A. int (*(*F)(int, int))(int)
B. int (*F)(int, int)
C. int (*(*F)(int, int))
D. *(*F)(int, int)(int)
```
**答案：A**

首先，一个函数指针，指向的函数有两个int形参，这个就是`(*F)(int, int)`，这返回的是一个指针
返回一个函数指针，返回的指针指向一个有一个int形参且返回int的函数；把上面的结果当成一个指针，相当于再做一次上面的步骤，所以结果为：`int (*(*F)(int, int))(int)`

针对A, 先看优先级最高的,即内部括号`(*F)`,看出F是一个指针,然后再看右边`(int , int)`,说明它是一个函数指针,`(int,int)`为此函数的形参列表.(*(*F)(int, int) ) .再往外看, (*F)(int, int)   括号外面* 表示这又是一个指针,而且去掉这一部分剩下   
int (*)(int)
这是一个典型的函数指针, 参数int ,返回值int.   那就是说 函数指针F 指向的函数(函数1) 有两个int,然后这个函数(函数1) 返回值  又是一个函数指针,这个函数指针的原型函数(函数2)是int fun(int).
其实本质就是函数指针 指向  一个 返回函数指针的函数


***

声明一个指向含有10个元素的数组的指针，其中每个元素是一个函数指针，该函数的返回值是int，参数是int*，正确的是（）
```
A.（int *p[10]）（int*）
B. int [10]*p（int *）
C. int (*(*p)[10])(int *)
D. int ((int *)[10])*p
E. 以上选项都不正确
```
**答案：C**

 首先题目说要声明一个数组指针,  一般我们想到的数组指针是 随便来一个 int(*p)[10], 然后又说每个元素是一个函数指针,那么我们随便来一个 函数指针  int (*pf)(int *) . 然后把(*p)[10]作为一个整体替代 pf     即   int(*(*p)[10]))(int *);    分析: 判断一个复杂式子看最高优先级的,*p是一个指针,然后(*p)外面是[],所以是数组指针,(*p)[10])描述完毕,然后再看外面int(*)(int *)很明显,这是一个函数指针,所以这个数组中每个元素是函数指针
***

下面程序的输出是什么？
``` C
int main(void) {
  int a[5] = {1, 2, 3, 4, 5};
  int *ptr = (int *)(&a + 1);
  printf("%d, %d", *(a + 1), *(ptr - 1));
  return 0;
}
```

```
A. 2 1
B. 2 5
C. 1 2
D. 5 2
```
**答案：B**

*(a+1)就是a[1],输出为2。这个不难，关键在于(&a + 1)的分析。
大家都知道，指针+1所得结果要根据指针类型加上一定的值，不同类型的指针+1之后增加的大小不同，a是长度为5的int数组指针，所以要加5*sizeof(int)，所以第四行语句执行后，ptr指向a[5]；最后输出时，即*(ptr - 1)时，ptr为int型指针，则-1操作减少sizeof(int *),指向a[4]，输出为5。
***



有以下程序
``` C
#include <stdio.h>
void fun ( int ﹡p,int ﹡q ) {
  int t ;
  t ＝ ﹡p;
  ﹡p ＝ ﹡q;
  ﹡q ＝ t;
  ﹡q ＝ ﹡p;
｝
main () {
  int a ＝ 0,b ＝ 9;
  fun (&a,&b );
  printf ( "%d %d＼n",a,b);
}
```
程序的输出结果是?


```
A. 9 0
B. 0 0
C. 9 9
D. 0 9
```

**答案：C**

t ＝ ﹡p;
﹡p ＝ ﹡q;
﹡q ＝ t;
以上三个赋值表达式实现了a和b数值的对调，对调之后*p=9,*q=0.
又执行下一步赋值语句，将此时p指向的值赋值给q指向的值
﹡q ＝ ﹡p;
将9赋值给*q，所以两个都是9

***
下面一段代码的输出结果是
``` C
void f( char* c, char d ){
  *c = *c + 1;
  d = d + 1;
  cout<< *c << d;
}
void main() {
  char a = 'A' , b = 'a';
  f(&b,a);
  cout<<a<<b<<endl;
}
```

```
A. BaBa
B. aBaB
C. AbAb
D. bBAb
```

**答案：D**

f(&b,a)中打印 "bB"
cout<<a<<b<<endl;打印"Ab"，因为 f函数 通过指针改变了b的值，但是a只是作为d的一个副本并没有改变。
***
