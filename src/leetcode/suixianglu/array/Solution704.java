package leetcode.suixianglu.array;

public class Solution704 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length; // 左闭右开
        int mid = 0;
        while (l < r) { // 没有等于号，每次循环缩小的范围不能包含mid
            mid = l + ((r - l) >> 1);
            if (target > nums[mid]) { // 目标在右侧，更新左边界
                l = mid + 1;
            } else if (target < nums[mid]) { // 目标在左侧，更新右边界
                r = mid; // 若 r = mid - 1 ，则会漏掉nums[mid - 1]元素。
            } else { // 找到目标，返回索引
                return mid;
            }
        }

        return -1;
    }
}
