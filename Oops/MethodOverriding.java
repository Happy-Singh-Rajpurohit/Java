public class MethodOverriding {
    public static void main(String[] args) {
        deer d = new deer();
        d.eat();
    }
}


class Animal {
    void eat(){
        System.out.println("Eating Everything");
    }
}

class deer extends Animal {
    void eat(){
        System.out.println("Eating Grass");
    }
}