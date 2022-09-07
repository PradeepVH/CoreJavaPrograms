
public class BinarySearachProgram {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {2,3,5,8,9};
        int searchElement = 3;
        //int searchIndex = binarySearchIteration(a, searchElement);
        int searchIndex = binarySearchRecursive(a, 0, a.length - 1,searchElement);
        if(searchIndex == -1){
            System.out.println("Element not found");
        }else{
            System.out.println("Search elemtne found at : " + searchIndex);
            System.out.println("The element is  : " + a[searchIndex]);
        }

    }

    private static int binarySearchIteration(int array[], int searchElement){
        int firstIndex = 0; int lastIndex = array.length - 1;

        while(firstIndex <= lastIndex){
            int middleIndex = (firstIndex + lastIndex) / 2;
            //int middleIndex = firstIndex + (lastIndex - firstIndex) / 2;

            if(searchElement == array[middleIndex]){
                return middleIndex;
            }

            if(searchElement < array[middleIndex]){
                lastIndex = middleIndex - 1;
            }else if (searchElement > array[middleIndex]){
                firstIndex = middleIndex + 1;
            }
        }
        return -1;
    }

    private static int binarySearchRecursive(int array[], int firstIndex, int lastIndex, int searchElement){

        //if(firstIndex <= lastIndex){
            int middleIndex = (firstIndex + lastIndex) / 2;

            if(searchElement == array[middleIndex]){
                return middleIndex;
            }

            if(searchElement < array[middleIndex]){
                return binarySearchRecursive (array, firstIndex, middleIndex - 1, searchElement );
            }else if (searchElement > array[middleIndex]){
                return binarySearchRecursive (array, middleIndex + 1, lastIndex, searchElement );
            }
        //}
        return -1;
    }
}

