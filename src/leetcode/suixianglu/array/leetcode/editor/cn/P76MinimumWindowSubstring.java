//给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，使得该子串包含 t 中的每一个字符（包括重复字符）。如果没有这样的子串，
//返回空字符串 ""。 
//
// 测试用例保证答案唯一。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//O(m + n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 3505 👎 0

package leetcode.suixianglu.array.leetcode.editor.cn; // 匹配插件自动生成的目录结构

import java.util.*;

//Java：最小覆盖子串
public class P76MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        // TEST
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 滑动窗口
    // 指针r延伸窗口，直至满足条件才停下；
    // 指针l缩小窗口，直至不满足条件或者遇到r才停下。
    // 滑动窗口可枚举出所有满足条件的情况，在l移动时不断更新答案。

    // 哈希表统计串s、t中字母数量
    // 若targetMap中的字符在currentMap中都有，且currentMap中的数量>=targetMap中的数量，则当前窗口[l, r]是一个覆盖子串
    Map<Character, Integer> targetMap = new HashMap<>(); // t中字符及其的数量
    Map<Character, Integer> currentMap = new HashMap<>(); // 当前窗口的字符及其数量（即s串的子串[l, r]）

    public String minWindow(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        while (r < sLen) { // 指针r向右移动，延伸窗口
            r++;
            if (r < sLen && targetMap.containsKey(s.charAt(r))) {
                currentMap.put(s.charAt(r), currentMap.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) { // targetMap中的字符在currentMap中都有，且currentMap中的数量>=targetMap中的数量时check()返回true
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = r;
                }
                // 指针l向右移动，收缩窗口
                if (targetMap.containsKey(s.charAt(l))) {
                    currentMap.put(s.charAt(l), currentMap.getOrDefault(s.charAt(l), 0) - 1);
                }
                l++;
            }
        }

        return ansL == -1 ? "" : s.substring(ansL, ansR + 1); // s.substring()左闭右开
    }

    // targetMap中的字符在currentMap中都有，且currentMap中的数量>=targetMap中的数量时check()返回true
    public boolean check() {
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            if (currentMap.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        /*Iterator iter = targetMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (currentMap.getOrDefault(key, 0) < val) {
                return false;
            }
        }*/
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}