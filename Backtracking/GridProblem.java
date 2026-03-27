public class GridProblem {
    public static int countPaths(int i, int j, int m, int n){
        if(i==n-1 || j == m-1){
            return 1;
        }else if(i==n || j==n){
            return 0;
        }

        //Downwards
        int downPaths = countPaths(i+1, j, n, m);

        //Rightwards
        int rightPaths = countPaths(i, j+1, n, m);

        int totalPaths = downPaths + rightPaths;
        return totalPaths;
    }

    public static void main(String[] args) {
            int m = 3;
            int n = 3;
    
            System.out.println(countPaths(0, 0, n, m));
    }
}
