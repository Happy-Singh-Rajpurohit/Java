import java.util.*;

public class ReverseNumber {
    public static int reverseNumber(int n){
        if(n==1){
            System.out.println(n);
            return 0;
        }
        System.out.print(n+" ");
        return reverseNumber(n-1);
    }

    public static int printInc(int n){
        if(n==1){
            System.out.print(n+" ");
            return 0;
        }
        printInc(n-1);
        System.out.print(n+" ");
        return 0;
    }

    public static void main(String[] args) {
        reverseNumber(10);
        printInc(10);
    }
}
