
public class Sumof2DArray {

    public static void main(String[] args) {
        int[][] array1 = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        int[][] array2 = {{1, 2, 3, 4}, {5, 6, 7, 8}};


        printArray(array1);

        System.out.println();

        printArray(array2);

        System.out.println();

        int[][] array3 = new int[2][4];
        for (int row = 0; row < array1.length; row++) {
            for (int col = 0; col < array1[row].length; col++) {
                array3[row][col] = array1[row][col] + array2[row][col];
            }
        }
        printArray(array3);

    }

    private static void printArray(int[][] array1) {
        for (int row = 0; row < array1.length; row++) {
            for (int col = 0; col < array1[row].length; col++) {
                System.out.print(array1[row][col] + " ");
            }
            System.out.println();
        }
    }
}
