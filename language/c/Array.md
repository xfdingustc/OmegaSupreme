### 提
32系统，函数
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
