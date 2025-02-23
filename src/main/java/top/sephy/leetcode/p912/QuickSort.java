package top.sephy.leetcode.p912;

import java.util.Random;

public class QuickSort {

    static class Solution1 {

        static void quickSort(int[] arr, int left, int right) {
            if (left < right) {
                int pivotIndex = partition(arr, left, right);
                quickSort(arr, left, pivotIndex - 1);
                quickSort(arr, pivotIndex + 1, right);
            }
        }

        static int partition(int[] arr, int left, int right) {
            int pivot = arr[right]; // 选择最右边的元素作为基准
            int i = left - 1; // i 指向小于 pivot 的区域的末尾

            for (int j = left; j < right; j++) {
                if (arr[j] < pivot) { // 把小于 pivot 的元素交换到左侧
                    i++;
                    swap(arr, i, j);
                }
            }

            System.out.println("place pivot to correct position");
            swap(arr, i + 1, right); // 把 pivot 放到正确位置
            return i + 1;
        }

    }

    static class Solution2 {
        static int partition(int[] arr, int low, int high) {
            int pivot = arr[high]; // 选择最右边的元素作为基准
            int i = low;
            int j = high - 1;

            if (i == j && arr[i] > pivot) {
                swap(arr, i, high);
            }

            while (i < j) {

                // 从左向右找到第一个大于 pivot 的元素
                while (i < j && arr[i] <= pivot) {
                    i++;
                }

                // 从右向左找到第一个小于 pivot 的元素
                while (i < j && arr[j] >= pivot) {
                    j--;
                }

                // 交换两个元素
                if (i < j && arr[i] >= pivot && arr[j] <= pivot) {
                    swap(arr, i, j);
                }

                // 交换 pivot 和 arr[i]
                if (i == j && arr[i] > pivot) {
                    swap(arr, i, high);
                }
            }


            return i;
        }

        static void quickSort(int[] arr, int left, int right) {
            if (left < right) {
                int pivotIndex = partition(arr, left, right);
                quickSort(arr, left, pivotIndex);
                quickSort(arr, pivotIndex + 1, right);
            }
        }
    }

    static int medianOfThree(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        if (arr[left] > arr[mid]) {
            swap(arr, left, mid);
        }
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        if (arr[mid] > arr[right]) {
            swap(arr, mid, right);
        }
        return mid; // 返回中值索引
    }

    static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        System.out.printf("swap [%d]:%d and [%d]:%d \t", i, arr[i], j, arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        printArr(arr);
    }

    // print arr
    static void printArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    // 生成指定大小的随机整数数组
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];

        // 填充数组，生成 -100 到 100 之间的随机整数
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(201) - 100; // 生成 [-100, 100) 之间的随机整数
        }

        return array;
    }

    public static void main(String[] args) {
        // generate random array

        // int[] arr = generateRandomArray(20);
        int[] arr = {5,2,3,-1};
        printArr(arr);
//        Solution1.quickSort(arr, 0, arr.length - 1);
        Solution2.quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

}
