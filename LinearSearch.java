
public class LinearSearch {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {2,4,5,4,7,8,9};
        int searchElement = 7;
        linearSearch(a,searchElement);

    }
    public static void linearSearch(int a[],int searchElement){
        for(int i = 0;i<=a.length-1;i++){
            if(searchElement == a[i]){
                System.out.println("element found at indexPosition: "+ i);
            }
        }
    }
}
