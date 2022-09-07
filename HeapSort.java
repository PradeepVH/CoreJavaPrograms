
public class HeapSort {

    public static void main(String[] args) {
        int a[] = { 92, 50, 5, 20, 11, 22 };
        System.out.println("Before sorting array elements are - ");
        printElements(a);
        heapSort(a);
        System.out.println("\nAfter sorting array elements are - ");
        printElements(a);

    }

    private static void printElements(int[] a) {
        for (int i : a) {
            System.out.print(i+ " ");
        }
    }

    private static void heapSort(int[] a) {
        int length = a.length;

        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(a, length, i);
        }

        //One by extract an element from heap
        //Move the current root element to end
        for (int i = length - 1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            heapify(a, i, 0);
        }
    }

    /**
     *  [92, 50, 5, 20, 11, 22]
        First iteration
        largest = 2
        left = 5
        right = 6

        22 > 5 largest = 5

        5 != 2 then
        swap 2, 5
        92, 50, 22, 20, 11, 5
        heapify(a, n, 5);

        largest = 5
        left = 11
        right = 12
        5 != 5 exit

        Next iteration
        largest = 1
        left = 3
        right = 4 exit

        Next iteration
        largest = 0
        left = 1
        right = 2 exit

        Next loop -
        swap 0, length-1 element
        as first element is highest after heapify
        Then call heapify method
        a, length-1, 0
     */
    private static void heapify(int[] a, int length, int index) {
        int largest = index; //inialize largest as root
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if(leftChild < length && a[leftChild] > a[largest]){
            largest = leftChild;
        }
        if(rightChild < length && a[rightChild] > a[largest]){
            largest = rightChild;
        }
        //If root is not largest, swap with root element
        if(largest != index){
            int swap = a[index];
            a[index] = a[largest];
            a[largest] = swap;
            heapify(a, length, largest);
        }
    }
}
