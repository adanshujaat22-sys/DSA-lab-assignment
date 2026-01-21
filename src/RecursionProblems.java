public class RecursionProblems {

    // factorial of n
    public static int factorial(int n) {
        // base case: factorial of 1 is 1
        if (n == 1) {
            return 1;
        }
        // recursive case: n * factorial of (n-1)
        return n * factorial(n - 1);
    }

    // fibonacci at position n (0 based index)
    public static int fibonacci(int n) {
        // base case: first two positions
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        // recursive case: sum of previous two fibonacci numbers
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // sum of array elements
    public static int sumArray(int[] arr, int index) {
        // base case: index reaches array length
        if (index == arr.length) {
            return 0;
        }
        // recursive case: current element + sum of rest
        return arr[index] + sumArray(arr, index + 1);
    }

    // check if array is sorted in ascending order
    public static boolean isSorted(int[] arr, int index) {
        // base case: reached last or second last element
        if (index == arr.length - 1 || index == arr.length - 2) {
            return true;
        }
        // if current element > next element, array is not sorted
        if (arr[index] > arr[index + 1]) {
            return false;
        }
        // recursive case: check rest of the array
        return isSorted(arr, index + 1);
    }

    // recursive find minimum
    public static int findMinRec(int[] arr, int index) {
        // base case: last element
        if (index == arr.length - 1) {
            return arr[index];
        }
        // recursive case: compare current with min of rest
        int minRest = findMinRec(arr, index + 1);
        if (arr[index] < minRest) {
            return arr[index];
        } else {
            return minRest;
        }
    }

    // recursive find maximum
    public static int findMaxRec(int[] arr, int index) {
        // base case: last element
        if (index == arr.length - 1) {
            return arr[index];
        }
        // recursive case: compare current with max of rest
        int maxRest = findMaxRec(arr, index + 1);
        if (arr[index] > maxRest) {
            return arr[index];
        } else {
            return maxRest;
        }
    }

    public static void main(String[] args) {
        // factorial of 5
        int n = 5;
        int fact = factorial(n);
        System.out.println("factorial of " + n + " is " + fact);

        // fibonacci at position 6
        int pos = 6;
        int fib = fibonacci(pos);
        System.out.println("fibonacci number at position " + pos + " is " + fib);

        // sum of array elements
        int[] arrSum = {2, 4, 6, 8};
        int sum = sumArray(arrSum, 0);
        System.out.println("sum of array elements: " + sum);

        // check if array is sorted
        int[] arrSort = {3, 5, 7, 9};
        boolean sorted = isSorted(arrSort, 0);
        System.out.println("is array sorted: " + sorted);

        // find min and max in array
        int[] arrMinMax = {3, 5, 7, 9};
        int min = findMinRec(arrMinMax, 0);
        int max = findMaxRec(arrMinMax, 0);
        System.out.println("minimum value: " + min);
        System.out.println("maximum value: " + max);

    }
}