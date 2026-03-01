//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1534 👎 0

package leetcode.suixianglu.array.leetcode.editor.cn; // 匹配插件自动生成的目录结构

import java.util.*;

//Java：螺旋矩阵 II
public class P59SpiralMatrixIi{
    public static void main(String[] args) {
        Solution solution = new P59SpiralMatrixIi().new Solution();
        // TEST
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        /*// 方法1 模拟：循环不变量原则 + 圈数控制法
        int[][] matrix = new int [n][n];
        int loop = n / 2;
        int startX = 0, startY = 0; // 每一圈的起点(startX, startY)
        int count = 1;
        int offset = 1; // 偏移量：右下角元素坐标(n - offset, n - offset)

        // 模拟闭合的顺时针圈
        while (loop > 0) {
            int i = startX; // 行
            int j = startY; // 列
            // 上部（左闭右开）
            for (; j < n - offset; j++) matrix[startX][j] = count++;
            // 右列
            for (; i < n - offset; i++) matrix[i][j] = count++;
            // 下部
            for (; j > startY; j--) matrix[i][j] = count++;
            // 左列
            for (; i > startX; i--) matrix[i][j] = count++;
            startX++;
            startY++;
            offset++;
            loop--;
        }
        // 若n为奇数，处理最后一个数
        if (n % 2 != 0) {
            matrix[startX][startY] = count;
        }

        return matrix;*/

        // 方法2 模拟：方向数组法
        // 填充过程 = (填数 + 看前方试探 + 碰壁就右转90度 + 前进一步)循环，直至数用完
        int maxNum = n * n; // 最大数字
        int curNum = 1; // 当前准备填入的数字
        int[][] matrix = new int[n][n];
        // 定义四个行走方向，必须是右、下、左、上（顺时针）
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 方向数组
        int directionIndex = 0; // 初始方向索引为0，也就是先向右走

        int row = 0;
        int column = 0;
        while (curNum <= maxNum) {
            // 1、在当前位置填充数字
            matrix[row][column] = curNum;
            curNum++;
            // 2、向前试探
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            // 3、判断是否碰壁（5种情况）
            // 碰到上下左右4个边界，碰到已经填充数字的位置
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                // 如果碰壁了，就顺时针转90度，即改为下一个方向向前走一步
                // ( directionIndex + 1 ) % 4， 可以让方向索引在0, 1, 2, 3之间跳动
                directionIndex = (directionIndex + 1) % 4;
            }
            // 4、前进1步
            // 如果没碰壁，沿着原方向走；如果碰了，这里用的就是刚才转弯后的新方向
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }

        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}