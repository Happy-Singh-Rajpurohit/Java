package Backtracking;

public class FindSubsets {
    public static void findSubsets(int arr[], int index, String set){
        // Base Case
        if(index == arr.length){
            System.out.println(set);
            return;
        }

        // Include
        findSubsets(arr, index + 1, set + arr[index] + " ");

        // Exclude
        findSubsets(arr, index + 1, set);
    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 2};
        findSubsets(arr, 0, "");
    }

}
