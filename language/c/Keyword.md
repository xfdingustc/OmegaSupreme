***
下面程序会输出什么：
``` C
static int a=1;
void fun1(void) { a=2; }
void fun2(void) { int a=3; }
void fun3(void) { static int a = 4; }
int main(int argc,char** args) {
  printf(“%d”,a);
  fun1( );
  printf(“%d”,a);
  fun2( );
  printf(“%d”，a);
  fun3( );
  printf(“%d”,a);
}
```
```
A. 1 2 3 4
B. 1 2 2 2
C. 1 2 2 4
D. 1 1 1 4
```

**答案: B**
```C
printf(“%d”,a); //输出全局静态变量，所以输出1
fun1( );     //a=2所以会修改全局静态变量，输出2
printf(“%d”,a);
fun2( );     //int a=3是在func2里的局部变量，所以调用结束就释放了，不影响全局的a值，所以输出2
printf(“%d”，a);
fun3( );    //也是局部变量，虽然是静态的但是不会影响全局a的值，仍然输出2
printf(“%d”,a);
```
***

对下列语句正确的描述是?
``` C
const int *x;   //1
int * const x;   //2
```

```
A. 语句1的含义是指针变量x不能更改
B. 语句2的含义是指针变量x所指向的值不能更改
C. 语句2的含义是指针变量x不能更改
D. 语句1和2相同含义的不同定义方式
```
**答案：C**

const修饰离它最近的对象，

1)语句，const修饰的是int \*x，指针变量x指向整型常数，x的值可以改变，但不能试图改变指向的整型常数；

2)语句，const修饰的是x，指针变量x的值不能改变。

口诀：左数又指 当const出现在\*号左边时，指针指向的数据为常量 当const出现在\*号右边时，指针本身为常量
***
