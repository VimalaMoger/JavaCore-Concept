package miniProjects.Student;

import org.junit.Assert.*;

import java.util.Arrays;

public class Student {
    //class/static variable
    static int computeCount;

    //instance variables
    int id ;
   // id = 400; //cannot be reinitialized directly within the class
    String name ;
    String gender = "Male";
    byte age ;
    long phone ;
    double gpa ;
    char degree ;
    boolean international;  //false by default
    double tuitionFees ;
    double internationFees ;



    //computing the tution fees
    void compute(){
        //local variable
        int nextId = id + 1;
        int localVal;
        computeCount++;
        if(international){
            tuitionFees += internationFees;
        }
        System.out.println("tuitionFees "+ tuitionFees);
        System.out.println("computeCount "+ computeCount);
        //System.out.println("localVal "+ localVal);  //initialization error
    }

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.id = 1000;
        student1.name = "John";
        student1.gender = "Male";
        student1.age = 18;
        student1.phone = 223_456_7890L;
        student1.gpa = 3.8;
        student1.degree = 'B';
        student1.international = false;
        student1.tuitionFees = 12000.0;
        student1.internationFees = 5000.0;
        student1.compute();

        Student student2 = new Student();
        student2.id = 1000;
        student2.name = "John";
        student2.gender = "Male";
        student2.age = 18;
        student2.phone = 223_456_7890L;
        student2.gpa = 3.8;
        student2.degree = 'B';
        student2.international = true;
        student2.tuitionFees = 12000.0;
        student2.internationFees = 5000.0;
        student2.compute();

        System.out.println(Student.computeCount);
    }
}

