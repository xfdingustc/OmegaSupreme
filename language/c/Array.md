### 提
32操作系统，函数
``` C
void Func(char str[100]){}
```
中`sizeof(str)=`
```
A. 4
B. 5
C. 6
D. 7
```
** 答案：A**

数组作为参数是，数组名退化为指针
所以sizeof()结果为4


###
下列选项中，能正确定义数组的语句是：
``` C
A. #define N 2008
   int num[N];
B. int N=2008;
C. int num[0..2008];
D. int num[];
```

**答案：A**
