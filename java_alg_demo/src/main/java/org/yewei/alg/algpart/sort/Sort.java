package org.yewei.alg.algpart.sort;

public class Sort {

    /**
     * 选择排序
     * 工作原理非常简单：开启一个循环，每轮从未排序区间选择最小的元素，将其放到已排序区间的末尾。
     */
    void selectionSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
             int min = i;
             for(int j = i + 1; j < nums.length; j++) {
                 if(nums[j] < nums[min]) {
                     min = j;
                 }
             }
            // 将该最小元素与未排序区间的首个元素交换
            swap(nums, i, min);
        }
    }

    /**
     * 交换两个元素的值
     * @param nums
     * @param i
     * @param min
     */
    private static void swap(int[] nums, int i, int min) {
        int tmp = nums[i];
        nums[i] = nums[min];
        nums[min] = tmp;
    }

    /**
     * 从数组最左端开始向右遍历，依次比较相邻元素大小，如果“左元素 > 右元素”就交换二者。遍历完成后，最大的元素会被移动到数组的最右端。
     * 冒泡排序
     */
    public void bubbleSort(int[] nums) {
        int length = nums.length;
        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(nums[j] > nums[i]) {
                    swap(nums, j, i);
                }
            }
        }
    }

    /**
     * 插入排序
     * 初始状态下，数组的第 1 个元素已完成排序。
     * 选取数组的第 2 个元素作为 base ，将其插入到正确位置后，数组的前 2 个元素已排序。
     * 选取第 3 个元素作为 base ，将其插入到正确位置后，数组的前 3 个元素已排序。
     * 以此类推，在最后一轮中，选取最后一个元素作为 base ，将其插入到正确位置后，所有元素均已排序。
     */
    public void insertSort(int[] nums) {
        int length = nums.length;
        // 外循环：已排序区间为 [0, i-1]
        for (int i = 1; i < length; i++) {
            int base = nums[i];
            int j = i - 1;
            // 内循环：将 base 插入到已排序区间 [0, i-1] 中的正确位置
            while(j >= 0 && nums[j] > base) {
                // 将 nums[j] 向右移动一位
                nums[j + 1] = nums[j];
                j--;
            }
            // 将 base 赋值到正确位置
            nums[j + 1] = base;
        }

    }


    /**
     * 归并排序
     */



}
