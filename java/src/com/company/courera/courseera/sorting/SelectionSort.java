package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        var arr = new int[]{5, 3, 3, 4, 2, 1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIdx = findSmallestIdx(nums, i, nums.length);
            swap(nums, minIdx, i);
        }
    }

    public static int findSmallestIdx(int[] arr, int left, int right) {
        int min = left;
        for (int i = left + 1; i < right; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
        return min;
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
