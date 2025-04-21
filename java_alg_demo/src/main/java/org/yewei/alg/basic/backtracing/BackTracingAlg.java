package org.yewei.alg.basic.backtracing;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class BackTracingAlg {

    /**
     * 输入一个整数数组，其中不包含重复元素，返回所有可能的排列。
     * @param state
     * @param choices
     * @param selected
     * @param res
     */
    public void backtrack(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res) {

        // 当状态长度 = 元素数量时， 记录解
        if (state.size() == choices.length) {
            res.add(new ArrayList<>(state));
            return;
        }

        // 遍历所有选择
        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            // 剪枝，不允许重复选择元素
            if (!selected[i]) {
                // 尝试：做出选择，更新状态
                selected[i] = true;
                state.add(choice);
                // 在进行下一轮选择
                backtrack(state, choices, selected, res);
                // 回退： 撤销选择，恢复到之前的状态
                selected[i] = false;
                state.remove(state.size() - 1);
            }
        }
    }

    /* 全排列 I */
    List<List<Integer>> permutationsI(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(new ArrayList<Integer>(), nums, new boolean[nums.length], res);
        return res;
    }

    public static void main(String[] args) {
        BackTracingAlg backTracingAlg = new BackTracingAlg();
        List<List<Integer>> lists = backTracingAlg.permutationsI(new int[]{1, 2, 3, 4, 5, 6});
        Gson gson  = new Gson();
        System.out.println(gson.toJson(lists));
    }
}
