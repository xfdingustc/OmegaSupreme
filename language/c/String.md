***
若有以下定义和语句：
``` C
char s1[]="12345",*s2="1234";
printf("%d\n" ,strlen(strcpy(s1,s2)));
```
```
A. 4
B. 5
C. 9
D. 10
```

**答案: A**

strcpy(s1,s2)这个函数是把s2字符串拷贝到s1这个字符串，同时也把s2的 '\0' 拷过去，所以覆盖了s1的所有字符（在空间足够的情况下，当然遇到s1的空间不足以存放s2，另考虑），所以strcpy执行完后是“1234” strlen("1234")  就是4了
***




``` C
void GetMemeory(char* p) {
    p = (char*) malloc (100);
｝
void test() {
    char *str = NULL;
    GetMemory(str);
    strcpy(str, "Thunder");
    strcat(str + 2, "Downloader");
    printf(str);
}
```

请问运行Test函数结果是：
```
A. Thunder Downloader
B. under Downloader
C. Thunderownloader
D. 程序崩溃
```

**答案：D**

如果需要改变str,改变变量用一级指针,改变指针用二级指针,但传入的是一级指针,所以没有对str中存放的地址NULL进行改变,所以后面执行strcmp和strcat的内容会让程序崩溃
***

### 题目 微软
下面程序运行的结果是什么：
``` C
char *f(char *str , char ch) {
  char *it1 = str;
  char *it2 = str;
  while(*it2 != '\0') {
    while(*it2 == ch) {
      it2++;
    }
    *it1++ = *it2++;
  }
  return str;
}

int main(void) {
  char *a = new char[10];
  strcpy(a , "abcdcccd");
  cout<<f(a, 'c');
  return 0;
}
```
```
A. abdcccd
B. abdd
C. abcc
D. abddcccd
E. 越界
```
**答案： D**

str，ite1,ite2指向的内存为同一块内存，初始化时，都指向“abcdcccd”,循环进行：
1. ite1指向内存第一个位置a,ite2指向a,所以ite指向内容修改为a,str指向abcdcccd，ite1,ite2右移
2. ite1指向内存第二个位置b,ite2指向b,所以ite指向内容修改为b,str指向abcdcccd，ite1,ite2右移
3. ite1指向内存第三个位置c，ite2指向c等于ch继续右移指向d,所以ite指向内容修改为d，str指向adddcccd，ite1,ite2右移
4. ite1指向内存第四个位置d,ite2指向c等于ch继续右移直到指向d，所以ite指向内容修改为d，str指向abddcccd，ite1,ite2右移
5. 退出

***
下面程序的输出是：（）
``` C
char s[] = "Welcometohengtian";
printf("%s%d",s + 7,sizeof(s));
```

```
A. Welcometohengtian17
B. tohengtian18
C. tohengtian17
D. Welcometohengtian18
```

**答案： B**
