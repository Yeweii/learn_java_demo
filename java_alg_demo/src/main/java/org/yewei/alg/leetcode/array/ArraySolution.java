package org.yewei.alg.leetcode.array;

/**
 * array solutions for leetcode.
 */
public class ArraySolution {
    /**
     * the numbers of array problems are [
     *
     *
     */

    /**
     * 使用冒泡排序算法对整数数组进行排序。
     *
     * @param array 待排序的整数数组。
     */
    public void bubbleSort(int[] array) {
        // 外层循环控制遍历的轮数
        for (int i = 0; i < array.length; i++) {
            // 内层循环进行相邻元素的比较和交换
            for (int j = 0; j < array.length - i - 1; j++) {
                // 如果前一个元素大于后一个元素，则交换它们的位置
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    /**
     * 插入排序
     * @param array
     */
    public int[] insertSort(int[] array) {





        return array;
    }


    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        ArraySolution solution = new ArraySolution();
        solution.bubbleSort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }







}
