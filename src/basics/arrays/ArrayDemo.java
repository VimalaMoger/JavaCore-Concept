package basics.arrays;

import model.Student.Student;

import java.util.Arrays;

public class ArrayDemo {
    static void arrays(){
        System.out.println("\nInside arrays ..");
        int[] scores = {90, 70,80,100};
        System.out.println("Mid-Term 1:" + scores[0]);
        System.out.println("Mid-Term 2:" + scores[1]);
        System.out.println("Final:" + scores[2]);
        System.out.println("Project:" + scores[3]);

    }
    public static void main(String[] args) {
        //arrays
        arrays();
        Student[] students = {new Student(), new Student(),new Student()};
        students[0].name = "John";
        students[1].name ="Raj";
        students[2].name = "Anita";
        System.out.println(Arrays.toString(students));
        System.out.println(students[0].name);

    }
}
