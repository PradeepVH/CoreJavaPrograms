
public class CountingSort {

    public static void main(String[] args) {
        int a[] = { 1, 4, 1, 2, 7, 5, 2 };
        System.out.println("Before sorting array elements are - ");
        printElements(a);
        countingSort(a);
        System.out.println("\nAfter sorting array elements are - ");
        printElements(a);

    }

    private static void printElements(int[] a) {
        for (int i : a) {
            System.out.print(i+ " ");
        }
    }

    private static void countingSort(int[] a) {
        int[] finalArray = new int [a.length + 1];

        //Find maximum element
        int max = a[0];
        for(int i = 1; i<a.length; i++) {
            if(a[i] > max)
               max = a[i];
        }

        int[] countArray = new int [max + 1]; // Count array
        for (int i = 0; i <= max; i++) {
            countArray[i] = 0;                // Initialize count array with all zeros
        }
        for (int i = 0; i < a.length; i++) { // Store the count of each element
            countArray[a[i]]++;
        }
        for (int i = 1; i <=max; i++) {
            countArray[i] += countArray[i-1]; //find cumulative frequency
        }
        /* This loop will find the index of each element of the original array in
            count array, and place the elements in output array*/
        for (int i = a.length - 1; i >= 0; i--) {
            finalArray[countArray[a[i]] - 1] = a[i];
            countArray[a[i]]--;                       // decrease count for same numbers
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = finalArray[i];
        }
    }
}
