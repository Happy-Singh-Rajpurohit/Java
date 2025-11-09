public class AbstractClass {
    public static void main(String[] args) {
    //     horse h = new horse();
    //     h.eat();
    //     h.walk();
        Mustang m = new Mustang();

    //     Chicken c = new Chicken();
    //     c.eat();
    //     c.walk();
    }
}


abstract class Animal{
    String colour;

    Animal(){
        // colour = "brown";
        System.out.println("Animal constructor called");
    }

    void eat(){
        System.out.println("Eating...");
    }
    abstract void walk(); //Doesn't give implementation just give idea that every animal walk
}



class horse extends Animal{
    // void changeColour(String newColour){
    //     colour = newColour;
    // }
    horse(){
        System.out.println("Horse constructor called");
    }
    void walk(){
        System.out.println("Walking on 4 legs");
    }
}

class Mustang extends horse{
    Mustang(){
        System.out.println("Mustang constructor called");
    }
}

class Chicken extends Animal{
    // void changeColour(String newColour){
    //     colour = newColour;
    // }
    void walk(){
        System.out.println("Walking on 2 legs");
    }
}