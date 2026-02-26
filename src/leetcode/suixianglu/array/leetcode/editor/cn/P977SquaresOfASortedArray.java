//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
//
// Related Topics 数组 双指针 排序 👍 1161 👎 0

package leetcode.suixianglu.array.leetcode.editor.cn; // 匹配插件自动生成的目录结构

import java.util.*;

//Java：有序数组的平方
public class P977SquaresOfASortedArray{
    public static void main(String[] args) {
        Solution solution = new P977SquaresOfASortedArray().new Solution();
        // TEST
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int count = nums.length - 1;

        int l = 0;
        int r = nums.length - 1;
        // 剩余数中，平方数的最大值一定位于首/尾
        while (l <= r) {
            int squareL = nums[l] * nums[l];
            int squareR = nums[r] * nums[r];
            if (squareL < squareR) { // 平方数最大值位于尾
                result[count--] = squareR;
                r--;
            } else { // 平方数最大值位于首
                result[count--] = squareL;
                l++;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}