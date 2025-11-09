public class Inheritance {
   public static void main(String args[]){
       Fish goldfish = new Fish();
       goldfish.colour = "Golden";
       goldfish.fins = 4;
       goldfish.eat();
       goldfish.breathe();
       goldfish.swim();
       
   }
}

//Base Class
class Animal{
    String colour;

    void eat(){
        System.out.println("Eating...");
    }

    void breathe(){
        System.out.println("Breathing...");
    }
}


//Derived class
class Fish extends Animal{
    int fins;

    void swim(){
        System.out.println("Swimming...");
    }
}