public class LastOccurence {
    // public static int lastOccurence(int arr[], int i, int key){
    //     if(i == -1){
    //         return -1;
    //     }
    //     if(arr[i] == key){
    //         return i;
    //     }
    //     return lastOccurence(arr, i-1, key);
    // }

    public static int lastOccurence(int arr[], int i, int key){
        if(i == arr.length-1){
            return -1;
        }
        int isFound = lastOccurence(arr, i+1, key);
        if(isFound == -1 && arr[i] == key){
            return i;
        }
        return isFound;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,6,10};
        int key = 6;
        int i = arr.length-1;
        System.out.println(lastOccurence(arr, i, key));
    }
}
