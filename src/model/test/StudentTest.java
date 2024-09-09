package model.test;

import model.Student.Student;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class StudentTest {
    @Test
    public void testStudent() {
        Student student = new Student(1000, "John", "Male", (byte) 18, 223_456_7890L, 3.8, 'B', false);

        Assert.assertEquals(2000.0, student.getTuitionFees(), 0);
    }
}
