### 题目1
``` C
void GetMemeory(char* p) {
    p = (char*) malloc (100);
｝
void test() {
    char *str = NULL;
    GetMemory(str);
    strcpy(str, "Thunder");
    strcat(str+2, "Downloader");
    printf(str);
}
```

请问运行Test函数结果是：
