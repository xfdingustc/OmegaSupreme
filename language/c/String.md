### 题目1
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

** 答案：D **

如果需要改变str,改变变量用一级指针,改变指针用二级指针,但传入的是一级指针,所以没有对str中存放的地址NULL进行改变,所以后面执行strcmp和strcat的内容会让程序崩溃
