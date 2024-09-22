package java8;

import java4.exceptions.Student;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StudentAnonymousFunction {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();

		Student student1 = new Student(1,"John", "Doel", 43,123, 3.0,'A');
		Student student2 = new Student(2,"Shally", "Rodrigas", 43,345, 4.0,'B');
		Student student3 = new Student(3,"Sham", "Austin", 43,678, 1.0,'C');
		Student[] stuArray= new Student[] {student1,student2,student3};
		students.add(student1);
		students.add(student2);
		students.add(student3);
		System.out.println("before comparator: " );
		for(Student s: stuArray) {
			System.out.println(s.getGpa());
		}
		
		Arrays.sort(stuArray, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return Double.compare(o1.getGpa(),o2.getGpa());
			}
		});
		System.out.println("Using Comparator .. " );
		System.out.println(Arrays.toString(stuArray));

		System.out.println(new Student() {
			@Override public String toString() {
				return String.valueOf(new Student(1,"John", "Doel", 43,123, 3.0,'A'));
			}
		});
	}
}