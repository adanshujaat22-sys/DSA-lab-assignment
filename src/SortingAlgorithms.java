import java.util.Arrays;

public class SortingAlgorithms {

    // merge sort function: divides array and merges
    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(arr, start, mid);

        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    // merge function: merges two sorted subarrays
    public static void merge(int[] arr, int start, int mid, int end) {
        int[] merged = new int[end - start + 1];

        int idx1 = start;
        int idx2 = mid + 1;
        int x = 0;

        while (idx1 <= mid && idx2 <= end) {
            if (arr[idx1] <= arr[idx2]) {
                merged[x] = arr[idx1];
                idx1++;
            } else {
                merged[x] = arr[idx2];
                idx2++;
            }
            x++;
        }

        while (idx1 <= mid) {
            merged[x] = arr[idx1];
            idx1++;
            x++;
        }

        while (idx2 <= end) {
            merged[x] = arr[idx2];
            idx2++;
            x++;
        }

        for (int i = 0, j = start; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    // quick sort function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);

            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // pivot element
        int idx = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                idx++;
                swap(arr, idx, j);
            }
        }

        idx++;
        swap(arr, idx, high);

        return idx;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 1, 4, 2, 8};
        int[] arr2 = Arrays.copyOf(arr1, arr1.length); // copy for quick sort

        // merge sort
        mergeSort(arr1, 0, arr1.length - 1);
        System.out.println("merge sorted array: " + Arrays.toString(arr1));

        // quick sort
        quickSort(arr2, 0, arr2.length - 1);
        System.out.println("quick sorted array: " + Arrays.toString(arr2));

        // comparison
        System.out.println("comparison:");
        System.out.println("merge sort: time complexity is o(n log n) and space complexity is o(n)");
        System.out.println("quick sort: time complexity is o(n log n) average, o(n^2) worst and space complexity is o(log n)");
    }
}