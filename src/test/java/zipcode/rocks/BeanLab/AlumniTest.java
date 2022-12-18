package zipcode.rocks.BeanLab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import zipcode.rocks.BeanLab.Alumni.Alumni;
import zipcode.rocks.BeanLab.Config.InstructorsConfig;
import zipcode.rocks.BeanLab.Config.StudentConfig;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class AlumniTest {

    @Autowired
    Alumni alumni;

    @Autowired
    InstructorsConfig iConfig;

    @Autowired
    StudentConfig sConfig;
    
    @Test
    public void numberOfHoursTaughtTest() {
        double expected = (alumni.getStudents().size() * 1200) / alumni.getInstructors().size();
        assertEquals(expected, sConfig.previousStudents().size() * 1200 / iConfig.instructors().size());
    }

    @Test
    public void numberOfHoursToTeachTest() {
        double expected = alumni.getStudents().size() * 1200;
        assertEquals(expected, sConfig.previousStudents().size() * 1200);
    }
}
