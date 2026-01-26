//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 1743 👎 0

package leetcode.suixianglu.array.leetcode.editor.cn; // 匹配插件自动生成的目录结构

import java.util.*;

//Java：x 的平方根 
public class P69Sqrtx{
    public static void main(String[] args) {
        Solution solution = new P69Sqrtx().new Solution();
        // TEST
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int right = x / 2 + 1; // 算术平方根一定在[1, right)
        return binarydSearch(right, x);
    }

    public int binarydSearch(int right, int x) {
        int l = 1, r = right, mid = 0; // 左闭右开
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if ((long)mid * mid <= x) { // 避免整数溢出
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}