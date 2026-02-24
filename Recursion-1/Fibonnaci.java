public class Fibonnaci {
    public static int fibonnaci(int n){
        if(n==0 || n==1){
            return n;
        }

        int fnm1 = fibonnaci(n-1);
        int fnm2 = fibonnaci(n-2);
        int fnm = fnm1 + fnm2;
        return fnm;
    }

    public static void main(String[] args){
        int n = 30;
        System.out.println(fibonnaci(n));
    }
}
