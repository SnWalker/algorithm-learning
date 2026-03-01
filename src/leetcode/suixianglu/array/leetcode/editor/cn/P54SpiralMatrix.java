//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 2075 👎 0

package leetcode.suixianglu.array.leetcode.editor.cn; // 匹配插件自动生成的目录结构

import java.util.*;

//Java：螺旋矩阵
public class P54SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
        // TEST
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        /*//方法1 圈数控制法
        // 从（startX, startY）开始，模拟顺时针转一圈，分解为4部分：上、右、下、左，4部分的边界统一为左闭右开
        List<Integer> list = new ArrayList<>();
        int m = matrix.length; // 行数
        int n = matrix[0].length; // 列数
        int loop = Math.min(m, n) / 2; // 圈数
        int startX =0, startY = 0; // 起点：每模拟一圈后，下一圈起点为(startX + 1, startY + 1)
        int offset = 1; // 偏移量：下一圈的右下角为(m - offset, n - offset)

        // 外层循环模拟走一圈：只模拟能闭合的圈
        while (loop > 0) {
            // 内层4个for循环模拟走4部分
            int i = startX;
            int j = startY;
            // 上部（左闭右开）
            for (; j < n - offset; j++) {
                list.add(matrix[startX][j]);
            }
            // 右列
            for (; i < m - offset; i++) {
                list.add(matrix[i][j]);
            }
            // 下部
            for (; j > startX; j--) {
                list.add(matrix[i][j]);
            }
            // 左列
            for (; i > startY; i--) {
                list.add(matrix[i][j]);
            }
            startX++;
            startY++;
            offset++;
            loop--;
        }

        // 若圈数为奇数，处理剩余的行/列/单个数
        if (Math.min(m, n) % 2 == 1) {
            if (startX == m - offset && startY != n - offset) {
                // 剩一行
                for (int j = startY; j <= n - offset; j++) {
                    list.add(matrix[startX][j]);
                }
            } else if (startX != m - offset && startY == n - offset) {
                // 剩一列
                for (int i = startX; i <= m - offset; i++) {
                    list.add(matrix[i][startY]);
                }
            } else {
                // 剩一个数
                list.add(matrix[startX][startY]);
            }
        }

        return list;*/


        // 方法2 边界收缩法
        // 由外向内，一圈一圈地顺时针遍历，直至边界越界
        List<Integer> list = new ArrayList<>();
        // 定义上、下、左、右4个边界，上下边界决定列、左右边界决定行
        int top = 0; // 上边界
        int bottom = matrix.length - 1; // 下边界
        int left = 0; // 左边界
        int right = matrix[0].length - 1; // 右边界

        while (true) {
            // 上部（左闭右闭）
            for (int i = left; i <= right; i++) list.add(matrix[top][i]);
            top++;
            if (top > bottom) break; // 若越界则退出
            // 右列
            for (int j = top; j <= bottom; j++) list.add(matrix[j][right]);
            right--;
            if (right < left) break; // 若越界则退出
            // 下部
            for (int i = right; i >= left; i--) list.add(matrix[bottom][i]);
            bottom--;
            if (bottom < top) break; // 若越界则退出
            // 左列
            for (int j = bottom; j >= top; j--) list.add(matrix[j][left]);
            left++;
            if (left > right) break; // 若越界则退出
        }

        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}