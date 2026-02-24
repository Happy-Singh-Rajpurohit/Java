public class OptimizedPower {
    public static int OptimizedPower(int x, int n){
        if(n ==0){
            return 1;
        }
        int halfPower = OptimizedPower(x, n/2) * OptimizedPower(x, n/2);

        if(n%2 != 0){
            halfPower = x * halfPower;
        }
        return halfPower;
    }

    public static void main(String[] args) {
        System.out.println(OptimizedPower(2,10));
    }
}
