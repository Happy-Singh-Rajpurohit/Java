import java.util.*;

public class CopyConstructors {
    public static void main(String args[]){
        Student s1 = new Student();
        s1.name = "Happy";
        s1.roll = 101;
        s1.password = "mypassword";
        s1.marks[0] = 85;
        s1.marks[1] = 90;
        s1.marks[2] = 95;

        Student s2 = new Student(s1);
        s2.password = "newpassword";
        s1.marks[0] = 50;

        for(int i=0; i<3; i++){
            System.out.println(s2.marks[i]);
        }
    }
}

class Student{
    String name;
    int roll;
    String password;
    int marks[];

    //Shallow Copy Constructor - copies the reference of the array
    // Student(Student s1){
    //     this.name = s1.name;
    //     this.roll = s1.roll;
    //     this.marks = s1.marks;
    // }

    //Deep Copy Constructor - creates a new array and copies the values
    Student(Student s1){
        this.name = s1.name;
        this.roll = s1.roll;
        this.marks = new int[3];
        for(int i=0; i<3; i++){
            this.marks[i] = s1.marks[i];
        }
    }



    Student(){
        System.out.println("Constructor called");
        this.marks = new int[3];
    }
}