package java4.exceptions;

public class StudentTest {

	public static void main(String[] args) {

		int[] ids = { 1001, 1002, 1003 };
		//char[][] grades = { { 'A' }, { 'B' },{' '}}; //this will throw missing grade exception, gpa not calculated
		char[][] grades = { { 'A' }, { 'B' },{'C'}}; //gives all the results
		System.out.println("grades.length "+grades.length);
		StudentUtil su = new StudentUtil();
		double[] gpa = new double[ids.length];
		int[] result = new int[ids.length];

		try {
			gpa = su.calculateGPA(ids, grades);
			System.out.println(gpa.length+" "+gpa);
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (MissingGradeException e) {
			e.printStackTrace();
		}

		for (double gpas : gpa) {
			System.out.println("gpas "+ gpas);
		}

		try {
			result = su.getStudentsByGPA(2, 4, ids, grades);
		} catch (InvalidDataException e) {
			e.printStackTrace();
		}
		for (int i : result) {
			System.out.println(i);
		}

	}

}
