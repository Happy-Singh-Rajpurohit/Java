public class Super {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println("Dog colour: " + dog.color);
    }
    
}

class Animal{
    String color;

    Animal(){
        System.out.println("Animal constructor called");
    }
}

class Dog extends Animal{
    Dog(){
        super();
        super.color = "black";
        System.out.println("Dog constructor called");
    }
}