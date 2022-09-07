
public class SearchAnElemtneeinA2DArray {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}};

        printArray(array);

        //Time Complexity: O(m*n)
        searchElementByLinearSearch(array, 7);

        //Time Complexity: O(m + n)
        searchElementByBinarySearch(array, 7);

        //Time Complexity: O(log(m*n)) = O(log(m) + log(n))
        searchElementByConvertingToSingleArrayAndBinarySearch(array, 7);

    }

    private static void searchElementByConvertingToSingleArrayAndBinarySearch(int[][] array, int elementToBeSearched) {
        int row = 0, col = array.length *  array[0].length - 1;
        while(row != col){
            int mid = (row + col - 1)/2;
            if(array[mid / array[0].length][mid % array[0].length] < elementToBeSearched)
                row = mid + 1;
            else
                col = mid;
        }
        if(array[col / array[0].length][col % array[0].length]  == elementToBeSearched){
            System.out.println("Element found at :"  + row + " position");
            return;
        }
        System.out.println("Element Not fonud");
    }

    private static void searchElementByBinarySearch(int[][] array, int elementToBeSearched) {
        int row = 0, col = array[0].length - 1;
        while(row >= 0 && col < array[0].length){
            if(array[row][col] == elementToBeSearched){
                System.out.println("Element found at : [" + (row+1) + "," + (col+1) + "]");
                return;
            }else if(array[row][col] > elementToBeSearched){
                col--;
            }else{
                row++;
            }
        }
        System.out.println("Element Not fonud");
    }

    private static void searchElementByLinearSearch(int[][] array, int elementToBeSearched) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if(array[row][col] == elementToBeSearched){
                    System.out.println("Element found at : [" + (row+1) + "," + (col+1) + "]");
                    return;
                }
            }
        }
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