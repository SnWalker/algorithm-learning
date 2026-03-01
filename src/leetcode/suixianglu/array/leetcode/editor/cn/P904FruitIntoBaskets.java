//你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。 
//
// 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果： 
//
// 
// 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。 
// 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到
//下一棵树，并继续采摘。 
// 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。 
// 
//
// 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：fruits = [1,2,1]
//输出：3
//解释：可以采摘全部 3 棵树。
// 
//
// 示例 2： 
//
// 
//输入：fruits = [0,1,2,2]
//输出：3
//解释：可以采摘 [1,2,2] 这三棵树。
//如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
// 
//
// 示例 3： 
//
// 
//输入：fruits = [1,2,3,2,2]
//输出：4
//解释：可以采摘 [2,3,2,2] 这四棵树。
//如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
// 
//
// 示例 4： 
//
// 
//输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
//输出：5
//解释：可以采摘 [1,2,1,1,2] 这五棵树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= fruits.length <= 10⁵ 
// 0 <= fruits[i] < fruits.length 
// 
//
// Related Topics 数组 哈希表 滑动窗口 👍 829 👎 0

package leetcode.suixianglu.array.leetcode.editor.cn; // 匹配插件自动生成的目录结构

import java.util.*;

//Java：水果成篮
public class P904FruitIntoBaskets{
    public static void main(String[] args) {
        Solution solution = new P904FruitIntoBaskets().new Solution();
        // TEST
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalFruit(int[] fruits) {
        // 初始窗口状态变量
        int left = 0, right = 0;
        Map<Integer, Integer> window = new HashMap<>(); // 记录水果种类和对应数量
        // 初始结果变量
        int res = 0;

        // 右指针开始遍历，扩展窗口
        while (right < fruits.length) {
            int c = fruits[right]; // 即将移入窗口内的元素
            // 增大窗口，更新窗口内部的状态
            if (window.containsKey(c)) { // 已在篮子中
                window.put(c, window.get(c) + 1);
            } else { // 不在篮子，先不管水果种类数量，暂时放进去
                window.put(c, 1);
            }
            right++; // 右指针右移（此后right的位置位于窗口右侧一位，窗口长度为right - left）

            // 判断当前窗口是否需要收缩
            while (window.size() > 2) { // 篮子里水果种类大于2时，收缩窗口，直至种类数为2
                int d = fruits[left]; // 即将移除出窗口的元素
                // 收缩窗口，更新窗口内部的状态
                window.put(d, window.get(d) - 1);
                if (window.get(d) == 0) {
                    window.remove(d);
                }
                left++; // 左指针右移（此后left为窗口左边界）
            }

            // 更新结果，收缩后水果种类<=2
            res = Math.max(res, right - left);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}