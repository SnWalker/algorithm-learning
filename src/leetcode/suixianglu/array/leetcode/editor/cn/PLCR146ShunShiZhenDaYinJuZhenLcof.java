//给定一个二维数组 array，请返回「螺旋遍历」该数组的结果。 
//
// 螺旋遍历：从左上角开始，按照 向右、向下、向左、向上 的顺序 依次 提取元素，然后再进入内部一层重复相同的步骤，直到提取完所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：array = [[1,2,3],[8,9,4],[7,6,5]]
//输出：[1,2,3,4,5,6,7,8,9]
// 
//
// 示例 2： 
//
// 
//输入：array  = [[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]]
//输出：[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= array.length <= 100 
// 0 <= array[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode.cn/problems/spiral-matrix/ 
//
// 
//
// Related Topics 数组 矩阵 模拟 👍 617 👎 0

package leetcode.suixianglu.array.leetcode.editor.cn; // 匹配插件自动生成的目录结构

//Java：螺旋遍历二维数组
public class PLCR146ShunShiZhenDaYinJuZhenLcof{
    public static void main(String[] args) {
        Solution solution = new PLCR146ShunShiZhenDaYinJuZhenLcof().new Solution();
        // TEST
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 模拟 ： 方向数组法
    // 遍历一圈 = 提取 + 试探 + 是否碰壁 + 前进一步
    public int[] spiralArray(int[][] array) {
        // 判空防越界
        if (array == null || array.length == 0 || array[0].length == 0) {
            return new int[0];
        }

        // 定义4个方向：右、下、左、上
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 方向数组
        int directionIndex = 0; // 方向索引

        int m = array.length; // 行
        int n = array[0].length; // 列
        int count = m * n;
        int[] res = new int[count];
        int i = 0;
        int row = 0, col = 0; // 起点

        while (i < count) {
            // 提取
            res[i] = array[row][col];
            array[row][col] = Integer.MIN_VALUE; // 标记已被提取
            // 试探
            int nextRow = row + directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];
            // 碰壁（5）种情况
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || array[nextRow][nextCol] == Integer.MIN_VALUE) {
                directionIndex = (directionIndex + 1) % 4;
            }
            // 前进一步
            row = row + directions[directionIndex][0];
            col = col + directions[directionIndex][1];
            i++;

        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}