***
函数fun的声明为int fun(int *p[4]),以下哪个变量可以作为fun的合法参数（）
```
A. int a[4][4];
B. int **a;
C. int **a[4]
D. int (*a)[4];
```
**答案：B**

可以看出fun函数的形参是一个指针数组，也就是指针指向一个地址，地址中存放的内容也是指针。
A，二维数组，不符合
B，二级指针，也就是指针指向的内容也还是存放指针的，符合
C，二级指针数组，数组的内容是二级指针，不符合
D，数组指针，不符合
***


有以下程序
``` C
#include <stdio.h>
int funa( int a, int b) {
  return a + b;
}
int funb( int a, int b) {
  return a - b;
}
int sss(int (*t)(int,int),int x, int y){
  return (*t)(x, y);
}
main() {
  int x：
  x = sss(funa, 9, 3);
  x += sss(funb, 8, 3);
  printf("%d\n",x);
}
```
程序运行后的输出结果是?
```
A. 24
B. 23
C. 17
D. 22
```
**答案：C**

本题主要考查函数作为形参时的使用,由x= sss( funa, 9,3 );可得到x =9+ 3 = 12,而后直接传入函数funb,x = x+8-3 = 12+5 = 17。因此C选项正确。
***

对于全局函数 int f(void) ，与其完全等价的函数原型为（）
``` C
A. int &f();
B. int f(void) const;
C. const int f();
D. A、B、C都不是
```
**答案：B**
