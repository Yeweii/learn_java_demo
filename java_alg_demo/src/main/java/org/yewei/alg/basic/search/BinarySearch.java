package org.yewei.alg.basic.search;

import java.util.Arrays;

public class BinarySearch {
    /**
     * 给定一个长度为 n 的数组 nums ，元素按从小到大的顺序排列且不重复。
     * 请查找并返回元素 target 在该数组中的索引。若数组不包含该元素，则返回 -1
     */
    int binarySearch(int[] nums, int target) {
        // 初始化双闭区间[0, n -1 ]=, 即i, j分别只想数组首元素及尾元素
        int i = 0, j = nums.length - 1;
        // 循环，当搜索区间为空时跳出（当 i > j 时为空）
        while (i <= j) {
            // 二分的mid有3种写法：
            //
            //mid=(left+right)/2
            //mid=left+(right-left)/2
            //mid= left + ((right-left) >> 1
            int m = i + (j - i) / 2; // 计算中点索引m
            if (nums[m] < target) {
                i = m + 1;
            } else if (nums[m] > target) {
                i = m - 1;
            } else {
                return m;
            }
        }
        // 未找到目标元素返回-1
        return -1;
    }

    public static void main(String[] args) {
        int [] a = {1, 7, 11, 22, 45, 78, 134,1345};
        BinarySearch binarySearch = new BinarySearch();
        int i = binarySearch.binarySearch(a, 78);
        System.out.println(i);
    }




}
