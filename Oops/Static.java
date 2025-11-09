public class Static {
    public static void main(String[] args) {
        Student.schoolName = "ABC School";

        Student student1 = new Student();
        student1.setName("John");
        student1.getName();
        System.out.println("School Name: " + Student.schoolName);

        student1.schoolName = "XYZ School";
        Student student2 = new Student();
        student2.setName("Alice");
        student2.getName();
        System.out.println("School Name: " + Student.schoolName);
    }
}


class Student{
    String name;
    int roll;

    static String schoolName;

    void setName(String name){
        this.name = name;
    }

    void getName(){
        System.out.println("Name: " + this.name);
    }
}