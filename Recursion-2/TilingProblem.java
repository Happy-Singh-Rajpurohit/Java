public class TilingProblem {
    public static int TilingProblem(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        
        //Vertical
        int fnm1 = TilingProblem(n-1);

        //Horizontal
        int fnm2 = TilingProblem(n-2);

        int totalWays = fnm1 + fnm2;
        return totalWays;
    }

    public static void main(String[] args) {
        System.out.println(TilingProblem(4));
    }
}
