package java4.exceptions;

import javax.management.RuntimeErrorException;

public class MissingGradeException extends Exception {
	public int studentId;

	MissingGradeException(int id) {
		this.studentId = id;
	}

	public int getStudentId() {
		return studentId;
	}
}
