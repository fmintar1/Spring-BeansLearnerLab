package zipcode.rocks.BeanLab.Config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import zipcode.rocks.BeanLab.Models.Student;
import zipcode.rocks.BeanLab.Models.Students;

// @ExtendWith(SpringExtension.class)
// @ContextConfiguration(classes = StudentConfig.class)
public class StudentConfigTest {
    
    // @Autowired
    StudentConfig studentConfig = new StudentConfig();

    @Test
    // @Qualifier("students")
    public void studentConfigtest() {
        assertEquals(studentConfig.currentStudents().size(), 23);

    }

    @Test
    @Qualifier("previousStudents")
    public Students previousStudents(List<Student> currentCohort) {
        return new Students(currentCohort);
    }

}
