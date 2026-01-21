public class SearchingAlgorithms {

    public static int binarySearchIterative(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // not found
    }

    public static int binarySearchRecurisve(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1; // base case: not found
        }

        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (target < arr[mid]) {
            return binarySearchRecurisve(arr, low, mid - 1, target);
        } else {
            return binarySearchRecurisve(arr, mid + 1, high, target);
        }
    }

    public static int linearSearchRecursive(int[] arr, int target, int index) {
        if (index == arr.length) {
            return -1; // base case: not found
        }

        if (arr[index] == target) {
            return index;
        } else {
            return linearSearchRecursive(arr, target, index + 1); // recursive call
        }
    }


    public static int findMinRecursive(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index]; // base case: last element
        }

        int minRest = findMinRecursive(arr, index + 1);

        if (arr[index] < minRest) {
            return arr[index];
        } else {
            return minRest;
        }
    }

    public static int findMaxRecursive(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index]; // base case: last element
        }

        int maxRest = findMaxRecursive(arr, index + 1);

        if (arr[index] > maxRest) {
            return arr[index];
        } else {
            return maxRest;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 12, 20, 25, 30};

        // binary search iterative
        int target1 = 20;
        int resultIter = binarySearchIterative(arr, target1);
        if (resultIter == -1) {
            System.out.println("binary search iterative: not found");
        } else {
            System.out.println("binary search iterative: found at index " + resultIter);
        }

        // binary search recursive
        int target2 = 25;
        int resultRec = binarySearchRecurisve(arr, 0, arr.length - 1, target2);
        if (resultRec == -1) {
            System.out.println("binary search recursive: not found");
        } else {
            System.out.println("binary search recursive: found at index " + resultRec);
        }

        // recursive linear search
        int target3 = 12;
        int resultLinear = linearSearchRecursive(arr, target3, 0);
        if (resultLinear == -1) {
            System.out.println("recursive linear search: not found");
        } else {
            System.out.println("recursive linear search: found at index " + resultLinear);
        }

        // find min and max using recursion
        int min = findMinRecursive(arr, 0);
        int max = findMaxRecursive(arr, 0);
        System.out.println("minimum value: " + min);
        System.out.println("maximum value: " + max);

    }
}