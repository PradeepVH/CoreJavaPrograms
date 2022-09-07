
public class Quicksort {

    public static void main(String[] args) {
        int a[] = { 92, 50, 5, 20, 11, 22 };
        System.out.println("Before sorting array elements are - ");
        printElements(a);
        quickSort(a, 0, a.length - 1);
        System.out.println("\nAfter sorting array elements are - ");
        printElements(a);

    }

    private static void printElements(int[] a) {
        for (int i : a) {
            System.out.print(i+ " ");
        }
    }

    private static void quickSort(int[] a, int startIndex, int endIndex) {

        if(startIndex < endIndex){
            int partitionIndex = partitionByPivot(a, startIndex, endIndex);
            quickSort(a, startIndex, partitionIndex -1);
            quickSort(a, partitionIndex + 1, endIndex);
        }
    }


    /**
     *  92 50 5 20 11 22
        0 ... 5
        pivot = 22
        indexPivot = -1, 0, 1, 2

        92 < 22 i = 0
        50 < 22 i = 1
        5 < 22 i = 2
        swap 2 0
        5 50 92 20 11 22

        20 < 22 i = 3
        swap 3, 1
        5 20 92 50 11 22

        11 < 22 i = 4
        swap 4, 2
        5 20 11 50 92 22

        After loop swap the last element with indexPivot + 1 = 3,
        because indexPivot starts at -1,
        so the pivot element comes at the correct position
        swap 3, 5
        5 20 11 22 92 50

        return 2 + 1 = 3 as pivotIndex
     */
    private static int partitionByPivot(int[] a, int startIndex, int endIndex) {
        int pivot = a[endIndex];
        int indexForPivot = startIndex - 1;

        for (int i = startIndex; i < endIndex; i++) {
            if(a[i] < pivot){
                indexForPivot ++;
                int temp = a[indexForPivot];
                a[indexForPivot] = a[i];
                a[i] = temp;
            }
        }
        int temp = a[indexForPivot + 1];
        a[indexForPivot + 1] = a[endIndex];
        a[endIndex] = temp;

        return indexForPivot + 1;
    }
}
