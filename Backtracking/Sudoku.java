package Backtracking;

public class Sudoku {

    public static boolean isSafe(int sudoku[][], int row, int col, int digit){
        // Column
        for(int i=0; i<9; i++){
            if(sudoku[i][col] == digit){
                return false;
            }
        }

        // Row
        for(int j=0; j<9; j++){
            if(sudoku[row][j] == digit){
                return false;
            }
        }

        // Grid
        int sr = (row/3)*3;
        int sc = (col/3)*3;

        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solveSudoku(int sudoku[][], int row, int col){
        // Base Case
        if(row == 9){
            return true;
        }

        // Next cell
        int nextRow = row, nextCol = col + 1;
        if(col + 1 == 9){
            nextRow = row + 1;
            nextCol = 0;
        }

        // Skip filled cells
        if(sudoku[row][col] != 0){
            return solveSudoku(sudoku, nextRow, nextCol);
        }

        // Try digits
        for(int digit = 1; digit <= 9; digit++){
            if(isSafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit;

                if(solveSudoku(sudoku, nextRow, nextCol)){
                    return true;
                }

                sudoku[row][col] = 0; // backtrack
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int sudoku[][] = {
            {7, 0, 2, 0, 5, 0, 6, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0, 0},
            {1, 0, 0, 0, 0, 9, 5, 0, 0},
            {8, 0, 0, 0, 0, 0, 0, 9, 0},
            {0, 4, 3, 0, 0, 0, 7, 5, 0},
            {0, 9, 0, 0, 0, 0, 0, 0 ,8},
            {0 ,0 ,9 ,7 ,0 ,0 ,0 ,0 ,5},
            {0 ,0 ,0 ,2 ,6 ,0 ,0 ,0 ,1},
            {5 ,8 ,6 ,9 ,4 ,0 ,2 ,0 ,7}
        };

        if(solveSudoku(sudoku, 0, 0)){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Cannot Solve");
        }
    }
}