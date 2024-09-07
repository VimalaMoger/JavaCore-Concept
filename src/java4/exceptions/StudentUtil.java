package java4.exceptions;

public class StudentUtil {
	public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws MissingGradeException {
        // throw IllegalArgumentException with the message that lengths of input arrays are out-of-sync
        if(studentsGrades.length != studentIdList.length) {
        	throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync. studentIdList.length:  " + studentIdList.length + ", studentsGrades.length: " + studentsGrades.length);
        	//unchecked exception, compiler never checks, no need to declare or handle
        }
        double[] gpaList = new double[studentIdList.length];
        
        for (int i = 0; i < studentsGrades.length; i++) {
            double gpa = 0.0;
            
            for (int j = 0; j < studentsGrades[i].length; j++) {

                if (studentsGrades[i][j] == 'A') {
                    gpa += 4.0;
                } else if (studentsGrades[i][j] == 'B') {
                    gpa += 3.0;
                } else if (studentsGrades[i][j] == 'C') {
                    gpa += 2.0;
                } else if (studentsGrades[i][j] == ' ') {
                    // student is yet to receive a grade
                    // throw checked exception MissingGradeException with student ID
                    throw new MissingGradeException(studentIdList[i]);
                    //checked exception: need to declare , need to handle it at the end point
                }
            }
            gpaList[i] = gpa/studentsGrades[i].length;
        }
        return gpaList;
    }    
    
     
    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) throws InvalidDataException {
        if (lower < 0 || higher < 0 || lower > higher) {
            return null;
        }
        
        double[] gpaList = new double[studentIdList.length];
        // catch MissingGradeException and re-throw runtime exception InvalidDataException initialized with the cause MissingGradeException
     
    	try {   
    	   gpaList = calculateGPA(studentIdList, studentsGrades);
      
    	}catch(MissingGradeException m) {
    		throw new InvalidDataException("error from MissingGradeException" ,m);
    		//chaining exception: it is required to maintain stacktrace from the exception at the lowest layer, to the one at the highest layer
    		//re-throw multiple exceptions across different abstraction layers of a program
    	}
        
        int count = 0;
        for (double gpa : gpaList) {
            if (gpa >= lower && gpa <= higher) {
                count++;
            }
        }
        
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i <  gpaList.length; i++) {
            if (gpaList[i] >= lower && gpaList[i] <= higher) {
                result[index++] = studentIdList[i];
            }
        }
        return result;
    }        
    
    

}
