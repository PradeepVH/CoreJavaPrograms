
public class SeachASubStringInAString {

    public static void main(String[] args) {

        String str = "Geeksforgeeksandgeeasforgaeeks";

        int index = str.indexOf("geeks");
        System.out.println(index);

        boolean seq = str.contains("geeks");
        System.out.println(seq);
    }

}
