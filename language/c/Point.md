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
