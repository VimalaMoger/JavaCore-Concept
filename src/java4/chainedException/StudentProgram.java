package java4.chainedException;

public class StudentProgram {
	void studentProgram() {}
	 
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        StudentManager manager = new StudentManager(dao);
 
        try {
            manager.findStudents("Tom");
        } catch (StudentException ex) {
            ex.printStackTrace();
        }
    }
}
