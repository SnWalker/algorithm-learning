# 滑动窗口

**暴力法**通过2层循环枚举所有可能解的**起始位置**、**结束位置**。

滑动窗口**只枚举结束位置**，优化至一层循环。

```java
public int slidingWindow(int[] nums) { // 参数根据题目可能是 String s, int[] nums 等
    // 1. 初始化窗口状态变量
    // 可以是 int sum, int count，或者 Map<Character, Integer> window (字符题推荐用 int[] 数组替代 Map 以提升性能)
    int left = 0, right = 0;
    
    // 2. 初始化结果变量
    // 求最小值初始为 Integer.MAX_VALUE，求最大值初始为 0 或 Integer.MIN_VALUE
    int res = ...; 

    // 3. 右指针开始遍历，扩张窗口
    while (right < nums.length) {
        // c 是即将移入窗口的元素
        int c = nums[right];
        
        // 【数据更新】增大窗口，更新窗口内部的状态
        // 例如：sum += c; 或 window[c]++;
        // ...
        
        right++; // 右指针右移（注意：此后 right 的位置在实际窗口的右侧一位，窗口长度为 right - left）

        // 4. 判断当前窗口是否需要收缩 (这是每道题最核心的逻辑)
        while (/* window needs shrink / 满足特定条件 */) {
            
            // ---> 【更新结果：求最短/最小】 <---
            // 如果题目要求找满足条件的【最短】子串/子数组（如你给的这两道题），通常在这里更新结果
            // res = Math.min(res, right - left); 
            
            // d 是即将移出窗口的元素
            int d = nums[left];
            
            // 【数据更新】缩小窗口，更新窗口内部的状态
            // 例如：sum -= d; 或 window[d]--;
            // ...
            
            left++; // 左指针右移，实现窗口收缩
        }
        
        // ---> 【更新结果：求最长/最大】 <---
        // 如果题目要求找满足条件的【最长】子串/子数组，通常在这里更新结果
        // 因为走到这里时，内部的 while 循环已经结束，窗口处于刚好合法的状态
        // res = Math.max(res, right - left); 
    }

    // 5. 返回结果，注意判断 res 是否被更新过
    return res == ... ? ... : res;
}
```

