package org.yewei.alg.basic.sort;

import com.google.gson.Gson;
import org.apache.hadoop.shaded.net.minidev.json.JSONObject;

import java.util.Arrays;

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
     * 快速排序
     * 其目标是：选择数组中的某个元素作为“基准数”，将所有小于基准数的元素移到其左侧，而大于基准数的元素移到其右侧。
     *
     *
     * 选取数组最左端元素作为基准数，初始化两个指针 i 和 j 分别指向数组的两端。
     * 设置一个循环，在每轮中使用 i（j）分别寻找第一个比基准数大（小）的元素，然后交换这两个元素。
     * 循环执行步骤 2. ，直到 i 和 j 相遇时停止，最后将基准数交换至两个子数组的分界线。
     *
     * 时间复杂度： O(nlogn)，最差O（n2)
     */
    public void quickSort(int[] nums, int left, int right) {
        // size = 1,终止递归
        if (left >= right) {
            return;
        }
        // 哨兵划分
        int pivot = partition(nums, left, right);
        // 递归左子数组，右子数组
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    /* 快速排序（尾递归优化） */
    void quickSortTail(int[] nums, int left, int right) {
        while (left < right) {
            // 哨兵划分操作
            int pivot = partition(nums, left, right);
            // 对两个子数组中较短的那个执行快速排序
            if (pivot - left < right -pivot) {
                // 递归左子数组
                quickSort(nums, left, pivot - 1);
                // 剩余未排序区间为[pivot + 1, right]
                left = pivot + 1;
            } else {
                // 递归右子数组
                quickSort(nums, pivot + 1, right);
                // 剩余未排序区间为 [left, pivot - 1]
                right = pivot - 1;
            }
        }
    }

    /**
     * 哨兵划分
     */
    int partition(int[] nums, int left, int right) {
        // 以nums[left]作为基准数
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= nums[left]) {
                // 从右向左查找首个大于基准数的元素
                j--;
            }
            while (i < j && nums[i] <= nums[left]) {
                // 由左向右查找首个大于基准数的元素
                i++;
            }
            swap(nums, i, j);
            }
        // 蒋基准数交换到两个子数组分界线
        swap(nums, i, left);
        // 返回基准数索引
        return i;
    }



    /**
     * 归并排序
     */
    public void mergeSort(int[] nums, int left, int right) {

        // 终止条件
        if (left >= right) {
            return;
        }

        // 计算中点
        int mid = left + (right - left) / 2;
        // 递归左子数组
        mergeSort(nums, left, mid);
        // 递归右子数组
        mergeSort(nums, mid + 1, right);
        // 合并阶段
        merge(nums, left, mid, right);

    }

    private void merge(int[] nums, int left, int mid, int right) {
        // 左子数组区间为[left, mid],右子数组区间为[mid+1, right]
        // 创建一个临时数组tem,用于存放合并后的结果
        int[] tmp = new int[right - left + 1];
        // 初始化左子数组和右子数组的起始索引
        int i = left, j = mid + 1, k = 0;
        // 当左右子数组都还有元素时，进行比较并将较小的元素赋值到临时数组中
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        // 将左子数组和右子数组的剩余元素复制到临时数组中
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }
        // 将临时数组的元素复制回原数组的对应区间内。
        for (k = 0; k < tmp.length; k++) {
            nums[left + k] = tmp[k];
        }
    }

    public static void main(String[] args) {
        int[] testArray = new int[] {9, 7, 10, 20, 2, 8, 11, 5};
        Sort sort = new Sort();
        sort.mergeSort(testArray, 0, 7);
        Gson gson = new Gson();
        System.out.println(gson.toJson(testArray));
    }

}
