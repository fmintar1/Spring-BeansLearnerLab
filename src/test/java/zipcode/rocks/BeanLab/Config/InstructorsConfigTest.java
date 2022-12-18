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

import zipcode.rocks.BeanLab.Models.Instructor;
import zipcode.rocks.BeanLab.Models.Instructors;

@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = InstructorsConfig.class)
public class InstructorsConfigTest {
    
    @Autowired
    InstructorsConfig instructorsConfig;

    @Autowired
    @Qualifier("tcUkInstructors")
    Instructors tcUkInstructors;

    @Autowired
    @Qualifier("tcUsaInstructors") //<-- Empty or no qualifier will result in UnsatisfiedDependencyException
    Instructors tcUsaInstructors;

    @Autowired
    Instructors instructors;

    @Test
    public void instructorsConfigTest() {
        assertEquals(instructorsConfig.instructors().size(), 5);
        assertEquals(instructors.size(), 5);
    }

    @Test
    public void addToInstructorsTest() {
        instructorsConfig.instructors().add(new Instructor(6L, "Unknown Teacher"));
        assertEquals(instructorsConfig.instructors().findById(6L).getName(), "Unknown Teacher");
        assertEquals(instructorsConfig.instructors().size(), 6);
        assertEquals(instructors.size(), 6);
    }

    @Test
    public void removeInstructorTest() {
        instructorsConfig.instructors().remove(instructorsConfig.instructors().findById(5L));
        assertEquals(instructors.size(), 4);
    }

    @Test
    public void ukInstructorsConfigTest() {
        assertEquals(instructorsConfig.tcUkInstructors().size(), 4);
        assertEquals(tcUkInstructors.size(), 4);
    }

    @Test
    public void addToUkInstructorsTest() {
        instructorsConfig.tcUkInstructors().add(new Instructor(5L, "Unknown Teacher"));
        assertEquals(instructorsConfig.tcUkInstructors().findById(5L).getName(), "Unknown Teacher");
        assertEquals(instructorsConfig.tcUkInstructors().size(), 5);
        assertEquals(tcUkInstructors.size(), 5);
    }

    @Test
    public void removeUkInstructorTest() {
        instructorsConfig.tcUkInstructors().remove(instructorsConfig.tcUkInstructors().findById(4L));
        assertEquals(tcUkInstructors.size(), 3);
    }

    @Test
    public void usaInstructorsConfigTest() {
        assertEquals(instructorsConfig.tcUsaInstructors().size(), 3);
        assertEquals(tcUsaInstructors.size(), 3);
    }

    @Test
    public void addToUsaInstructorsTest() {
        instructorsConfig.tcUsaInstructors().add(new Instructor(4L, "Unknown Teacher"));
        assertEquals(instructorsConfig.tcUsaInstructors().findById(4L).getName(), "Unknown Teacher");
        assertEquals(instructorsConfig.tcUsaInstructors().size(), 4);
        assertEquals(tcUsaInstructors.size(), 4);
    }

    @Test
    public void removeUsaInstructorTest() {
        instructorsConfig.tcUsaInstructors().remove(instructorsConfig.tcUsaInstructors().findById(3L));
        assertEquals(tcUsaInstructors.size(), 2);
    }

}
