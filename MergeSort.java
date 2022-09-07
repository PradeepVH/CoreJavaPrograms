
public class MergeSort {

    public static void main(String[] args) {
        int a[] = { 92, 50, 5, 20, 11, 22 };
        System.out.println("Before sorting array elements are - ");
        printElements(a);
        mergeSort(a, 0, a.length - 1);
        System.out.println("\nAfter sorting array elements are - ");
        printElements(a);

    }

    private static void printElements(int[] a) {
        for (int i : a) {
            System.out.print(i+ " ");
        }
    }

    private static void mergeSort(int[] a, int startingIndex, int totalLength) {
        if(startingIndex < totalLength){
            int middleElementPos = startingIndex + (totalLength - startingIndex) / 2;
            mergeSort(a, startingIndex, middleElementPos);
            mergeSort(a, middleElementPos + 1, totalLength);
            sortDividedElements(a, startingIndex, middleElementPos, totalLength);
        }
    }

    private static void sortDividedElements(int[] a, int startingIndex, int middleElementPos, int totalLength) {
        // Find sizes of two subarrays to be merged
        int leftSubArraySize = middleElementPos - startingIndex + 1;
        int rightSubArraySize = totalLength - middleElementPos;

        int[] leftArrayElements = new int[leftSubArraySize];
        int[] rightArrayElements = new int[rightSubArraySize];

        //Copy elements for left and right array
        for (int i = 0; i < leftSubArraySize; i++){
            leftArrayElements[i] = a[startingIndex + i];
        }
        for (int i = 0; i < rightSubArraySize; i++){
            rightArrayElements[i] = a[middleElementPos + 1 + i];
        }

        /* Merge the temp arrays */
        int finalSortedIndex = startingIndex;
        int leftIndex = 0, rightIndex = 0;

        while(leftIndex < leftSubArraySize && rightIndex < rightSubArraySize){
            if(leftArrayElements[leftIndex] <= rightArrayElements[rightIndex]){
                a[finalSortedIndex] = leftArrayElements[leftIndex];
                leftIndex ++;
            }else{
                a[finalSortedIndex] = rightArrayElements[rightIndex];
                rightIndex ++;
            }
            finalSortedIndex ++;
        }

        //Copy remaining elements of left subarray elements to final array
        while(leftIndex < leftSubArraySize){
            a[finalSortedIndex] = leftArrayElements[leftIndex];
            leftIndex ++ ; finalSortedIndex ++;
        }

      //Copy remaining elements of right subarray elements to final array
        while(rightIndex < rightSubArraySize){
            a[finalSortedIndex] = rightArrayElements[rightIndex];
            rightIndex ++ ; finalSortedIndex ++;
        }
    }
}
