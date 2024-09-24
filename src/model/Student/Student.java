package model.Student;

import lombok.Data;
import java.util.Arrays;

@Data
public class Student {
    //class/static variable
    static int studentCount;

    //instance variables
    int id ;
   // id = 400; //cannot be reinitialized directly within the class
    public String name ;
    String gender = "Male";
    byte age ;
    long phone ;
    double gpa ;
    char degree ;
    boolean international;  //false by default
    double tuitionFees = 2000.0;
    double internationFees = 5000.0;

    //Overloaded constructors
    public Student(){}
    public Student(int newId, String newName, String newGender,byte newAge, long newPhone, double newGpa, char newDegree, boolean isInternational) {
        this(newId, newName, newGender, newAge, newPhone, newGpa, newDegree);
        this.international = isInternational;
        compute(isInternational);
    }
    public void compute(boolean isInternational){
        //computing the tution fees
        studentCount++;
        if(isInternational){
            this.tuitionFees += internationFees;
        }
        System.out.println("tuitionFees "+ tuitionFees);
        System.out.println("studentCount "+ studentCount);
        //System.out.println("localVal "+ localVal);  //initialization error
    }
    public Student(int newId, String newName, String newGender,byte newAge, long newPhone, double newGpa, char newDegree){
        this.id = newId;
        this.name =  newName;
        this.gender = newGender;
        this.age =  newAge;
        this.phone = newPhone;
        this.gpa = newGpa;
        this.degree = newDegree;
    }

    @Override
    public String toString(){
        return "Id "+ this.id+", Name: "+this.name + ", Gender: "+ this.gender +", Age: "+this.age+", Phone: "+this.phone+", GPA: "+this.gpa+", Degree: "+this.degree +", isInternational: "+this.international+", Tution Fees: "+this.tuitionFees;
    }
    //to demonstrate nullpointerexception
    static Student student3;

    public static void main(String[] args) {
        Student student1 = new Student(1000,"John","Male", (byte) 18, 223_456_7890L, 3.8, 'B');
       // System.out.println("student2 " +student1);

        Student student2 = new Student(1001,"John","Male", (byte) 18,223_456_7890L,3.8,'B',true);
        //System.out.println("student2 " +student2);

        Student student3 = new Student(1002,"John","Male", (byte) 18,223_456_7890L,3.8,'B',true);

       // student3.id = 1003;  //nullpointerException
        System.out.println(Student.studentCount);
        Student [] students = {student1,student2,student3};
        //swap students 0,2 positions
        swap(students,0,2);
        System.out.println(Arrays.toString(students));
    }
    //swap positions
    static void swap(Student[] students, int firstIndex, int lastIndex){
        Student temp = students[0];
        students[0] = students[2];
        students[2] = temp;
    }
}

