
public class BubbleSort {

    static void print (int a[]) //function to print array elements
    {
        int n = a.length;
        int i;
        for (i = 0; i < n; i++)
        {
            System.out.print(a[i] + " ");
        }
    }
    static void bubbleSort (int a[])    // function to implement bubble sort
    {
        int n = a.length;
        int i, j, temp;
        for (i = 0; i < n; i++)
        {
            for (j = i + 1; j < n; j++)
            {
                if (a[j] < a[i])
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    static void bubbleSort2 (int a[])    // function to implement bubble sort
    {
        int size = a.length;

        // loop to access each array element
        for (int i = 0; i < size - 1; i++)

          // loop to compare array elements
          for (int j = 0; j < size - i - 1; j++)

            // compare two adjacent elements
            // change > to < to sort in descending order
            if (a[j] > a[j + 1]) {

              // swapping occurs if elements
              // are not in the intended order
              int temp = a[j];
              a[j] = a[j + 1];
              a[j + 1] = temp;
            }
    }

    public static void main(String[] args) {
        int a[] = {35, 10, 31, 11, 26};
        BubbleSort b1 = new BubbleSort();
        System.out.println("Before sorting array elements are - ");
        b1.print(a);
        b1.bubbleSort(a);
        //b1.bubbleSort2(a);
        System.out.println();
        System.out.println("After sorting array elements are - ");
        b1.print(a);
    }

}
