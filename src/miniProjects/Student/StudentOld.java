package miniProjects.Student;

public class StudentOld {
    //instance variables
    int id = 1000;
    String name = "John";
    String gender = "Male";
    byte age = 18;
    long phone = 223_456_7890L;
    double gpa = 3.8;
    char degree = 'B';
    boolean international;  //false by default
    double tuitionFees = 12000.0;
    double internationFees = 5000.0;

    //computing the tution fees
    void compute(){
        //local variable
        int nextId = id + 1;
        if(international){
            tuitionFees += internationFees;
        }
        System.out.println(tuitionFees);
    }

    public static void main(String[] args) {
        StudentOld student = new StudentOld();
        student.compute();
    }
}
