package zipcode.rocks.BeanLab.Config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import zipcode.rocks.BeanLab.Models.Student;
import zipcode.rocks.BeanLab.Models.Students;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = StudentConfig.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class StudentConfigTest {

    @Autowired
    StudentConfig studentConfig;

    @Autowired
    @Qualifier("students")
    Students studentsWithQualifier;

    @Autowired
    @Qualifier("previousStudents") //<-- Empty or no qualifier will result in UnsatisfiedDependencyException
    Students studentsWithoutQualifier;

    @Test
    public void studentConfigTest() {
        assertEquals(studentConfig.currentStudents().size(), 23);
        assertEquals(studentsWithQualifier.size(), 23);
    }

    @Test
    public void addToCurrentStudentTest() {
        studentConfig.currentStudents().add(new Student(24L, "Unknown Student"));
        assertEquals(studentConfig.currentStudents().findById(24L).getName(), "Unknown Student");
        assertEquals(studentConfig.currentStudents().size(), 24);
        assertEquals(studentsWithQualifier.size(), 24);
    }

    @Test
    public void removeStudentsTest() {
        studentConfig.currentStudents().remove(studentConfig.currentStudents().findById(23L));
        assertEquals(studentsWithQualifier.size(), 22);
    }

    @Test
    public void previousStudentsConfigTest() {
        assertEquals(studentConfig.previousStudents().size(), 3);
        assertEquals(studentsWithoutQualifier.size(), 3);
    }

    @Test
    public void addToPreviousStudentsTest() {
        studentConfig.previousStudents().add(new Student(4L, "Unknown Student"));
        assertEquals(studentConfig.previousStudents().findById(4L).getName(), "Unknown Student");
        assertEquals(studentConfig.previousStudents().size(), 4);
        assertEquals(studentsWithoutQualifier.size(), 4);
    }

    @Test
    public void removePrevStudentsTest() {
        studentConfig.previousStudents().remove(studentConfig.previousStudents().findById(3L));
        assertEquals(studentsWithoutQualifier.size(), 2);
    }
}