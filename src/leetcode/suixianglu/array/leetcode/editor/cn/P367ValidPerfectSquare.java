//给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。 
//
// 不能使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
//解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
//解释：返回 false ，因为 3.742 * 3.742 = 14 但 3.742 不是一个整数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 619 👎 0

package leetcode.suixianglu.array.leetcode.editor.cn; // 匹配插件自动生成的目录结构

import java.util.*;

//Java：有效的完全平方数
public class P367ValidPerfectSquare{
    public static void main(String[] args) {
        Solution solution = new P367ValidPerfectSquare().new Solution();
        // TEST
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int right = num / 2 + 1; // 算术平方根一定在[1, right)
        int squartAbout = binarydSearch(right, num);
        return squartAbout * squartAbout == num;
    }

    // 返回x的完全平方数（向下取整）
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