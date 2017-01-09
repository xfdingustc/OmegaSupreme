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
