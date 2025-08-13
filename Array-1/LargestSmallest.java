import java.util.*;

public class LargestSmallest {
    public static int getLargest(int numbers[]){
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for(int i=0; i<numbers.length; i++){
            if(largest < numbers[i]){
                largest = numbers[i];
            }
            if(smallest > numbers[i]){
                smallest = numbers[i];
            }
        }
        System.out.println("Smallest Value: "+smallest);
        return largest;
    }

    public static void main(String[] args) {
        int numbers[] = {1, 4, 5, 9, 245, 567, 7, 86};

    
        System.out.println("The largest number is: "+ getLargest(numbers));
    }
}
