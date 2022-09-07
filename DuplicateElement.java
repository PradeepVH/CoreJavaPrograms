
public class DuplicateElement {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DuplicateElement d = new DuplicateElement();
        int a[] = {2,5,4,3,4,7,3,7,5,2};
        int a_size = a.length;
        //        duplicateElements(a);
                d.duplicateElements2(a,a_size);
    }

    //    public static void duplicateElements(int a[]){
    //        for(int i = 0;i<=a.length-1;i++){
    //            for(int j=i+1;j<=a.length-1;j++){
    //                if(a[i] == a[j]){
    //                    System.out.println("duplicate elements are :" + a[i]);
    //                }
    //            }
    //        }
    //    }
    void duplicateElements2(int a[],int size){
        int count[] = new int[size];
        int i;
        System.out.println("repeated elements are:  ");
        for(i=0;i<size;i++)
        {
            if(count[a[i]%size] == a[i]){
                System.out.print(a[i] + " ");
            }
            else{
                count[a[i]%size] = a[i];
            }
        }

    }

}
