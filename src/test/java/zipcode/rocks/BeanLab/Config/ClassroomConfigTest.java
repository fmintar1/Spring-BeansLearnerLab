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

import zipcode.rocks.BeanLab.Models.Classroom;
import zipcode.rocks.BeanLab.Models.Instructor;
import zipcode.rocks.BeanLab.Models.Student;
import zipcode.rocks.BeanLab.Models.Students;

@ContextConfiguration(classes = {ClassroomConfig.class, InstructorsConfig.class, StudentConfig.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ClassroomConfigTest {
    
    @Autowired
    ClassroomConfig classroomConfig;

    @Autowired
    @Qualifier("currentCohort")
    Classroom currentCohort;

    @Autowired
    @Qualifier("previousCohort")
    Classroom previousCohort;

    @Test
    public void classroomConfigTest() {
        assertEquals(classroomConfig.currentCohort().getInstructors().size(), 5);
        assertEquals(currentCohort.getInstructors().size(), 5);
        assertEquals(classroomConfig.currentCohort().getStudents().size(), 23);
        assertEquals(currentCohort.getStudents().size(), 23);
    }

    @Test
    public void addToClassroomTest() {
        classroomConfig.currentCohort().getInstructors().add(new Instructor(6L, "Unknown Teacher"));
        assertEquals(classroomConfig.currentCohort().getInstructors().findById(6L).getName(), "Unknown Teacher");
        assertEquals(classroomConfig.currentCohort().getInstructors().size(), 6);
        assertEquals(currentCohort.getInstructors().size(), 6);
        classroomConfig.currentCohort().getStudents().add(new Student(24L, "Unknown Student"));
        assertEquals(classroomConfig.currentCohort().getStudents().findById(24L).getName(), "Unknown Student");
        assertEquals(classroomConfig.currentCohort().getStudents().size(), 24);
        assertEquals(currentCohort.getStudents().size(), 24);
    }

    @Test
    public void removeClassroomTest() {
        classroomConfig.currentCohort().getInstructors().remove(classroomConfig.currentCohort().getInstructors().findById(5L));
        assertEquals(currentCohort.getInstructors().size(), 4);
        classroomConfig.currentCohort().getStudents().remove(classroomConfig.currentCohort().getStudents().findById(23L));
        assertEquals(currentCohort.getStudents().size(), 22);
    }

    @Test
    public void prevClassroomConfigTest() {
        assertEquals(classroomConfig.previousCohort().getInstructors().size(), 5);
        assertEquals(previousCohort.getInstructors().size(), 5);
        assertEquals(classroomConfig.previousCohort().getStudents().size(), 3);
        assertEquals(previousCohort.getStudents().size(), 3);
    }

    @Test
    public void addToprevClassroomTest() {
        classroomConfig.previousCohort().getInstructors().add(new Instructor(6L, "Unknown Teacher"));
        assertEquals(classroomConfig.previousCohort().getInstructors().findById(6L).getName(), "Unknown Teacher");
        assertEquals(classroomConfig.previousCohort().getInstructors().size(), 6);
        assertEquals(previousCohort.getInstructors().size(), 6);
        classroomConfig.previousCohort().getStudents().add(new Student(4L, "Unknown Student"));
        assertEquals(classroomConfig.previousCohort().getStudents().findById(4L).getName(), "Unknown Student");
        assertEquals(classroomConfig.previousCohort().getStudents().size(), 4);
        assertEquals(previousCohort.getInstructors().size(), 6);
    }

    @Test
    public void removePrevClassroomTest() {
        classroomConfig.previousCohort().getInstructors().remove(classroomConfig.currentCohort().getInstructors().findById(5L));
        assertEquals(previousCohort.getInstructors().size(), 4);
        classroomConfig.previousCohort().getStudents().remove(classroomConfig.previousCohort().getStudents().findById(3L));
        assertEquals(previousCohort.getStudents().size(), 2);
    }
}
