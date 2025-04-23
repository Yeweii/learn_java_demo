package org.yewei.alg.basic.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTracingAnswer {

    /**
     * 给定一个正整数数组 nums 和一个目标正整数 target ，
     * 请找出所有可能的组合，使得组合中的元素和等于 target 。
     * 给定数组无重复元素，每个元素可以被选取多次。请以列表形式返回这些组合，列表中不应包含重复组合。
     * 注意：输入集合中的元素可以被无限次重复选取。
     * 子集不区分元素顺序
     *
     * 在开启搜索前，先将数组 nums 排序。在遍历所有选择时，当子集和超过 target 时直接结束循环，因为后边的元素更大，其子集和一定超过 target 。
     * 省去元素和变量 total ，通过在 target 上执行减法来统计元素和，当 target 等于0时记录解。
     */
    /* 回溯算法：子集和 I */
    void backtrack(List<Integer> state, int target, int[] choices, int start, List<List<Integer>> res) {
        // 子集和等于target时，记录解
        if (target == 0) {
            res.add(new ArrayList<>(state));
            return;
        }

        // 遍历所有选择
        // 剪枝二： 从start开始遍历，避免生成重复子集
        for (int i = start; i < choices.length; i++) {
            // 剪枝一： 若子集和超过target,则直接结束循环。PS: 数组已经排序，后面元素更大，子集和必然超过target
            if (target - choices[i] < 0) {
                break;
            }
            // 尝试： 做出选择，更新target， start
            state.add(choices[i]);
            // 下一轮选择
            backtrack(state, target - choices[i], choices, i, res);
            // 回退： 撤销选择，恢复之前的状态
            state.remove(state.size() - 1);
        }
    }



    List<List<Integer>> subsetSumI(int[] nums, int target) {
        // 状态（子集）
        List<Integer> state = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        // 遍历起始点
        int start = 0;
        // 结果列表（子集列表）
        List<List<Integer>> res = new ArrayList<>();
        backtrack(state, target, nums, start, res);
        return res;
    }

}
