import java.util.*;

public class Constructors {
    public static void main(String args[]){
        Student student1 = new Student();
    }
}

class Student{
    String name;
    int roll;

    Student(){
        System.out.println("Constructor called");
    }
}