***
有如下一段代码:
``` C
#define ADD(x,y) x+y
int m = 3;
m += m * ADD(m,m);
```
则m的值为:
```
A. 15
B. 12
C. 18
D. 58
```

**答案 A**

m+= m\*m + m
m+= 3\*3 + 3
m =3 + 12
***
