import java.util.*;

public class Creation {
    // Function to search for a key in a 2D matrix
    public static boolean SearchMatrix(int[][] matrix, int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == key) {
                    System.out.println("Found at index: " + i + ", " + j);
                    return true;
                }
            }
        }
        System.out.println("Not Found");
        return false;
    }

    // Function to create and return a 2D array
    public static int[][] CreationArray() {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[3][3];
        int n = matrix.length; // number of rows
        int m = matrix[0].length; // number of columns

        System.out.println("Enter elements of a 3x3 matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Printing the 2D array
        System.out.println("Matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = CreationArray(); // Create the 2D matrix
        SearchMatrix(matrix, 6);          // Search for the number 6
    }
}
