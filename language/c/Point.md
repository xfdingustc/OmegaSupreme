### 题
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
