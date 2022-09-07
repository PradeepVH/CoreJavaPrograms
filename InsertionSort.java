
public class InsertionSort {

    public static void main(String[] args) {
        int a[] = { 92, 50, 5, 20, 11, 22 };
        System.out.println("Before sorting array elements are - ");
        printElements(a);
        insertionSort(a);
        System.out.println("\nAfter sorting array elements are - ");
        printElements(a);

    }

    private static void printElements(int[] a) {
        for (int i : a) {
            System.out.print(i+ " ");
        }
    }

    private static void insertionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int key = a[i];
            int previosElementPos = i - 1;

            while(previosElementPos >= 0 && key < a[previosElementPos]){
                a[previosElementPos + 1] = a[previosElementPos];
                previosElementPos --;
            }
            a[previosElementPos + 1] = key;
        }

    }

}
