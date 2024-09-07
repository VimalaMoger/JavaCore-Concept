package java4.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {

	private int id;
	private String name;
	private int iGender;
	private String gender;
	private int age;
	private long phone;
	private double gpa;
	private char degree;
	private boolean international;
	private double tuitionFees = 12000.0;
	private double internationalFees = 5000.0;
	static int studentCount;

	public void setGender(String gender) {
		if (gender.equals("male")) {
			iGender = 1;
		} else if (gender.equals("female")) {
			iGender = 2;
		} else if (gender.equals("transgender")) {
			iGender = 3;
		}
		if (iGender == 0) {
			throw new IllegalArgumentException("Invalid gender!!");			
		} else {
			this.gender = gender;
		}
		
	}

	public Student(int newId, String newName, String newGender, int newAge, long newPhone, double newGpa,
			char newDegree) {
		// calling another constructor
		this(newId, newName, newGender, newAge, newPhone, newGpa, newDegree, false);
	}

	public Student(int id, String name, String gender, int age, long phone, double gpa, char degree,
			boolean international) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.gpa = gpa;
		this.degree = degree;
		this.international = international;

		studentCount = studentCount + 1;
		int nextId = id + 1;

		if (international) {
			tuitionFees = tuitionFees + internationalFees;
		}

		System.out.println("\nid: " + this.id);
		System.out.println("nextId: " + nextId);
		System.out.println("name: " + this.name);
		System.out.println("gender: " + this.gender);
		System.out.println("age: " + this.age);
		System.out.println("phone: " + this.phone);
		System.out.println("gpa: " + this.gpa);
		System.out.println("degree: " + this.degree);
		System.out.println("tuitionFees: " + tuitionFees);
		System.out.println("studentCount: " + studentCount);

	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", iGender=" + iGender + ", gender=" + gender + ", age=" + age
				+ ", phone=" + phone + ", gpa=" + gpa + ", degree=" + degree + ", international=" + international
				+ ", tuitionFees=" + tuitionFees + ", internationalFees=" + internationalFees + "]";
	}

	public boolean updateProfile(String name) {
		this.name = name;
		return true;
	}

}

	


