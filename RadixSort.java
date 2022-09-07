
public class RadixSort {

    public static void main(String[] args) {
        int a[] = { 151, 259, 360, 91, 115, 706, 34, 858, 2 };
        System.out.println("Before sorting array elements are - ");
        printElements(a);
        radixSort(a);
        System.out.println("\nAfter sorting array elements are - ");
        printElements(a);

    }

    private static void printElements(int[] a) {
        for (int i : a) {
            System.out.print(i+ " ");
        }
    }

    private static void radixSort(int[] a) {
        //Find maximum element
        int max = a[0];
        for(int i = 1; i<a.length; i++) {
            if(a[i] > max)
                max = a[i];
        }
        for (int place = 1; max/place > 0 ; place*=10) {
            countingSort(a, a.length, place);
        }
    }

    private static void countingSort(int[] a, int length, int place) {
        int[] finalArray = new int [a.length + 1];
        int[] countArray = new int [10]; // Count array

        for (int i = 0; i < a.length; i++) { // Store the count of each element
            countArray[(a[i] / place)%10]++;
        }
        for (int i = 1; i < 10; i++) {
            countArray[i] += countArray[i-1]; //Find cumulative frequency
        }

        // Place the elements in sorted order
        for (int i = a.length - 1; i >= 0; i--) {
            finalArray[countArray[(a[i] / place) % 10] - 1] = a[i];
            countArray[(a[i] / place) % 10]--;       // decrease count for same numbers
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = finalArray[i];
        }
    }
}
