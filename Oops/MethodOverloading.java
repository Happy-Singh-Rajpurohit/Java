public class MethodOverloading {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Sum of 2 and 3: " + calc.sum(2, 3));
        System.out.println("Sum of 2, 3 and 4: " + calc.sum(2, 3, 4));
        System.out.println("Sum of 2.5 and 3.5: " + calc.sum(2.5, 3.5));
    }
}

class Calculator{
    int sum(int a, int b){
        return a + b;
    }

    int sum(int a, int b, int c){
        return a + b + c;
    }

    double sum(double a, double b){
        return a + b;
    }
}