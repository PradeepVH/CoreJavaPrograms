
public class BinarySearch {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {5,6,8,10,12};
        int searchElement = 14;
        int firstIndex = 0, lastIndex = a.length-1;
        findElement(a,searchElement,firstIndex,lastIndex);
    }
    public static void findElement(int[] a, int searchElement, int firstIndex, int lastIndex){
        while(firstIndex <= lastIndex){
            int middleIndex = (firstIndex + lastIndex)/2;
            if(searchElement == a[middleIndex]){
                System.out.println("element found at "+ middleIndex);
                System.out.println("element is "+ a[middleIndex]);
                break;
            }
            else if(searchElement <= a[middleIndex]){
                lastIndex = middleIndex-1;
            }
            else if(searchElement >= a[middleIndex]){
                firstIndex = middleIndex+1;
            }

        }

    }
}
