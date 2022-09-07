
public class SelectionSort {

    public static void main(String[] args) {
        int a[] = { 92, 50, 5, 20, 11, 22 };
        System.out.println("Before sorting array elements are - ");
        printElements(a);
        selectionSort(a);
        System.out.println("\nAfter sorting array elements are - ");
        printElements(a);

    }

    private static void printElements(int[] a) {
        for (int i : a) {
            System.out.print(i+ " ");
        }
    }

    private static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int smallestElementPos = i;

            for (int j = i+1; j < a.length; j++) {
                if(a[smallestElementPos] > a[j]){
                    smallestElementPos = j;
                }
            }
            int temp = a[smallestElementPos];
            a[smallestElementPos] = a[i];
            a[i] = temp;
        }
    }
}
